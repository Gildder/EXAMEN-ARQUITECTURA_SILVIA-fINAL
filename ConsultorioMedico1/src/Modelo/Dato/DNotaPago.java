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
public class DNotaPago {
    private Conexion con;
    private int id;
    private String descripcion;
    private String fecha;
    private String hora;
    private int monto;
    private int paci;
    private int usu;

    public DNotaPago() {
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getPaci() {
        return paci;
    }

    public void setPaci(int paci) {
        this.paci = paci;
    }

    public int getUsu() {
        return usu;
    }

    public void setUsu(int usu) {
        this.usu = usu;
    }
   
    
    
     public void Registrar(){
       Statement Consulta;
       String dato ="insert into notapago values ("+String.valueOf(id)+",'"+descripcion+"','"+fecha+"','"+hora+"',"+String.valueOf(monto)+","+String.valueOf(paci)+","+String.valueOf(usu)+");";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se GUARDARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede GUARDAT TABLA NOTA PAGO");

       }
    
    }
     
     
      public void Modificar(){
       Statement Consulta;
       String dato ="update notapago set descripcion='"+descripcion+"' , fecha='"+fecha+"',hora='"+hora+"', monto="+String.valueOf(monto)+" ,idpaciente="+String.valueOf(paci)+",idusuario="+String.valueOf(usu)+" where idnotapago="+String.valueOf(id)+" ;";
       try {
           Consulta=(Statement) con.getConexion().createStatement();
           Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se MODIFICARON con exito...");
       } catch (Exception e) {
           System.out.println("no se puede MODIFICAR TABLA NOTA PAGO");

       }
    
    }
      
      
      public void Eliminar(){
       Statement Consulta;
       String dato ="delete from notapago where idnotapago="+String.valueOf(id)+";";
       try {
          Consulta=(Statement) con.getConexion().createStatement();
          Consulta.execute(dato);
           Consulta.close();
           System.out.println("los datos se ELIMINARON con exito...");
       } catch (Exception e) {
       System.out.println("no se puede REGISTRAR la conexion");
           System.out.println("no se pudo eliminar en la tabl PELICULA");
       }
    }   
    public DefaultTableModel getTabla(){
        String[] columnNames = {"idnotaPago","Descripcion","Fecha","Hora","Monto","Paciente","Usuario"};
        DefaultTableModel tabla = new DefaultTableModel(columnNames, 0); 
        Statement Consulta;
        ResultSet resultado=null;
       // String dato="select p.cod,p.titulo,p.duracion,p.precio,g.nombre from pelicula p,genero g where p.gen=g.nro;";
        String dato="select n.idnotapago,n.descripcion, n.fecha, n.hora, n.monto,p.nombre, u.nombre from notapago n, usuario u, paciente p where n.idusuario=u.idusuario and n.idpaciente=p.idpaciente;";
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
            System.out.println("no se pudo CARGAR LOS DATOS TABLA nota pago");
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
