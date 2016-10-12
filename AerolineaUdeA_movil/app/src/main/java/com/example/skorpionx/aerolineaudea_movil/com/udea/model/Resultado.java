package com.example.skorpionx.aerolineaudea_movil.com.udea.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resultado {

    @SerializedName("tipo")
    @Expose
    String tipo;
    @SerializedName("mensaje")
    @Expose
    String mensaje;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
