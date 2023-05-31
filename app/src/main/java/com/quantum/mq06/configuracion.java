package com.quantum.mq06;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class configuracion extends AppCompatActivity {

    private TextView direccion, solicitante,estAp, est1, est2, est3, est4,est5,est6;

    public static String direc = null;
    public static String SolicitanteGlobal = null;
    public static String estadoAprobadoGlobal = null;
    public static String estado1Global = null;
    public static String estado2Global = null;
    public static String estado3Global = null;
    public static String estado4Global = null;
    public static String estado5Global = null;
    public static String estado6Global = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        direccion= findViewById(R.id.direccion);
        solicitante= findViewById(R.id.solicitanteRespuesta);
        estAp= findViewById(R.id.estadoAprobadoRespuesta);
        est1= findViewById(R.id.estadoRespuesta);
        est2= findViewById(R.id.estado2Respuesta);
        est3= findViewById(R.id.estado3Respuesta);
        est4= findViewById(R.id.estado4Respuesta);
        est5= findViewById(R.id.estadoRespuesta5);
        est6= findViewById(R.id.estadoRespuesta6);


        //statusBar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.rgb(102,45,145));  //Define color

        SharedPreferences preferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
        direccion.setText(preferences.getString("direcciones",""));
        solicitante.setText(preferences.getString("solicitante",""));
        estAp.setText(preferences.getString("estAp",""));
        est1.setText(preferences.getString("est1",""));
        est2.setText(preferences.getString("est2",""));
        est3.setText(preferences.getString("est3",""));
        est4.setText(preferences.getString("est4",""));
        est5.setText(preferences.getString("est5",""));
        est6.setText(preferences.getString("est6",""));



        direc = direccion.getText().toString();
        SolicitanteGlobal=solicitante.getText().toString();
        estadoAprobadoGlobal=estAp.getText().toString();
        estado1Global=est1.getText().toString();
        estado2Global=est2.getText().toString();
        estado3Global=est3.getText().toString();
        estado4Global=est4.getText().toString();
        estado5Global=est5.getText().toString();
        estado6Global=est6.getText().toString();

    }

    public void guardar (View view){
        SharedPreferences preferecias =  getSharedPreferences("dato",Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferecias.edit();

        Obj_editor.putString("direcciones", direccion.getText().toString());
        Obj_editor.putString("solicitante",SolicitanteGlobal=solicitante.getText().toString());
        Obj_editor.putString("estAp",estadoAprobadoGlobal=estAp.getText().toString());
        Obj_editor.putString("est1",estado1Global=est1.getText().toString());
        Obj_editor.putString("est2",estado2Global=est2.getText().toString());
        Obj_editor.putString("est3",estado3Global=est3.getText().toString());
        Obj_editor.putString("est4",estado4Global=est4.getText().toString());
        Obj_editor.putString("est5",estado5Global=est5.getText().toString());
        Obj_editor.putString("est6",estado6Global=est6.getText().toString());
        Obj_editor.commit();

        Intent siguiente = new Intent(configuracion.this, LoginActivity.class);
        siguiente.putExtra("direcciones", direccion.getText().toString());
        startActivity(siguiente);

    }
}