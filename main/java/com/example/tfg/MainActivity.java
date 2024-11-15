package com.example.tfg;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tfg.Modelos.Discoteca;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPromociones;
    private ArrayList<Discoteca> discotecasList;
    private DiscotecaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPromociones = findViewById(R.id.listViewPromociones);
        discotecasList = new ArrayList<>();
        adapter = new DiscotecaAdapter(this, discotecasList);
        listViewPromociones.setAdapter(adapter);

        // Cargar las discotecas
        new GetDiscotecasTask().execute("http://10.0.2.2/api/discotecas.php");
    }

    @SuppressLint("StaticFieldLeak")
    private class GetDiscotecasTask extends AsyncTask<String, Void, List<Discoteca>> {

        @Override
        protected List<Discoteca> doInBackground(String... urls) {
            List<Discoteca> result = new ArrayList<>();
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                String response = stringBuilder.toString();
                Log.d("JSON Response", response);

                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String nombre = jsonObject.optString("nombre", "Nombre desconocido");
                    String precio = jsonObject.optString("precio", "Precio no disponible");
                    result.add(new Discoteca(nombre, precio, "default_image_url"));
                }
            } catch (Exception e) {
                Log.e("Network Error", "Error: " + e.getMessage());
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }        @Override
        protected void onPostExecute(List<Discoteca> result) {
            if (result != null && !result.isEmpty()) {
                discotecasList.clear();
                discotecasList.addAll(result);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Datos cargados correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "No se pudieron cargar los datos", Toast.LENGTH_SHORT).show();
            }
            Log.d("MainActivity", "Número de discotecas cargadas: " + discotecasList.size());
            for (Discoteca d : discotecasList) {
                Log.d("MainActivity", "Discoteca: " + d.getNombre() + ", Precio: " + d.getPrecio());
            }
        }
    }
}