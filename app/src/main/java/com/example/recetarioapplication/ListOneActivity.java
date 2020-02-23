package com.example.recetarioapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recetarioapplication.DataBase.dbConnection;
import com.example.recetarioapplication.DataBase.dbUtility;

public class ListOneActivity extends AppCompatActivity {


    EditText editId;
    TextView editTitulo,editIngredientes,editElaboracion;
    dbConnection conection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_one_main);

        conection = new dbConnection(getApplicationContext(),"recetas",null,1);

        editId = (EditText) findViewById(R.id.editID);
        editTitulo = (TextView) findViewById(R.id.Titulo);
        editIngredientes = (TextView) findViewById(R.id.Ingredientes);
        editElaboracion = (TextView) findViewById(R.id.Elaboracion);

    }

    public void OnClick (View vista) {


        switch (vista.getId()) {
            case R.id.buscar:
                consultar();
                break;
            case R.id.eliminar:
                eliminarUsuario();
                break;

        }

    }
    private void consultar(){

        SQLiteDatabase db = conection.getReadableDatabase();
        String[] id_busqueda = {editId.getText().toString()};
        String[] campos = {dbUtility.TITULO,dbUtility.INGREDIENTES,dbUtility.ELABORACION};
    try{
        Cursor cursor = db.query(dbUtility.TABLA_RECETAS,campos,dbUtility.PALABRACLAVE +"=?", id_busqueda,null,null,null);
        //Solo debe devolver uno
        cursor.moveToFirst();
        editTitulo.setText(cursor.getString(0));
        editIngredientes.setText(cursor.getString(1));
        editElaboracion.setText(cursor.getString(2));
        cursor.close();
    }catch (Exception e){
        Toast.makeText(getApplicationContext(),"No existe", Toast.LENGTH_LONG).show();;
    }

    }
    private void eliminarUsuario() {
        SQLiteDatabase db=conection.getWritableDatabase();
        String[] id_busqueda={editId.getText().toString()};

        db.delete(dbUtility.TABLA_RECETAS,dbUtility.PALABRACLAVE+"=?",id_busqueda);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
        editId.setText("");

        db.close();
    }

}
