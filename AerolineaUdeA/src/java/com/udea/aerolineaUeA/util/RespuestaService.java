
package com.udea.aerolineaUeA.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespuestaService {
    public static final String ERROR = "Error";
    public static final String SUCCESS = "Success";

    private String tipo;
    private String mensaje;

    public RespuestaService () { }

    public RespuestaService(String tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}