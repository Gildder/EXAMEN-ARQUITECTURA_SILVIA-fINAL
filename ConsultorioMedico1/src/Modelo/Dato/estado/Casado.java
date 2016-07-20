/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.estado;

import Modelo.Dato.Conexion;
import java.sql.Statement;

/**
 *
 * @author silvita
 */
public class Casado extends EstadoAccion{
    private Conexion con;
    
    public Casado(Accion estado) {
        super(estado);
        con.getInstance();
    }

    
    @Override
    public void estaCasado(int id) {
        Statement Consulta;
        String dato ="update paciente set nombre='Casado' where idpaciente="+String.valueOf(id)+";";
        try {
            Consulta=(Statement) con.getConexion().createStatement();
            Consulta.execute(dato);
            Consulta.close();
            System.out.println("los datos se GUARDARON con exito...");
        } catch (Exception e) {
            System.out.println("no se puede GUARDAR TABLA Paciente");

        }
    }

    @Override
    public void estaSoltero(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void estaViudo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoAccion EstadoSiguiente() {
        return new Viudo(estados);
    }

    

   
}
