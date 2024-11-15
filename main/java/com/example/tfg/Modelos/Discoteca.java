package com.example.tfg.Modelos;

public class Discoteca {
    private String nombre;
    private String precio;
    private String imagenURL;

    public Discoteca(String nombre, String precio, String imagenURL) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagenURL = imagenURL;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getImagenURL() {
        return imagenURL;
    }
}
