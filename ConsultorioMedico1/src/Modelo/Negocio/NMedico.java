/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DMedico;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NMedico extends Registrando{
    private DMedico DatoMedico;

    public NMedico() {
    DatoMedico= new DMedico();
    }
    
    
    
    public DefaultTableModel ListaTabla(){
        return DatoMedico.getTabla();
    }
    public DefaultComboBoxModel ListarCombo(){
        return DatoMedico.getCombo();
    }
    
    @Override
    public void Eliminar(int id){
        DatoMedico.setId(id);
        DatoMedico.Eliminar();
    }

    
    
    public DefaultComboBoxModel buscarDoctores(){
        return DatoMedico.getCombo();
    }

    @Override
    public boolean Validar(int id, String nombre, String fechanac, int telefono, String tiposangre, int peso) {
        if(!nombre.equals("") || !fechanac.equals("")||!tiposangre.equals("") ){
            return true;
        }
        return false;
    }

    @Override
    public void Registrar(int id, String nombre, String especialidad, int telefono, String codprofesional, int tur, String nulo) {
     DatoMedico.setId(id);
     DatoMedico.setNombre(nombre);
     DatoMedico.setEspecialidad(especialidad);
     DatoMedico.setCodprofesional(codprofesional);
     DatoMedico.setTur(tur);
     DatoMedico.Registrar();
    }

    @Override
    public void Modificar(int id, String nombre, String especialidad, int telefono, String codprofesional, int tur, String nulo) {
        DatoMedico.setId(id);
        DatoMedico.setNombre(nombre);
        DatoMedico.setEspecialidad(especialidad);
        DatoMedico.setCodprofesional(codprofesional);
        DatoMedico.setTur(tur);
        DatoMedico.Modificar();
    }
    
}
