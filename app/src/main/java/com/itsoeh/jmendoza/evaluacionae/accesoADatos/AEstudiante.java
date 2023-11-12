package com.itsoeh.jmendoza.evaluacionae.accesoADatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AccesoADatos;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;
import com.itsoeh.jmendoza.evaluacionae.models.MEstudiante;


import java.util.ArrayList;

public class AEstudiante extends AccesoADatos {
    public AEstudiante(@Nullable Context context) {
        super(context);
    }

    public void guardar(MEstudiante x){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("INSERT INTO estudiante VALUES (NULL ,"+
                "'"+x.getNombre()+"',"+
                "'"+x.getApellido()+"',"+
                "'"+x.getCorreo()+"',"+
                "'"+x.getMatricula()+"')"
        );
    }
    public ArrayList<MEstudiante> listar(){
        ArrayList<MEstudiante> lista=new ArrayList<MEstudiante>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor reg=db.rawQuery("SELECT * FROM estudiante ",null);
        while(reg.moveToNext()){
            MEstudiante x=new MEstudiante();
            x.setIdEstudiante(reg.getInt(0));
            x.setNombre(reg.getString(1));
            x.setApellido(reg.getString(2));
            x.setCorreo(reg.getString(3));
            x.setMatricula(reg.getInt(4));
            lista.add(x);
        }
        return lista;
    }
    public void insertarEstudiantes() {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        // Insertar primer estudiante
        values.put("nombre", "Juan");
        values.put("apellido", "Perez Martinez");
        values.put("correo", "juan.perez@example.com");
        values.put("matricula", "123456");
        db.insert("estudiante", null, values);

        // Limpiar los valores antiguos
        values.clear();

        // Insertar segundo estudiante
        values.put("nombre", "Maria");
        values.put("apellido", "Lopez Valdez");
        values.put("correo", "maria.lopez@example.com");
        values.put("matricula", "789012");
        db.insert("estudiante", null, values);

        // Cerrar la conexión a la base de datos
        db.close();
    }
    
}