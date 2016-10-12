
package com.udea.aerolineaUdeA.modelo;

import com.udea.aerolineaUdeA.dto.Socio;
import com.udea.aerolineaUeA.util.Constantes;
import com.udea.aerolineaUeA.util.RespuestaService;
import com.udea.aerolineaUeA.util.TokenGenerator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
    
    public RespuestaService insertSocio(Socio socio){
            
        String token; 
        Connection conn = null;  
        PreparedStatement preparedStmt=null;
        try{
            Class.forName(Constantes.JDBC_DRIVER);
             conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.USER, Constantes.PASS);
            
            do{
                token=TokenGenerator.generarToken();
            }while(existSocio(token,conn));
            
            String query = " insert into socio (token,contraseña, nombre, apellidos, fecha_nacimiento"
                    + ", movil, correo_electronico,tarjeta_de_credito,numero_de_millas)"
                    + " values (?,?, ?, ?, ?, ?, ?, ?, ?)";
            
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, token);
            preparedStmt.setString(2, socio.getContraseña());
            preparedStmt.setString(3, socio.getNombre());
            preparedStmt.setString(4, socio.getApellidos());
            preparedStmt.setString(5, socio.getFecha_nacimiento());
            preparedStmt.setString(6, socio.getMovil());
            preparedStmt.setString(7, socio.getCorreo_electronico());
            preparedStmt.setString(8, socio.getTarjeta_de_credito());
            preparedStmt.setInt(9, socio.getNumero_de_millas());
            
            preparedStmt.execute();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new RespuestaService(RespuestaService.ERROR,Constantes.ERROR_BD_CONNETC);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return new RespuestaService(RespuestaService.ERROR,Constantes.ERROR_BD_CONNETC);
        }finally {
            if (preparedStmt != null) try { preparedStmt .close(); } catch (SQLException logOrIgnore) {}
            if (conn != null) try { conn .close(); } catch (SQLException logOrIgnore) {}
            }
        return new RespuestaService(RespuestaService.SUCCESS,token);
    }
    
    public boolean existSocio(String token, Connection conn){
        try{
            Statement stmt = conn.createStatement();
            String query="SELECT * FROM socio WHERE token='"+token+"'";
            
            ResultSet rs = stmt.executeQuery(query);
            if(!rs.next()){
                return false;
            }
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] arg){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha= dateFormat.format(date);
        
        ConexionBD con=new ConexionBD();
        Socio socio= new Socio("Andre","suContraseña", "Soto Ayala",fecha,"3242342","andres@wow.com","1234534",0);
        RespuestaService resp=con.insertSocio(socio);
        System.out.println(fecha);
    }
}
