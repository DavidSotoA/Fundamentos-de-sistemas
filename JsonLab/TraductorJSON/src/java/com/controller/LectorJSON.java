/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URL;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author pipe
 */
@Named(value = "lectorJSON")
@SessionScoped
public class LectorJSON implements Serializable {

    /**
     * Creates a new instance of LectorJSON
     */
    private String lectura;

    private String origen;

    private String destino;

    private String languageorigen;

    private String languagedestino;

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLanguageorigen() {
        return languageorigen;
    }

    public void setLanguageorigen(String languageorigen) {
        this.languageorigen = languageorigen;
    }

    public String getLanguagedestino() {
        return languagedestino;
    }

    public void setLanguagedestino(String languagedestino) {
        this.languagedestino = languagedestino;
    }

    /**
     *
     * Creates a new instance of LectorJSON
     *
     */
    public LectorJSON() {
    }

    public String lector() throws IOException {

        try {

            origen = origen.trim();

            destino = "";

            URL url = new URL("http://spa.hablaa.com/hs/translation/" + origen + "/" + languageorigen + "-" + languagedestino + "/");

            InputStream is = url.openStream();

            JsonParser parser = Json.createParser(is);

            while (parser.hasNext()) {

                Event e = parser.next();

                if (e == Event.KEY_NAME) {

                    switch (parser.getString()) {

                        case "text":

                            parser.next();

                            destino = parser.getString();

                            break;

                    }

                }

            }

        } catch (Exception ex) {

// JSFUtil.addErrorMessage("lector() " + ex.getLocalizedMessage());
        }

        return null;

    }

}
