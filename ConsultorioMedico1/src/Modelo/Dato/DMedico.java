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
public class DMedico {
    private Conexion con;
    private int id;
    private String nombre;
    private String especialidad;
    private String codprofesional;
    private int tur;

    public DMedico() {
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodprofesional() {
        return codprofesional;
    }

    public void setCodprofesional(String codprofesional) {
        this.codprofesional = codprofesional;
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }

      public void Registrar(){
       Statement Consulta;
       String dato ="insert into medico values ("+String.valueOf(id)+",'"+nombre+"','"+especialidad+"','"+codprofesional+"',"+String.valueOf(tur)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA medico");

       }
    
    }
     
     
      public void Modificar(){
       Statement Consulta;
       String dato ="update medico set nombre='"+nombre+"' , especialidad='"+especialidad+"',codigoprofesional='"+codprofesional+"', idturno="+String.valueOf(tur)+" where idmedico="+String.valueOf(id)+" ;";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA medico");

       }
    
    }
      
      
      public void Eliminar(){
       Statement Consulta;
       String dato ="delete from medico where idmedico="+String.valueOf(id)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabla medico");
       }
    }   
    public DefaultTableModel getTabla(){
        String[] columnNames = {"idmedico","nombre","especialidad","codprofesional","Turno"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
       // String dato="select p.cod,p.titulo,p.duracion,p.precio,g.nombre from pelicula p,genero g where p.gen=g.nro;";
        String dato="select m.idmedico,m.nombre, m.especialidad, m.codigoprofesional, t.descripcion from medico m, turno t where m.idturno=t.idturno;";
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
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA medico");
       } 
      
      return tabla;
    }
    public DefaultComboBoxModel getCombo(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from medico";
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                DMedico  p = new DMedico();
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
    
//  
//
// public static void main(String[] args){
//        DMedico t=new DMedico();
//        t.setId(2);
//        t.setCodprofesional("01");
//        t.setEspecialidad("Pediatra");
//        t.setNombre("mario calderon");
//        
//        t.Guardar();
//   //   t.setId(4);
//    //t.Eliminar();
//    }
    
 @Override
    public String toString() {
        return nombre; //To change body of generated methods, choose Tools | Templates.
    }      
}

