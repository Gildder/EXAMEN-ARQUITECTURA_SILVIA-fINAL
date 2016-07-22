/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class DSintoma {
   private  Conexion con;
   private  int id;
   private String descripcion;
   
   public DSintoma (){
        con = con.getInstance();
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   public void Registrar(){
       Statement Consulta;
       String dato ="insert into sintoma values ("+String.valueOf(id)+",'"+descripcion+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se registraron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede registrar el Sintoma");

       }
    
    }   
   
    public void Modificar(){
       Statement Consulta;
       String dato ="update sintoma set descripcion='"+descripcion+"' where idsintoma="+String.valueOf(id)+" ;";
           try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se modificaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede modicar el Sintoma");

       }
    
    }
      
    public void Eliminar(){
       Statement Consulta;
       String dato ="delete from sintoma where idsintoma="+String.valueOf(id)+" ;";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se Eliminaron con exito...");
       } catch (Exception e) {
       System.out.println("no se puede registrar la conexion");
           System.out.println("no se pudo eliminar el Sintoma");
       }
    }
public DefaultTableModel getTabla(){
        String[] columnNames = {"id","descripcion"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from sintoma";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                tabla.setRowCount(tabla.getRowCount()+1);
                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se puede cargar los datos en la tabla Sintoma");
       } 
      
      return tabla;
    }
 public DefaultComboBoxModel getCombo(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from sintoma";
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                DSintoma  p = new DSintoma();
                p.setId(resultado.getInt(1));
                p.setDescripcion(resultado.getString(2));
                combo.addElement(p);
            }
            Consulta.close();
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS EQUIPO...");
       } 
      return combo;
    }
// public static void main(String[] args){
//        DSintoma t=new DSintoma();
//        t.setId(4);
//        t.setDescripcion("dolor muscular y fiebre");
//        
//        t.Registrar();
//        
////      t.setId(4);
////      t.Eliminar();
//    }
 
 @Override
    public String toString() {
        return descripcion; //To change body of generated methods, choose Tools | Templates.
    }
}
