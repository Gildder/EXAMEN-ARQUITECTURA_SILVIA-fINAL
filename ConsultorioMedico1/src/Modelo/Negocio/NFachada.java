/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author silvita
 */
public class NFachada {
    private NConsulta nConsulta;
    private NPaciente npaciente = new NPaciente();
    private NMedico nMedico = new NMedico();
    private NDiagnostico nDiagnostico = new NDiagnostico();
    private NSintoma nSintoma = new NSintoma();
    public NFachada(){
        this.nConsulta = new NConsulta();
    }
    
    public void registrarConsulta(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsint) {
        nConsulta.Registrar(id, fecha, hora, idpaci, idmedi, iddiag,idsint);
    }

    public void modificarConsulta(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsintD) {
        nConsulta.Modificar(id, fecha, hora, idpaci, idmedi, iddiag, idsintD);
    }

    public void eliminarConsulta(int citaID) {
        nConsulta.Eliminar(citaID);
    }
    
     public String[] buscarConsulta(int citaID) {
        return nConsulta.buscarConsulta(citaID);        
    }
    
    public DefaultComboBoxModel buscarPaciente() {    
        return npaciente.buscarConsultorios();
    }
    
    public DefaultComboBoxModel buscarMedicos() {
        return nMedico.buscarDoctores();
    }    
    
    public DefaultComboBoxModel buscarDiagnosticos() {
        return nDiagnostico.buscarPacientes();
    }  
    
    public DefaultComboBoxModel buscarSintomas() {
        return nSintoma.buscarPacientes();
    }  
    
}
