package com.example.recetarioapplication.DataBase;

public class dbUtility  {
    //creamos las constantes para no quemar nombres como recomienda la guia developer
    public static final String TABLA_RECETAS="recetas";
    public static final String TITULO="titulo";
    public static final String PALABRACLAVE ="palabra";
    public static final String INGREDIENTES="ingredientes";
    public static final String ELABORACION="elaboracion";


    public static final String CREATE_TABLA_RECETAS="create table "+TABLA_RECETAS+"("+ PALABRACLAVE +" integer (100) ,"+TITULO+" text, "+INGREDIENTES+" text, "+ELABORACION+" text)";


}
