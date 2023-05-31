package com.quantum.mq06;

import static com.quantum.mq06.LoginActivity.contraseñaGlobal;
import static com.quantum.mq06.LoginActivity.usuarioGlobal;
import static com.quantum.mq06.configuracion.SolicitanteGlobal;
import static com.quantum.mq06.configuracion.direc;
import static com.quantum.mq06.configuracion.estado1Global;
import static com.quantum.mq06.configuracion.estado2Global;
import static com.quantum.mq06.configuracion.estado3Global;
import static com.quantum.mq06.configuracion.estado4Global;
import static com.quantum.mq06.configuracion.estado5Global;
import static com.quantum.mq06.configuracion.estado6Global;
import static com.quantum.mq06.configuracion.estadoAprobadoGlobal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.quantum.adaptador.AdapterDatos;
import com.quantum.adaptador.AdapterDatos2;
import com.quantum.conectividad.Conexion;
import com.quantum.parseo.Cuerpo;
import com.quantum.parseo.Cuerpo2;
import com.quantum.parseo.Mq0601aDatareq;
import com.quantum.parseo.Rowset;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultadosActivity extends AppCompatActivity {
    private TextView prueba,resultado;
    private TextView numero,numero2;
    ArrayList<String> listDatos,listDatos2;
    RecyclerView recycler,recycler2;

    public static String tipoGlobal= null;
    public static String ordenGlobal= null;
    public static String estadoGlobal= null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        prueba = (TextView) findViewById(R.id.prueba);
        numero = (TextView) findViewById(R.id.numero);
        numero2 = (TextView) findViewById(R.id.numero2);
        resultado = (TextView) findViewById(R.id.resultado);


        recycler= (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recycler2= (RecyclerView) findViewById(R.id.recyclerId2);
        recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //statusBar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.rgb(102,45,145));  //Define color

        resultado();
    }

    public void Salir(View v){
        new AlertDialog.Builder(this)
                //.setIcon(R.drawable.alacran)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();;
                    }
                }).show();
    }

    public void resultado( ){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(direc)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Conexion conexion = retrofit.create(Conexion.class);
        Cuerpo logerse = new Cuerpo(usuarioGlobal, contraseñaGlobal,SolicitanteGlobal,estadoAprobadoGlobal, estado1Global, estado2Global, estado3Global, estado4Global ,estado5Global,estado6Global);
        Call<Cuerpo> call = conexion.getData(logerse);
        call.enqueue(new Callback<Cuerpo>() {
            @Override
            public void onResponse(Call<Cuerpo> call, Response<Cuerpo> response) {
                int statusCode = response.code();

                if(statusCode == 200) {
                    Mq0601aDatareq contactList =  response.body().getMq0601aDatareq();
                    listDatos =new ArrayList<>();

                    for(int e = 0; e<contactList.getRowset().size(); e++) {

                        ArrayList<Rowset> rowset1 = (ArrayList<Rowset>) contactList.getRowset();
                        String caso = rowset1.get(e).getCaso();
                        String descEquipo = rowset1.get(e).getDescEquipo();
                        String ordenNumero = rowset1.get(e).getOrdenNumero();
                        String tipo = rowset1.get(e).getOrdenTipo();
                        String fecha = rowset1.get(e).getFechaSolicitud();
                        String estado= rowset1.get(e).getEstado();
                        String idEquipo= rowset1.get(e).getIDEquipo();
                        String descripcion= rowset1.get(e).getDescripcion();

                        tipoGlobal = tipo;
                        ordenGlobal = ordenNumero;
                        estadoGlobal = estado;

                        String content =  tipo + " | " +  descEquipo +"\n"+ "Fecha: " + fecha + " | "+ descripcion + " | " + "Caso: " + caso + "\n\n";
                        listDatos.add( ordenNumero );

                        prueba.append(content);
                        AdapterDatos adapter = new AdapterDatos(listDatos);
                        recycler.setAdapter(adapter);

                        adapter.setOnclickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                numero.setText(listDatos.get(recycler.getChildAdapterPosition(view)));

                                //cuadro de dialogo

                                    CharSequence[] opciones = {"Si, estoy seguro", "Cancelar"};

                                    AlertDialog.Builder builder = new AlertDialog.Builder(ResultadosActivity.this);
                                    builder.setTitle("¿Está seguro de Aprobar caso " + caso + "?");
                                    builder.setItems(opciones, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            if (opciones[i].equals("Si, estoy seguro")){

                                               // resultado.setText("datos");

                                                Retrofit retrofit = new Retrofit.Builder()
                                                        .baseUrl(direc)
                                                        .addConverterFactory(GsonConverterFactory.create())
                                                        .build();

                                                Conexion conexion = retrofit.create(Conexion.class);
                                                Cuerpo login3 = new Cuerpo(usuarioGlobal, contraseñaGlobal,SolicitanteGlobal,estadoAprobadoGlobal, estado1Global, estado2Global, estado3Global, estado4Global ,estado5Global,estado6Global);
                                                Call<Cuerpo> call2 = conexion.getData(login3);
                                                call2.enqueue(new Callback<Cuerpo>() {
                                                    @Override
                                                    public void onResponse(Call<Cuerpo> call, Response<Cuerpo> response) {

                                                        int statusCode = response.code();

                                                        if(statusCode == 200) {
                                                            Mq0601aDatareq contactList =  response.body().getMq0601aDatareq();

                                                            String numeroOrden2 = numero.getText().toString();

                                                            listDatos2 =new ArrayList<>();

                                                            for(int e = 0; e<contactList.getRowset().size(); e++) {

                                                                ArrayList<Rowset> rowset1 = (ArrayList<Rowset>) contactList.getRowset();
                                                                String ordenNumero = rowset1.get(e).getOrdenNumero();
                                                                String tipo = rowset1.get(e).getOrdenTipo();

                                                                listDatos2.add( ordenNumero );
                                                                AdapterDatos2 adapter = new AdapterDatos2(listDatos2);
                                                                recycler2.setAdapter(adapter);

                                                                numero2.setText(listDatos2.get(recycler2.getChildAdapterPosition(view)));

                                                                if (numero2.length() != 0){
                                                                    String OrdenObtenido = numero2.getText().toString();

                                                                    Toast.makeText(ResultadosActivity.this, ordenNumero, Toast.LENGTH_LONG).show();

                                                                    if (OrdenObtenido.equals(numeroOrden2) ){

                                                                        String tipo1 = tipo;
                                                                        String orden1 = ordenNumero;

                                                                        Cuerpo2 login2 = new Cuerpo2(usuarioGlobal, contraseñaGlobal,estadoGlobal, tipoGlobal, ordenGlobal );
                                                                        Call<Cuerpo2> call2 = conexion.getAprobacion(login2);
                                                                        call2.enqueue(new Callback<Cuerpo2>() {
                                                                            @Override
                                                                            public void onResponse(Call<Cuerpo2> call, Response<Cuerpo2> response) {
                                                                                if(response.body() != null) {

                                                                                    Cuerpo2 datareq = response.body();

                                                                                    String content = "";
                                                                                    content += "" + datareq.getOrdenNumero() + "\n"
                                                                                            + datareq.getOrdenNumero() + "\n"
                                                                                            + datareq.getOrdenTipo() + "\n\n";
                                                                                    resultado.append(content);

                                                                                }
                                                                            }

                                                                            @Override
                                                                            public void onFailure(Call<Cuerpo2> call, Throwable t) {
                                                                                Toast.makeText(ResultadosActivity.this, "Error", Toast.LENGTH_LONG).show();
                                                                                resultado.setText("Error");

                                                                            }
                                                                        });
                                                                    }
                                                                    Toast.makeText(ResultadosActivity.this, "Error", Toast.LENGTH_LONG).show();
                                                                }else{
                                                                    Toast.makeText(ResultadosActivity.this, "Error", Toast.LENGTH_LONG).show();
                                                                }
                                                            }
                                                        }
                                                        Toast.makeText(ResultadosActivity.this, "error", Toast.LENGTH_LONG).show();
                                                    }
                                                    @Override
                                                    public void onFailure(Call<Cuerpo> call, Throwable t) {
                                                        Toast.makeText(ResultadosActivity.this, "error", Toast.LENGTH_LONG).show();
                                                    }
                                                });

                                            }else{
                                                dialogInterface.dismiss();
                                            }
                                        }
                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                            }
                        });
                    }
                }else {
                    Toast.makeText(ResultadosActivity.this, "ERROR " + statusCode, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Cuerpo> call, Throwable t) {
                Toast.makeText(ResultadosActivity.this, "ERROR " , Toast.LENGTH_LONG).show();
            }
        });
    }
}