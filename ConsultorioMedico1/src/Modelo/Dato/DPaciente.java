/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
//import Salces.SalcesComboBox;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class DPaciente {
    private Conexion con;
    private int id;
    private String nombre;
    private String fechanac;
    private int telefono;
    private String tiposangre;
    private int peso;
    private String estadoCivil;

    public DPaciente() {
    con = new Conexion();
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

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into paciente values ("+String.valueOf(id)+",'"+nombre+"','"+fechanac+"','"+telefono+"','"+tiposangre+"',"+String.valueOf(peso)+",'"+estadoCivil+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA Paciente");

       }
    
    }
    public void Eliminar(){
       Statement Consulta;
       String dato ="delete from paciente where idpaciente="+String.valueOf(id)+" ;";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabla paciente");
       }
    }
     
    public void Modificar(){
       Statement Consulta;
       String dato ="update paciente set nombre='"+nombre+"',fechanac='"+fechanac+"',telefono="+String.valueOf(telefono)+",tiposangre='"+tiposangre+"',peso="+String.valueOf(peso)+",estadoCivil='"+estadoCivil+"' where idpaciente="+String.valueOf(id)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede modificar la tabla paciente");

       }
    
    }

    public DefaultTableModel getTabla() {
//        DPaciente p=new DPaciente();
//        LinkedList<DPaciente> l=new LinkedList<>();
        String[] columnNames = {"idpaciente","nombre","fechanac","telefono","tiposangre","peso","estadoCivil"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from paciente";

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
                tabla.setValueAt(resultado.getObject(7).toString(), i, 6);
             // para almacenar el valor en la clase paciente   p.setNombre(resultado.getString(2));
             // para introducir a la lista generica   l.add(p);
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo cargar los datos de la tabla paciente");
       } 
      
      return tabla;
    }
    
    public int getFila() {
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select idpaciente from paciente where nombre='"+nombre+"';";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                id=Integer.valueOf(resultado.getObject(1).toString());
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo cargar los datos de la tabla paciente");
       } 
      
        return id;
    }
 public DefaultComboBoxModel getCombo(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from paciente";
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                DPaciente  p = new DPaciente();
                p.setId(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                combo.addElement(p);
            }
            Consulta.close();
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS EQUIPO...");
       } 
      return combo;
    }
// public static void main(String[] args){
//        DPaciente t=new DPaciente();
//        t.setId(3);
//        t.setNombre("noris  quinta");
//        t.setFechanac("1999-11-02");
//        t.setTelefono(716475645);
//        t.setTiposangre("orh+");
//        t.setPeso(45);
//        t.Registrar();
//        //t.Registrar();
//       // t.setId(4);
//      //t.Eliminar();
//    }
//    
 @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }
}
