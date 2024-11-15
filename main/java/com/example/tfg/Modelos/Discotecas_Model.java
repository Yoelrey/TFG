package com.example.tfg.Modelos;

import androidx.annotation.NonNull;

import java.util.List;

public class Discotecas_Model {
    // Atributos de la tabla Discoteca
    private int id;
    private String nombre;
    private String descripcion;

    // Atributos de la tabla Promocion (relacionados con Discoteca)
    private int promocionId;
    private String promocionDescripcion;
    private boolean promocionVigente;
    private String promocionCaducaPromo;

    // Atributos de la tabla Ubicacion (relacionados con Discoteca)
    private int ubicacionId;
    private double coordX;
    private double coordY;

    // Atributos de la tabla Entrada (relacionados con Discoteca)
    private int entradaId;
    private String precioEntrada;

    // Lista de imágenes en formato BLOB (como byte[])
    private List<byte[]> imagenes;

    // Constructor general
    public Discotecas_Model(int id, String nombre, String descripcion,
                            int promocionId, String promocionDescripcion, boolean promocionVigente, String promocionCaducaPromo,
                            int ubicacionId, double coordX, double coordY,
                            int entradaId, String precioEntrada, List<byte[]> imagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;

        this.promocionId = promocionId;
        this.promocionDescripcion = promocionDescripcion;
        this.promocionVigente = promocionVigente;
        this.promocionCaducaPromo = promocionCaducaPromo;

        this.ubicacionId = ubicacionId;
        this.coordX = coordX;
        this.coordY = coordY;

        this.entradaId = entradaId;
        this.precioEntrada = precioEntrada;

        this.imagenes = imagenes;
    }

    // Getters y Setters
    // Discoteca
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Promocion
    public int getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(int promocionId) {
        this.promocionId = promocionId;
    }

    public String getPromocionDescripcion() {
        return promocionDescripcion;
    }

    public void setPromocionDescripcion(String promocionDescripcion) {
        this.promocionDescripcion = promocionDescripcion;
    }

    public boolean isPromocionVigente() {
        return promocionVigente;
    }

    public void setPromocionVigente(boolean promocionVigente) {
        this.promocionVigente = promocionVigente;
    }

    public String getPromocionCaducaPromo() {
        return promocionCaducaPromo;
    }

    public void setPromocionCaducaPromo(String promocionCaducaPromo) {
        this.promocionCaducaPromo = promocionCaducaPromo;
    }

    // Ubicacion
    public int getUbicacionId() {
        return ubicacionId;
    }

    public void setUbicacionId(int ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    // Entrada
    public int getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(int entradaId) {
        this.entradaId = entradaId;
    }

    public String getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(String precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    // Imágenes
    public List<byte[]> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<byte[]> imagenes) {
        this.imagenes = imagenes;
    }

    @NonNull
    @Override
    public String toString() {
        return "DiscotecaModelo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", promocionId=" + promocionId +
                ", promocionDescripcion='" + promocionDescripcion + '\'' +
                ", promocionVigente=" + promocionVigente +
                ", promocionCaducaPromo='" + promocionCaducaPromo + '\'' +
                ", ubicacionId=" + ubicacionId +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                ", entradaId=" + entradaId +
                ", precioEntrada='" + precioEntrada + '\'' +
                ", imagenes=" + imagenes.size() + " imágenes" +
                '}';
    }
}
