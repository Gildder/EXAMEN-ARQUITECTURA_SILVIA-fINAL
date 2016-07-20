/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DConsulta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NConsulta {
     private DConsulta DatoConsulta;

    public NConsulta() {
    DatoConsulta= new DConsulta();
    }
    
    
    
    public DefaultTableModel ListaTabla(){
        return DatoConsulta.getTabla();
    }
    
    public void Registrar(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsint ){
     DatoConsulta.setId(id);
     DatoConsulta.setFecha(fecha);
     DatoConsulta.setHora(hora);
     DatoConsulta.setIdpaci(idpaci);
     DatoConsulta.setIdmedi(idmedi);
     DatoConsulta.setIddiag(iddiag);
     DatoConsulta.setIdsint(idsint);
     DatoConsulta.Registrar();
     
    }
    
    
    public void Modificar(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsint){
     DatoConsulta.setId(id);
     DatoConsulta.setFecha(fecha);
     DatoConsulta.setHora(hora);
     DatoConsulta.setIdpaci(idpaci);
     DatoConsulta.setIdmedi(idmedi);
     DatoConsulta.setIddiag(iddiag);
     DatoConsulta.setIdsint(idsint);
     DatoConsulta.Modificar();
     
     
     
    }
    
    public void Eliminar(int id){
        DatoConsulta.setId(id);
        DatoConsulta.Eliminar();
    }

    String[] buscarCita(int citaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String[] buscarConsulta(int citaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
