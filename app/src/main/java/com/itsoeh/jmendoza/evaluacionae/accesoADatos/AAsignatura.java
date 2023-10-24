package com.itsoeh.jmendoza.evaluacionae.accesoADatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.itsoeh.jmendoza.evaluacionae.accesoADatos.AccesoADatos;
import com.itsoeh.jmendoza.evaluacionae.models.MAsignatura;
import com.itsoeh.jmendoza.evaluacionae.models.MDocente;


import java.util.ArrayList;

public class AAsignatura extends AccesoADatos {
    public AAsignatura(@Nullable Context context) {
        super(context);
    }

    public void guardar(MAsignatura x){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("INSERT INTO asignatura VALUES (NULL ,"+
                "'"+x.getAsignatura()+"',"+
                "'"+x.getClaveAsignatura()+"',"+
                "'"+x.getClaveGrupo()+"',"+
                "'"+x.getCodigoAsignatura()+"',"+
                "'"+x.getIdDocente()+"')"
        );
    }
    public ArrayList<MAsignatura> listar(){
        ArrayList<MAsignatura> lista=new ArrayList<MAsignatura>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor reg=db.rawQuery("SELECT * FROM asignatura ",null);
        while(reg.moveToNext()){
            MAsignatura x=new MAsignatura();
            x.setIdAsignatura(reg.getInt(0));
            x.setAsignatura(reg.getString(1));
            x.setClaveAsignatura(reg.getString(2));
            x.setClaveGrupo(reg.getString(3));
            x.setCodigoAsignatura(reg.getString(4));
            x.setIdDocente(reg.getInt(5));
            lista.add(x);
        }
        return lista;
    }


}