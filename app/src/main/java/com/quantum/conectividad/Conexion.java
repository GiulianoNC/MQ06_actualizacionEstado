package com.quantum.conectividad;

import com.quantum.parseo.Cuerpo;
import com.quantum.parseo.Cuerpo2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Conexion {

    @POST("jderest/v3/orchestrator/MQ0601A_ORCH")
    Call<Cuerpo> getData(@Body Cuerpo users );

    @POST("jderest/v3/orchestrator/MQ0602A_ORCH")
    Call<Cuerpo2> getAprobacion(@Body Cuerpo2 users );
}
