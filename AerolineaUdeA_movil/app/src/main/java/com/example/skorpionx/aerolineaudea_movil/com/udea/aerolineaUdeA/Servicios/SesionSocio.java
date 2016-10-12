package com.example.skorpionx.aerolineaudea_movil.com.udea.aerolineaUdeA.Servicios;

import com.example.skorpionx.aerolineaudea_movil.com.udea.model.Resultado;

import retrofit.Callback;
import retrofit.http.Header;
import retrofit.http.POST;


public interface SesionSocio {

    @POST("/loginService/login")
    void iniciarSesion(@Header("nombre") String nombre,
                       @Header("apellidos") String apellidos,
                       @Header("fecha_nacimiento") String fecha_nacimiento,
                       @Header("movil") String movil,
                       @Header("correo_electronico") String correo_electronico,
                       @Header("tarjeta_de_credito") String tarjeta_de_credito,
                       @Header("contrasena") String contrasena,
                       Callback<Resultado> cb);
}
