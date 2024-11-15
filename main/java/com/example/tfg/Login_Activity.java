package com.example.tfg;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Login_Activity extends AppCompatActivity {

    // Declarar los elementos de la interfaz de usuario
    Button logginButton;
    Button crearButton;
    EditText email;
    EditText password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular las vistas del diseño con las variables de la actividad
        logginButton = findViewById(R.id.logginButton);
        crearButton = findViewById(R.id.crearButton);
        email = findViewById(R.id.emailEditext);
        password = findViewById(R.id.passwordEditext);

        // Definir el comportamiento del botón "Iniciar sesión"
        logginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos de los campos de texto
                String emailCode = email.getText().toString();
                String passwordCode = password.getText().toString();

                // Llamar a la tarea de inicio de sesión
                new LoginTask().execute(emailCode, passwordCode);
            }
        });

        // Definir el comportamiento del botón "Crear cuenta"
        crearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad de creación de cuenta
                Intent intent = new Intent(Login_Activity.this, CrearCuenta_Activity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Tarea asíncrona para realizar la solicitud HTTP al servidor PHP.
     */

    private class LoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String password = params[1];
            String response = "";

            try {
                // Cambia "10.0.2.2" por la IP de tu máquina si estás en un dispositivo físico
                String urlString = "http://10.0.2.2/api/login.php";  // Para emulador, usa 10.0.2.2
                URL url = new URL(urlString);

                // Establecer la conexión HTTP
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);

                // Codificar los parámetros correctamente
                String encodedEmail = URLEncoder.encode(email, "UTF-8");
                String encodedPassword = URLEncoder.encode(password, "UTF-8");

                // Enviar los parámetros POST
                String paramsString = "correo_electronico=" + encodedEmail + "&contrasena=" + encodedPassword;
                urlConnection.getOutputStream().write(paramsString.getBytes());

                // Leer la respuesta
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response += inputLine;
                }
                in.close();

                // Cerrar la conexión
                urlConnection.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // Aquí procesamos la respuesta del servidor
            if (result.contains("success")) {
                // Si el resultado contiene "success", el login fue exitoso
                Toast.makeText(Login_Activity.this, "Login exitoso", Toast.LENGTH_LONG).show();
                // Solo ahora se inicia la actividad principal
                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
            } else {
                // Si no, mostramos un mensaje de error
                Toast.makeText(Login_Activity.this, "Correo electrónico o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
        }
    }
}
