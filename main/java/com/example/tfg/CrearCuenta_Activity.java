package com.example.tfg;

import android.annotation.SuppressLint;
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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CrearCuenta_Activity extends AppCompatActivity {

    // Declaración de elementos de la interfaz de usuario
    EditText nombreEditText;
    EditText emailEditText;
    EditText passwordEditText;
    Button crearCuentaButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        // Enlace de vistas a variables
        nombreEditText = findViewById(R.id.editTextTextNombre);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        crearCuentaButton = findViewById(R.id.buttonCrearCuenta);

        // Configuración del botón "Crear Cuenta"
        crearCuentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener datos de los campos de texto
                String nombre = nombreEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Verificar si el correo termina en "@gmail.com"
                if (email.endsWith("@gmail.com") && !email.isEmpty() || !password.isEmpty()) {
                    // Si el correo es válido, ejecuta la tarea de creación de cuenta
                    new CrearCuentaTask().execute(nombre, email, password);
                } else {
                    // Si no, muestra un mensaje de error
                    Toast.makeText(CrearCuenta_Activity.this, "El correo debe terminar en @gmail.com", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Tarea asíncrona para enviar los datos de registro al servidor PHP.
     */
    @SuppressLint("StaticFieldLeak")
    private class CrearCuentaTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String nombre = params[0];
            String email = params[1];
            String password = params[2];
            String response = "";
            try {
                // URL del servidor (ajusta la URL según sea necesario)
                String urlString = "http://10.0.2.2/api/crear_cuenta.php";  // Usa 10.0.2.2 para el emulador de Android
                URL url = new URL(urlString);

                // Configurar la conexión HTTP
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);

                // Enviar los parámetros POST
                String paramsString = "nombre=" + nombre + "&correo_electronico=" + email + "&contrasena=" + password;
                OutputStream outputStream = urlConnection.getOutputStream();
                outputStream.write(paramsString.getBytes());
                outputStream.flush();
                outputStream.close();

                // Leer la respuesta del servidor
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
            // Procesar la respuesta del servidor
            if (result.contains("success")) {
                // Si contiene "success", se creó la cuenta exitosamente
                Toast.makeText(CrearCuenta_Activity.this, "Cuenta creada exitosamente", Toast.LENGTH_LONG).show();
                finish(); // Cerrar la actividad actual
            } else {
                // Si no, mostrar un mensaje de error
                Toast.makeText(CrearCuenta_Activity.this, "Error al crear la cuenta", Toast.LENGTH_LONG).show();
            }
        }
    }
}
