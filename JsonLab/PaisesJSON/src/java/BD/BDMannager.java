package BD;

import com.google.gson.Gson;
import dto.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDMannager {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/pais";
    static final String USER = "root";
    static final String PASS = "root";
    
    public static String obtenerPaises(){
         List<Pais> paises= new ArrayList<>();
         Gson gson= new Gson();
        try{
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            Statement stmt = conn.createStatement();
            String sql="SELECT * FROM pais";
            ResultSet rs = stmt.executeQuery(sql);
            
            Pais pais;
            while(rs.next()){
                  pais= new Pais(rs.getString("code"),rs.getString("name")
                          ,rs.getString("continent"),rs.getString("region"),
                            rs.getInt("population"),rs.getInt("capital"));
                  paises.add(pais);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDMannager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String paisJson=gson.toJson(paises);
        System.out.println(paisJson);
        return paisJson;
    }
    
    public static void main(String[] args){
        BDMannager.obtenerPaises();
    }
    
}
