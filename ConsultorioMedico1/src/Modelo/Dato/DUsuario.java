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
public class DUsuario {
    private Conexion con;
    private int id;
    private String nombre;
    private int telefono;
    private String tipo;
    private String ci;
    private String contrasena;

    public DUsuario() {
        con=new Conexion();
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into usuario values ("+String.valueOf(id)+",'"+nombre+"',"+String.valueOf(telefono)+",'"+tipo+"','"+ci+"','"+contrasena+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se guardaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede guardar en la tabla Visualizar Usuario");

       }
    
    }
    
     public void Eliminar(){
       Statement Consulta;
       String dato ="delete from usuario where idusuario ="+String.valueOf(id)+" ;";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
          Consulta.close();
          System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabla visualizar usuario");
       }
    }
     
     public void Modificar(){
       Statement Consulta;
       String dato ="update usuario set nombre='"+nombre+"',telefono="+String.valueOf(telefono)+",tipo='"+tipo+"', ci='"+ci+"',contrasena='"+contrasena+"' where idusuario="+String.valueOf(id)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se modificaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede modificiar en la tabla visualizar usuario");

       }
    
    }
    public DefaultTableModel getTabla() {
        String[] columnNames = {"idusuario","nombre","telefono","tipo","ci","contrasena"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from usuario";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                tabla.setRowCount(tabla.getRowCount()+1);
                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultado.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultado.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultado.getObject(5).toString(), i, 4);
                tabla.setValueAt(resultado.getObject(6).toString(), i, 5);
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo cargar los datos de la tabla usuario");
       } 
      
      return tabla;
    }
    
    public DefaultComboBoxModel getCombo(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from usuario";
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                DUsuario u = new DUsuario();
                u.setId(resultado.getInt(1));
                u.setNombre(resultado.getString(2));
                combo.addElement(u);
            }
            Consulta.close();
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS EQUIPO...");
       } 
      return combo;
    }

    //        public static void main(String[] args){
    //        DUsuario t=new DUsuario();
    //        t.setId(1);
    //        t.setNombre("wendy collado");
    //        t.setTelefono(48762767);
    //        t.setTipo("secretaria");
    //        t.setCi("56464");
    //        t.setContrasena("silvia");
    //        t.Eliminar();
    //    }
    @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }
    
}
