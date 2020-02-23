package com.example.recetarioapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recetarioapplication.DataBase.dbConnection;
import com.example.recetarioapplication.DataBase.dbUtility;
import com.example.recetarioapplication.Entidades.Pojo;

import java.util.ArrayList;

public class ListAllActivity extends AppCompatActivity {

    ListView listRecetas;
    ArrayList<String>informacion;
    ArrayList<Pojo>listaRecetas;
    dbConnection conection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_main);

        conection = new dbConnection(getApplicationContext(),"recetas",null,1);
        listRecetas = (ListView) findViewById(R.id.listRecetas);

        consultarLista();


        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,informacion);
        listRecetas.setAdapter(adaptador);

    }

    private void consultarLista() {
        SQLiteDatabase db = conection.getReadableDatabase();
        Pojo pojo = null;
        listaRecetas = new ArrayList<Pojo>();

        Cursor cursor = db.rawQuery("Select * from " + dbUtility.TABLA_RECETAS, null);
        while (cursor.moveToNext()) {
            pojo = new Pojo();
            pojo.setId(cursor.getString(0));
            pojo.setTitulo(cursor.getString(1));
            pojo.setIngredientes(cursor.getString(2));
            pojo.setElaboracion(cursor.getString(3));


            listaRecetas.add(pojo);
        }
        obtener();
    }

         private void obtener(){
             informacion = new ArrayList<String>();

             for(int i=0; i<listaRecetas.size();i++){
                 informacion.add(listaRecetas.get(i).getId()+"\n "+listaRecetas.get(i).getTitulo()+"\n "+listaRecetas.get(i).getIngredientes()+"\n "+listaRecetas.get(i).getElaboracion());

        }
    }
    }



