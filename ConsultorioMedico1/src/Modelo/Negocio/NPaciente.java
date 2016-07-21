/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DPaciente;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NPaciente extends Registrando{
    private DPaciente DatoPaciente;
    
    

    public NPaciente() {
    DatoPaciente = new DPaciente();
    }
     
    public DefaultTableModel getPaciente(){
        return DatoPaciente.getTabla();
    }
    
    public DefaultComboBoxModel ListarComboP(){
        return DatoPaciente.getCombo();
    }
    
        
    @Override
    public void Eliminar(int id){
        DatoPaciente.setId(id);
        DatoPaciente.Eliminar();
    }
    
    public int getId(String x){
        DatoPaciente.setNombre(x);
        return DatoPaciente.getFila();
    }

    DefaultComboBoxModel buscarConsultorios() {
        return DatoPaciente.getCombo();
    }

    @Override
    public boolean Validar(int id, String nombre, String fechanac, int telefono, String tiposangre, int peso) {
        if(!nombre.equals("") || !fechanac.equals("")||!tiposangre.equals("") ){
            return true;
        }
        return false;
    }

    @Override
    public void Registrar(int id, String nombre, String fechanac, int telefono, String tiposangre, int peso, String estado) {
        DatoPaciente.setId(id);
        DatoPaciente.setFechanac(fechanac);
        DatoPaciente.setTelefono(telefono);
        DatoPaciente.setTiposangre(tiposangre);
        DatoPaciente.setPeso(peso);
        DatoPaciente.setEstadoCivil(estado);
        DatoPaciente.Registrar();
    }

    @Override
    public void Modificar(int id, String nombre, String fechanac, int telefono, String tiposangre, int peso, String estado) {
        DatoPaciente.setId(id);
        DatoPaciente.setNombre(nombre);
        DatoPaciente.setFechanac(fechanac);
        DatoPaciente.setTelefono(telefono);
        DatoPaciente.setTiposangre(tiposangre);
        DatoPaciente.setPeso(peso);
        DatoPaciente.setEstadoCivil(estado);
        DatoPaciente.Modificar();
    }
}
