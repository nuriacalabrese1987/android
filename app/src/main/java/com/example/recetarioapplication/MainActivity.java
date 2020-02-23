package com.example.recetarioapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.recetarioapplication.DataBase.dbConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciamos la conexion con la base de datos
         dbConnection conection = new dbConnection(this,"recetas",null,1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //creamos el menu de cambios de pantalla
    public void cambioPantalla (View vista){

        Intent intent = null;
        switch(vista.getId()){
            case R.id.crear:
                intent=new Intent(this,AddActivity.class);
                break;
            case R.id.buscar:
                intent=new Intent(this,ListOneActivity.class);
                break;
            case R.id.consultarLista:
                intent=new Intent(this,ListAllActivity.class);
                break;
        }
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.añadir:
                intent = new Intent(this, AddActivity.class);
                return true;


            case R.id.buscar:
                intent = new Intent(this, ListOneActivity.class);
                return true;


            case R.id.consultarLista:
                intent = new Intent(this, ListAllActivity.class);
                return true;

            case R.id.volver:
                intent = new Intent(this, MainActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }
    }


