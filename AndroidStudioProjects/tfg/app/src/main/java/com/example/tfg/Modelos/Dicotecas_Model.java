package com.example.tfg.Modelos;

public class Dicotecas_Model {

    //Otro constructor solo con el id, imagen, nombre y horario
    // Nombre, id , lugar(calle y numero), hora de apertura y cierre, imagenes de la dicoteca y descripción

    private String id;
    private String nombre;
    private String apertura;
    private String cierre;
    private String lugar;
    private String imagenes;
    private String descrip;

    public Dicotecas_Model(String id, String nombre,  String apertura, String cierre, String lugar, String imagenes, String descrip) {
        this.id = id;
        this.nombre = nombre;
        this.apertura = apertura;
        this.cierre = cierre;
        this.lugar = lugar;
        this.imagenes = imagenes;
        this.descrip = descrip;
    }
    public Dicotecas_Model(String id, String nombre,  String apertura, String cierre, String lugar, String imagenes  ) {
        this.id = id;
        this.nombre = nombre;
        this.apertura = apertura;
        this.cierre = cierre;
        this.lugar = lugar;
        this.imagenes = imagenes;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApertura() {
        return apertura;
    }

    public String getCierre() {
        return cierre;
    }

    public String getLugar() {
        return lugar;
    }

    public String getImagenes() {
        return imagenes;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public void setCierre(String cierre) {
        this.cierre = cierre;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }


}
