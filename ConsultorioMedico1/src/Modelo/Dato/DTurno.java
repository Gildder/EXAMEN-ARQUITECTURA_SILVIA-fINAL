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
public class DTurno {
    private Conexion con;
    private int id;
    private String descripcion;
    private String horainicio;
    private String horafin;

    public DTurno() {
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

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into turno values ("+String.valueOf(id)+",'"+descripcion+"','"+horainicio+"','"+horafin+"');";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se guardaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede guardar en la tabla Turno");

       }
    
    }
    
     public void Eliminar(){
       Statement Consulta;
       String dato ="delete from turno where idturno ="+String.valueOf(id)+" ;";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
          Consulta.close();
          System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabla Turno");
       }
    }
     
     public void Modificar(){
       Statement Consulta;
       String dato ="update turno set descripcion='"+descripcion+"', horainicio='"+horainicio+"',horafin='"+horafin+"' where idturno="+String.valueOf(id)+";";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se modificaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede modificiar la tabla turno");

       }
    
    }
    public DefaultTableModel getTabla() {
//        DPaciente p=new DPaciente();
//        LinkedList<DPaciente> l=new LinkedList<>();
        String[] columnNames = {"idturno","decripcion","horainicio","horafin"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from turno";

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
    public DefaultComboBoxModel getCombo(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        Statement Consulta;
        ResultSet resultado=null;
        String dato="select * from turno";
        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            while(resultado.next()){
                DTurno u = new DTurno();
                u.setId(resultado.getInt(1));
                u.setDescripcion(resultado.getString(2));
                combo.addElement(u);
            }
            Consulta.close();
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS EQUIPO...");
       } 
      return combo;
    }
    
//    public static void main(String[] args){
//        DTurno t=new DTurno();
//        t.setId(3);
//        t.setDescripcion("noche");
//        t.setHorainicio("18:00:00");
//        t.setHorafin("23:00:00");  
//        t.Guardar();
//    }
    
    @Override
    public String toString() {
        return descripcion; //To change body of generated methods, choose Tools | Templates.
    }
}
