package com.example.recetarioapplication.Entidades;

public class Pojo {


    String id;



    String titulo;
    String ingredientes;
    String elaboracion;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pojo(String id, String titulo, String ingredientes, String elaboracion) {
        this.id = id;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.elaboracion = elaboracion;
    }
    public Pojo() {
    }
}





