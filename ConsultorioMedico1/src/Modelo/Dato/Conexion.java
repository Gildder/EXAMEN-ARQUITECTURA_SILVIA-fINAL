/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silvita
 */
public class Conexion {
   private static String Servidor="jdbc:mysql://localhost:3306/consultoriomedico";
    private static String user="root";
    private static String pass="admin";
    private static String driver="com.mysql.jdbc.Driver";
    private  Connection con; 
    
    //atributo singleton
    private static Conexion instance;
    //org.gjt.mm.mysql.Driver
    public Conexion() {
        try
        {
            Class.forName(driver);
            con=(Connection) DriverManager.getConnection(Servidor, user, pass);
            System.out.println("conexion realizada con exito");

        }catch(Exception ee){
            System.out.println("conexion fallida");
        }   
    }
    
    //metodo singleton
     public  static Conexion getInstance(){
        if(instance == null)
            instance = new Conexion();
            
        return instance;
    }
     
     
    public Connection getConexion(){
        
        return con;
    }
    
    public Connection cerrarConexion(){
        try {
            con.close();
             System.out.println("Cerrando conexion a ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con=null;
        return con;
    } 
}
