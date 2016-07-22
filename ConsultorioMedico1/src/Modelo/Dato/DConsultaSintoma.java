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
public class DConsultaSintoma {
      private Conexion con;
    private int idsinto;
    private int idconsul;
    private String tiempo;

    public DConsultaSintoma() {
        con = con.getInstance();
    }

    public int getIdsinto() {
        return idsinto;
    }

    public void setIdsinto(int idsinto) {
        this.idsinto = idsinto;
    }

    public int getIdconsul() {
        return idconsul;
    }

    public void setIdconsul(int idconsul) {
        this.idconsul = idconsul;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    
    
    public void Registrar(){
       Statement Consulta;
       String dato ="insert into consultasintoma values ('"+tiempo+"',"+String.valueOf(idconsul)+","+String.valueOf(idsinto)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se Registraron con exito...");
       } catch (Exception e) {
           System.out.println("no se puede Registrar en la tabla ConsultaSintoma");

       }
    
    }
//     public void Guardar() {
//        try {
//            Statement Consulta;
////      
//            String dato = "insert into detalle_receta values(" + null + ",'" + clasificacion + "','" + medida + "','" + dosis + "'," + String.valueOf(idR) + "," + String.valueOf(idM) + ");";
//
//            Consulta = (Statement) co.co().createStatement();
//            Consulta.execute(dato);
//            System.out.println(dato);
//            Consulta.close();
//            System.out.println("los datos se GUARDARON con exito...");
//        } catch (Exception e) {
//            System.out.println("no se puede GUARDAR TABLA Detalle");
//
//        }
//
//    }
//    public void Eliminar(){
//       Statement Consulta;
//       String dato ="delete from consultasintoma where idconsul="+String.valueOf(idconsul)+" and idsinto="+String.valueOf(idsinto)+";";
//       try {
//          Consulta=(Statement) con.getConexion().createStatement();
//          Consulta.execute(dato);
//           Consulta.close();
//           System.out.println("los datos se Eliminarom con exito...");
//       } catch (Exception e) {
//       System.out.println("no se puede registrar la conexion");
//           System.out.println("no se pudo eliminar en la tabla ConsultaSintoma");
//       }
//    }
//    
    public DefaultTableModel Cargar(){
        String[] columnNames = {"idconsul","descripcion","tiempo"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
//      String dato="select p.cod,d.monto,p.titulo,p.precio,p.precio*d.monto as monto from detalle d,pelicula p where d.nroficha="+String.valueOf(nro)+" and d.codpeli=p.cod;";
        String dato="select s.idsintoma,s.descripcion,a.tiempo from sintomaconsulta a,csintoma s where s.idsintoma="+String.valueOf(idsinto)+";";

        try {
           Consulta=(Statement) con.getConexion().createStatement();
           resultado=Consulta.executeQuery(dato);
            int i =0;
            while(resultado.next()){
                tabla.setRowCount(tabla.getRowCount()+1);
                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultado.getObject(3).toString(), i, 2);
                //tabla.setValueAt(resultado.getObject(4).toString(), i, 3);
                i++;
            }
            Consulta.close();
            System.out.println("se cargarron "+i+" filas");
           
       } catch (Exception e) {
            System.out.println("no se pudo CARGAR LOS DATOS TABLA DETALLE");
       } 
      
      return tabla;
    }
    
    

//    public DefaultTableModel Cargar(int cod) {
//        String[] columnNames = {"id", "nombre", "clasificacion", "medida", "dosis"};
//        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0);
//        Statement Consulta;
//        ResultSet resultado = null;
//
//        String dato = "select m.id ,m.nombre,p.clasificacion,p.medida ,p.dosis from detalle_receta p, medicamento m where m.id=" + String.valueOf(cod) + ";";
//        try {
//            Consulta = (Statement) co.co().createStatement();
//            resultado = Consulta.executeQuery(dato);
//            int i = 0;
//            while (resultado.next()) {
//                tabla.setRowCount(tabla.getRowCount() + 1);
//                tabla.setValueAt(resultado.getObject(1).toString(), i, 0);
//                tabla.setValueAt(resultado.getObject(2).toString(), i, 1);
//                tabla.setValueAt(resultado.getObject(3).toString(), i, 2);
//                tabla.setValueAt(resultado.getObject(4).toString(), i, 3);
//                tabla.setValueAt(resultado.getObject(5).toString(), i, 4);
////         
//                i++;
//            }
//            Consulta.close();
//            System.out.println("se cargarron " + i + " filas");
//
//        } catch (Exception e) {
//            System.out.println("no se pudo CARGAR LOS DATOS TABLA DETALLE");
//        }
//
//        return tabla;
//    }
    
//  
//        public static void main(String[] args){
//        DConsultaSintoma t=new DConsultaSintoma();
//        
//        //t.setTiempo("30 min");
//        t.setIdconsul(3);
//        t.setIdsinto(3);
// 
//        t.Eliminar();
//     }
    
}
