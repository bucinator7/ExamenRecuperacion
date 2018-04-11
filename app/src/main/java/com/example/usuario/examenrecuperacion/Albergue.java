package com.example.usuario.examenrecuperacion;

/**
 * Created by USUARIO on 10/04/2018.
 */

public class Albergue {
    private int id;
    private String nombre;
    private String descripcion;
    private int valoracionSum;
    private double precio;
    private int id_Municipio;

    public Albergue(int id, String nombre, String descripcion, int valoracionSum, double precio, int id_Municipio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valoracionSum = valoracionSum;
        this.precio = precio;
        this.id_Municipio = id_Municipio;
    }

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

    public int getValoracionSum() {
        return valoracionSum;
    }

    public void setValoracionSum(int valoracionSum) {
        this.valoracionSum = valoracionSum;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_Municipio() {
        return id_Municipio;
    }

    public void setId_Municipio(int id_Municipio) {
        this.id_Municipio = id_Municipio;
    }
}
