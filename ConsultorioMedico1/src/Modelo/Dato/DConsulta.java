/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author silvita
 */
public class DConsulta {
   private Conexion con;
    private int id;
    private String fecha;
    private String hora;
    private int idpaci;
    private int idmedi;
    private int iddiag;
    private int idsint;
   

    public DConsulta() {
        con.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdpaci() {
        return idpaci;
    }

    public void setIdpaci(int idpaci) {
        this.idpaci = idpaci;
    }

    public int getIdmedi() {
        return idmedi;
    }

    public void setIdmedi(int idmedi) {
        this.idmedi = idmedi;
    }

    public int getIddiag() {
        return iddiag;
    }

    public void setIddiag(int iddiag) {
        this.iddiag = iddiag;
    }

    public int getIdsint() {
        return idsint;
    }

    public void setIdsint(int idsint) {
        this.idsint = idsint;
    }

    
    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into consulta values ("+String.valueOf(id)+",'"+fecha+"','"+hora+"',"+String.valueOf(idpaci)+","+String.valueOf(idmedi)+","+String.valueOf(iddiag)+","+String.valueOf(idsint)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se Reistraron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede Registrar en la tabla Consulta");

       }
    
    }
    public void Modificar(){
       Statement Consulta;
       String dato ="update consulta set fecha='"+fecha+"' , hora='"+hora+"' , idpaciente="+String.valueOf(idpaci)+" ,idmedico="+String.valueOf(idmedi)+",iddiagnostico="+String.valueOf(iddiag)+",idsintoma="+String.valueOf(idsint)+" where idconsulta="+String.valueOf(id)+" ;";
     //  String dato ="update pelicula set titulo='"+titulo+"' , duracion="+String.valueOf(duracion)+" ,precio="+String.valueOf(precio)+",gen="+String.valueOf(gen)+" where cod="+String.valueOf(cod)+" ;";

       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se modificaron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede modificar la Consulta");

       }
    
    }
    public void Eliminar(){
       Statement Consulta;
       String dato ="delete from consulta where idconsulta="+String.valueOf(id)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se eliminaron con exito...");
       } catch (Exception e) {
       System.out.println("no se puede registrar la conexion");
           System.out.println("no se pudo eliminar la Consulta");
       }
    }
     public DefaultTableModel getTabla(){
        String[] columnNames = {"idconsulta","Fecha","Hora","Medico","Diagnostico","Paciente","Sintoma"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
       // String dato="select p.cod,p.titulo,p.duracion,p.precio,g.nombre from pelicula p,genero g where p.gen=g.nro;";
        String dato="select c.idconsulta,c.fecha, c.hora,m.nombre,d.descripcion,p.nombre,s.descripcion from consulta c, medico m, paciente p,diagnostico d,sintoma s where c.idmedico=m.idmedico and c.idpaciente=p.idpaciente and c.iddiagnostico=d.iddiagnostico and c.idsintoma=s.idsintoma;";
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
                i++;
            }
            Consulta.close();
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA CONSULTA");
       } 
      
      return tabla;
    }
//     
//   public static void main(String[] args){
//        DConsulta t=new DConsulta();
//        t.setId(4);
////        t.setFecha("2016-04-24");
////        t.setHora("10:15:00");
////        t.setIdpaci(3);
////        t.setIdmedi(1);
////        t.setIddiag(1);
//       // t.Modificar();
//      // t.Registrar();
//       // t.setId(4);
//     t.Eliminar();
//    }  
     
}
