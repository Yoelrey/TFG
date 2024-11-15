package com.example.tfg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tfg.Modelos.Discoteca;

import java.util.ArrayList;
import java.util.List;

public class DiscotecaAdapter extends ArrayAdapter<Discoteca> {

    public DiscotecaAdapter(Context context, ArrayList<Discoteca> discotecas) {
        super(context, 0, discotecas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elemento, parent, false);
        }

        Discoteca discoteca = getItem(position);

        TextView nombreTextView = convertView.findViewById(R.id.nombreDiscoteca);
        TextView precioTextView = convertView.findViewById(R.id.entrada);

        nombreTextView.setText(discoteca.getNombre());
        precioTextView.setText(discoteca.getPrecio());

        // Si tienes imágenes, usa una librería como Picasso o Glide para cargar las imágenes

        return convertView;
    }
}
