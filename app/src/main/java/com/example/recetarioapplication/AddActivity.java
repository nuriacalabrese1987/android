package com.example.recetarioapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recetarioapplication.DataBase.dbConnection;
import com.example.recetarioapplication.DataBase.dbUtility;


public class AddActivity extends AppCompatActivity {
        EditText editId,Titulo,Ingredientes,Elaboracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_receta_main);


         editId = (EditText) findViewById(R.id.editID);
         Titulo = (EditText) findViewById(R.id.Titulo);
         Ingredientes = (EditText) findViewById(R.id.Ingredientes);
         Elaboracion = (EditText) findViewById(R.id.Elaboracion);
}

    public void createRecipe(View vista){
        almacenarReceta();

  }
    private void almacenarReceta(){
        //creo la conexion para poder escribir en la base de datos
        dbConnection conection = new dbConnection(this,"recetas",null,1);
        SQLiteDatabase db = conection.getWritableDatabase();

        //agregamos claves para poder dar valores a la tabla
        ContentValues values= new ContentValues();
        values.put(dbUtility.PALABRACLAVE,editId.getText().toString());
        values.put(dbUtility.TITULO,Titulo.getText().toString());
        values.put(dbUtility.INGREDIENTES,Ingredientes.getText().toString());
        values.put(dbUtility.ELABORACION,Elaboracion.getText().toString());

        //volcamos el resultado en nuestra base de datos
        Long resultado=db.insert(dbUtility.TABLA_RECETAS,dbUtility.PALABRACLAVE,values);

        //Devuelve un toast con el id e la tabla
        Toast.makeText(getApplicationContext(),"Id Registro: "+resultado,Toast.LENGTH_SHORT).show();
         db.close();

    }

}