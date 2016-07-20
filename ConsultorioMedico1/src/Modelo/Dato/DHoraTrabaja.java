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
public class DHoraTrabaja {
    private Conexion con;
    private int idmedi;
    private int idtur;
    private String dia;

    public DHoraTrabaja() {
        con= new Conexion();
    }

    public int getIdmedi() {
        return idmedi;
    }

    public void setIdmedi(int idmedi) {
        this.idmedi = idmedi;
    }

    public int getIdtur() {
        return idtur;
    }

    public void setIdtur(int idtur) {
        this.idtur = idtur;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into horatrabaja values ('"+dia+"',"+String.valueOf(idmedi)+","+String.valueOf(idtur)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se Registraron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede Registrar en la tabla HoraTrabaja");

       }
    
    }
       
    public void Eliminar(){
       Statement Consulta;
       String dato ="delete from horatrabaja where idmedico="+String.valueOf(idmedi)+" and idturno="+String.valueOf(idtur)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se Eliminarom con exito...");
       } catch (Exception e) {
       System.out.println("no se puede registrar la conexion");
           System.out.println("no se pudo eliminar en la tabla ConsultaSintoma");
       }
    }
    
    public DefaultTableModel Cargar(){
        String[] columnNames = {"Codigo","codigoMedico","Dia","Turno"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
//        String dato="select p.cod,d.monto,p.titulo,p.precio,p.precio*d.monto as monto from detalle d,pelicula p where d.nroficha="+String.valueOf(nro)+" and d.codpeli=p.cod;";
        String dato="select t.idturno,h.idmedico, h.dia, t.descripcion from horatrabaja h, turno t where h.idmedico="+String.valueOf(idmedi)+" and t.idturno="+String.valueOf(idtur)+";";

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
                i++;
            }
            Consulta.close();
            System.out.println("se cargarron "+i+" filas");
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA HORA TRABAJA jiji");
       } 
      
      return tabla;
    }
  
//    public static void main(String[] args){
//    DHoraTrabaja t=new DHoraTrabaja();
//    t.setDia("viernes");
//    t.setIdmedi(2);
//    t.setIdtur(2);
//    
//    t.Registrar();
//     } 
}
