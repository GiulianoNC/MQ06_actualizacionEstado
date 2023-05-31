package com.quantum.parseo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuerpo2 {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("Estado_Aprobado")
    @Expose
    private String estadoAprobado;
    @SerializedName("Orden_Tipo")
    @Expose
    private String ordenTipo;
    @SerializedName("Orden_Numero")
    @Expose
    private String ordenNumero;

    @SerializedName("Estado")
    @Expose
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cuerpo2(String username, String password, String estadoAprobado, String ordenTipo, String ordenNumero) {
        this.username = username;
        this.password = password;
        this.estadoAprobado = estadoAprobado;
        this.ordenTipo = ordenTipo;
        this.ordenNumero = ordenNumero;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstadoAprobado() {
        return estadoAprobado;
    }

    public void setEstadoAprobado(String estadoAprobado) {
        this.estadoAprobado = estadoAprobado;
    }

    public String getOrdenTipo() {
        return ordenTipo;
    }

    public void setOrdenTipo(String ordenTipo) {
        this.ordenTipo = ordenTipo;
    }

    public String getOrdenNumero() {
        return ordenNumero;
    }

    public void setOrdenNumero(String ordenNumero) {
        this.ordenNumero = ordenNumero;
    }


    //respuesta

    @SerializedName("MQ0601A_DATAREQ")
    @Expose
    private Mq0601aDatareq mq0601aDatareq;
    @SerializedName("jde__status")
    @Expose
    private String jdeStatus;
    @SerializedName("jde__startTimestamp")
    @Expose
    private String jdeStartTimestamp;
    @SerializedName("jde__endTimestamp")
    @Expose
    private String jdeEndTimestamp;
    @SerializedName("jde__serverExecutionSeconds")
    @Expose
    private Float jdeServerExecutionSeconds;

    public Mq0601aDatareq getMq0601aDatareq() {
        return mq0601aDatareq;
    }

    public void setMq0601aDatareq(Mq0601aDatareq mq0601aDatareq) {
        this.mq0601aDatareq = mq0601aDatareq;
    }

    public String getJdeStatus() {
        return jdeStatus;
    }

    public void setJdeStatus(String jdeStatus) {
        this.jdeStatus = jdeStatus;
    }

    public String getJdeStartTimestamp() {
        return jdeStartTimestamp;
    }

    public void setJdeStartTimestamp(String jdeStartTimestamp) {
        this.jdeStartTimestamp = jdeStartTimestamp;
    }

    public String getJdeEndTimestamp() {
        return jdeEndTimestamp;
    }

    public void setJdeEndTimestamp(String jdeEndTimestamp) {
        this.jdeEndTimestamp = jdeEndTimestamp;
    }

    public Float getJdeServerExecutionSeconds() {
        return jdeServerExecutionSeconds;
    }

    public void setJdeServerExecutionSeconds(Float jdeServerExecutionSeconds) {
        this.jdeServerExecutionSeconds = jdeServerExecutionSeconds;
    }

}
