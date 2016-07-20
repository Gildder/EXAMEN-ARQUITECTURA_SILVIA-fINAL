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
public class NMedico {
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
    
    public void Registrar(int id,String nombre,String especialidad,String codprofesional,int tur){
     DatoMedico.setId(id);
     DatoMedico.setNombre(nombre);
     DatoMedico.setEspecialidad(especialidad);
     DatoMedico.setCodprofesional(codprofesional);
     DatoMedico.setTur(tur);
     DatoMedico.Registrar();
     
     
    }
    
    
    
    public void Modificar(int id,String nombre,String especialidad,String codprofesional,int tur){
     DatoMedico.setId(id);
     DatoMedico.setNombre(nombre);
     DatoMedico.setEspecialidad(especialidad);
     DatoMedico.setCodprofesional(codprofesional);
     DatoMedico.setTur(tur);
     DatoMedico.Modificar();
     
     
    }
    
    public void Eliminar(int id){
        DatoMedico.setId(id);
        DatoMedico.Eliminar();
    }

    
    
    public DefaultComboBoxModel buscarDoctores(){
        return DatoMedico.getCombo();
    }
    
}
