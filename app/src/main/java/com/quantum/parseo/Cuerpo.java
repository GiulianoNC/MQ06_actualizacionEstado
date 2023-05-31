package com.quantum.parseo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuerpo {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("Solicitante")
    @Expose
    private String solicitante;
    @SerializedName("Estado_Aprobado")
    @Expose
    private String estadoAprobado;
    @SerializedName("Estado_1")
    @Expose
    private String estado1;
    @SerializedName("Estado_2")
    @Expose
    private String estado2;
    @SerializedName("Estado_3")
    @Expose
    private String estado3;
    @SerializedName("Estado_4")
    @Expose
    private String estado4;
    @SerializedName("Estado_5")
    @Expose
    private String estado5;
    @SerializedName("Estado_6")
    @Expose
    private String estado6;

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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getEstadoAprobado() {
        return estadoAprobado;
    }

    public void setEstadoAprobado(String estadoAprobado) {
        this.estadoAprobado = estadoAprobado;
    }

    public String getEstado1() {
        return estado1;
    }

    public void setEstado1(String estado1) {
        this.estado1 = estado1;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    public String getEstado3() {
        return estado3;
    }

    public void setEstado3(String estado3) {
        this.estado3 = estado3;
    }

    public String getEstado4() {
        return estado4;
    }

    public void setEstado4(String estado4) {
        this.estado4 = estado4;
    }

    public Cuerpo(String username, String password, String solicitante, String estadoAprobado, String estado1, String estado2, String estado3, String estado4) {
        this.username = username;
        this.password = password;
        this.solicitante = solicitante;
        this.estadoAprobado = estadoAprobado;
        this.estado1 = estado1;
        this.estado2 = estado2;
        this.estado3 = estado3;
        this.estado4 = estado4;
    }

    public Cuerpo(String username, String password, String solicitante, String estadoAprobado, String estado1, String estado2, String estado3, String estado4, String estado5, String estado6) {
        this.username = username;
        this.password = password;
        this.solicitante = solicitante;
        this.estadoAprobado = estadoAprobado;
        this.estado1 = estado1;
        this.estado2 = estado2;
        this.estado3 = estado3;
        this.estado4 = estado4;
        this.estado5 = estado5;
        this.estado6 = estado6;
    }

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
    private Double jdeServerExecutionSeconds;

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

    public Double getJdeServerExecutionSeconds() {
        return jdeServerExecutionSeconds;
    }

    public void setJdeServerExecutionSeconds(Double jdeServerExecutionSeconds) {
        this.jdeServerExecutionSeconds = jdeServerExecutionSeconds;
    }

}
