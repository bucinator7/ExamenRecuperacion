package com.example.usuario.examenrecuperacion;

/**
 * Created by USUARIO on 10/04/2018.
 */

public class Municipio {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public int getId_Municipio() {
        return id_Municipio;
    }

    public void setId_Municipio(int id_Municipio) {
        this.id_Municipio = id_Municipio;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVotos() {

        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getValoracionSum() {

        return valoracionSum;
    }

    public void setValoracionSum(int valoracionSum) {
        this.valoracionSum = valoracionSum;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private String descripcion;
    private int valoracionSum;
    private int votos;
    private double precio;
    private  int id_Municipio;

    public Municipio(int id, String nombre, String descripcion, int valoracionSum, int votos, double precio, int id_Municipio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valoracionSum = valoracionSum;
        this.votos = votos;
        this.precio = precio;
        this.id_Municipio = id_Municipio;
    }
}
