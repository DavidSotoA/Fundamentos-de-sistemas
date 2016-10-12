package com.udea.aerolineaUdeA.dto;

import java.io.Serializable;

public class Socio implements Serializable {
    private int id;
    private String token;
    private String nombre;
    private String contraseña;
    private String apellidos;
    private String fecha_nacimiento;
    private String movil;
    private String correo_electronico;
    private String tarjeta_de_credito;
    private int numero_de_millas;

    public Socio(int id,String token, String nombre,String contraseña, String apellidos, String fecha_nacimiento, String movil, String correo_electronico, String tarjeta_de_credito, int numero_de_millas) {
        this.id = id;
        this.token=token;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.movil = movil;
        this.correo_electronico = correo_electronico;
        this.tarjeta_de_credito = tarjeta_de_credito;
        this.numero_de_millas = numero_de_millas;
    }

    public Socio(String nombre, String contraseña, String apellidos, String fecha_nacimiento, String movil, String correo_electronico, String tarjeta_de_credito, int numero_de_millas) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.movil = movil;
        this.correo_electronico = correo_electronico;
        this.tarjeta_de_credito = tarjeta_de_credito;
        this.numero_de_millas = numero_de_millas;
    }
    
    

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTarjeta_de_credito() {
        return tarjeta_de_credito;
    }

    public void setTarjeta_de_credito(String tarjeta_de_credito) {
        this.tarjeta_de_credito = tarjeta_de_credito;
    }

    public int getNumero_de_millas() {
        return numero_de_millas;
    }

    public void setNumero_de_millas(int numero_de_millas) {
        this.numero_de_millas = numero_de_millas;
    }
    
}
