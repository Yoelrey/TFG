package com.example.tfg.Modelos;

public class promociones_model {

    // Atributos de la clase promocion_model
    //Imagenes, nombre, precio
    String imagen;
    String nombre;
    Double precio;
    String fecha;

    public promociones_model(String imagen, String nombre, Double precio, String fecha) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}