package com.example.tfg.Modelos;

public class Promociones_Discotecas_Model {

    //imagen, nombre, precio,fechafin y mapa donde queda la discoteca

    public String imagen;
    public String nombre;
    public Double precio;
    public String fechafin;
    public String id;
    public String latitud;
    public String longitud;

    public Promociones_Discotecas_Model(String imagen, String nombre, Double precio, String fechafin, String id, String latitud, String longitud) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.fechafin = fechafin;
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

}
