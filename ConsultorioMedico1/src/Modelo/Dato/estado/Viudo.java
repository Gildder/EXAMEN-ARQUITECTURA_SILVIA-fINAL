/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Dato.estado;

import Modelo.Dato.Conexion;
import java.sql.Statement;

/**
 *
 * @author gildder
 */
class Viudo extends EstadoAccion {
    private Conexion con;

    public Viudo(Accion estados) {
        super(estados);
        con.getInstance();
    }

    @Override
    public void estaSoltero(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void estaCasado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void estaViudo(int id) {
        Statement Consulta;
        String dato ="update paciente set nombre='Viudo' where idpaciente="+String.valueOf(id)+";";
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
    public EstadoAccion EstadoSiguiente() {
        return new Viudo(estados);
    }
    
}
