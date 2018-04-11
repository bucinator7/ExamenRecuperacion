package com.example.usuario.examenrecuperacion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by USUARIO on 10/04/2018.
 */

public class AlmacenSql  extends SQLiteOpenHelper implements Almacen {
    public AlmacenSql(Context context) {
        super(context, "almacen", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table municipio (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, valoracionSum INTEGER, votos INTEGER, precio REAL, id_Municipio INTEGER)");
        db.execSQL("create table albergue(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, valoracionSum INTEGER, precio REAL, id_Municipio INTEGER)");
        db.execSQL("insert into municipio values (null, 'Najera', 3000, 'Antigua capital del Reino de Najera')");
        db.execSQL("insert into albergue values (null, 'Hostal pepito', 'Albergue juvenil o albergue de juventud es un cuerno de establecimiento hostelero, orientado a los jovenes, con precios economicos y el objetivo de promocionar o alentar actividades de intercambio cultural entre promociones de distintos paises, En la moyoria de las cidades del mundo, principalmente capitales', 10, 23.3, 0)");
        db.execSQL("insert into albergue values (null, 'Hostal pepito 2', 'hola caracola',13,3,13.3,0)");
        db.execSQL("insert into albergue values (null, 'Hostal pepito 3', 'uhbasiubhdi', 3, 3, 3.3,0)");
        db.execSQL("insert into municipio values (null, 'Logroño', 120000, 'Capital de la rioja')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                                       int oldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }

    public void añadirMunicipio(Municipio muni){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into municipio values ('"+muni.getId()+"','"+muni.getNombre()+"','"+muni.getDescripcion()+"','"+muni.getValoracionSum()+"','"+muni.getVotos()+"','"+muni.getPrecio()+"','"+muni.getId_Municipio()+")");
        db.close();
    }

    public void añadirAlbergue(Albergue alb){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into albergue values('"+alb.getId()+"','"+alb.getNombre()+"','"+alb.getDescripcion()+"','"+alb.getValoracionSum()+"','"+alb.getPrecio()+"','"+alb.getId_Municipio()+"')");
        db.close();
    }

    public void guardarValoracion(int id, int val){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("update albergue set valoracionSum=valoracionSum+"+val+", votos=votos+1 where id="+id);
        db.close();
    }

    public Vector<Albergue> cargarAlbergue(int cantidad){
        Vector<Albergue> result = new Vector<Albergue>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                "albergue ORDER BY id DESC LIMIT " +cantidad, null);
        while (cursor.moveToNext()){
            result.add(new Albergue(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getInt(3), cursor.getDouble(4),cursor.getInt(5)));
        }
        cursor.close();
        db.close();
        return result;
    }

    public  Vector<Municipio> cargarMunicipio(int cantidad){
        Vector<Municipio> result = new Vector<Municipio>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                "municipio ORDER BY id DESC LIMIT " +cantidad, null);
        while (cursor.moveToNext()){
            result.add(new Municipio(cursor.getInt(0), cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4), cursor.getDouble(5),cursor.getInt(6)));
        }
        cursor.close();
        db.close();
        return result;
    }

    public  Vector<Municipio> cargarMunicipio(String descripcion, int cantidad) {
        Vector<Municipio> result = new Vector<Municipio>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                "municipio WHERE descripcion=" + descripcion + " ORDER BY id DESC LIMIT " + cantidad, null);
        while (cursor.moveToNext()) {
            result.add(new Municipio(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getInt(6)));
        }
        cursor.close();
        db.close();
        return result;
    }

    public  Vector<Municipio> cargarMunicipio(boolean albergues, int cantidad) {
        Vector<Municipio> result = new Vector<Municipio>();
        SQLiteDatabase db = getReadableDatabase();
        if(albergues==false) {
            Cursor cursor = db.rawQuery("SELECT * FROM " +
                    "municipio WHERE id IN(select id_Municipio from albergue) ORDER BY id DESC LIMIT " + cantidad, null);
            while (cursor.moveToNext()) {
                result.add(new Municipio(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getInt(6)));
            }
            cursor.close();
            db.close();
            return result;
        }
        else {
            Cursor cursor = db.rawQuery("SELECT * FROM " +
                    "municipio WHERE id NOT IN(select id_Municipio from albergue) ORDER BY id DESC LIMIT " + cantidad, null);
            while (cursor.moveToNext()) {
                result.add(new Municipio(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getInt(6)));
            }
            cursor.close();
            db.close();
            return result;
        }
    }

    /*public  Vector<Municipio> cargarMunicipio(int habitantes, int cantidad) {
        Vector<Municipio> result = new Vector<Municipio>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                "municipio WHERE descripcion=" + habitantes + " ORDER BY id DESC LIMIT " + cantidad, null);
        while (cursor.moveToNext()) {
            result.add(new Municipio(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getInt(6)));
        }
        cursor.close();
        db.close();
        return result;
    }*/

    public void elminarTodo(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("drop table albergue");
        db.execSQL("drop table municipio");
        db.close();
    }


}
