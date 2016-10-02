package com.udea.aerolineaUdeA.webServices;

import com.udea.aerolineaUdeA.dto.Socio;
import com.udea.aerolineaUdeA.modelo.ConexionBD;
import com.udea.aerolineaUeA.util.RespuestaService;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("loginService")
public class Login{
    
    @POST
    @Path("login")
    @Produces({"application/json"})
    public RespuestaService iniciarSesion(@HeaderParam("contrasena") String contraseña,
                                   @HeaderParam("nombre") String nombre,
                                   @HeaderParam("apellidos") String apellidos,
                                   @HeaderParam("fecha_nacimiento") String fecha_nacimiento,
                                   @HeaderParam("movil") String movil,
                                   @HeaderParam("correo_electronico") String correo_electronico,
                                   @HeaderParam("tarjeta_de_credito") String tarjeta_de_credito,
                                   @HeaderParam("numero_de_millas") int numero_de_millas
                                   ){
            ConexionBD sesion=new ConexionBD();
            Socio socio=new Socio(nombre, contraseña,apellidos,fecha_nacimiento,
                    movil,correo_electronico,tarjeta_de_credito,numero_de_millas);
        return sesion.insertSocio(socio);
    }
}
