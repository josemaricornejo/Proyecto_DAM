package com.example.fooderful.utils;

public class Alimento {

    private int imagenId;
    private String nombre;
    private String cantidad;
    private String dias;

    public Alimento() {

    }

    public Alimento(int imagenId, String nombre, String cantidad, String dias) {
        this.imagenId = imagenId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.dias = dias;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}


