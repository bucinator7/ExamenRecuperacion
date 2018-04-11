package com.example.usuario.examenrecuperacion;

import java.util.Vector;

/**
 * Created by USUARIO on 10/04/2018.
 */

public interface Almacen {
    void añadirMunicipio(Municipio muni);
    void añadirAlbergue(Albergue alb);
    void guardarValoracion(int id, int val);
    Vector<Albergue> cargarAlbergue(int cantidad);
    Vector<Municipio> cargarMunicipio(int cantidad);
    Vector<Municipio> cargarMunicipio(String descripcion, int cantidad);
    Vector<Municipio> cargarMunicipio(boolean albergues, int cantidad);
    void elminarTodo();

}
