/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DDiagnostico;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author silvita
 */
public class NDiagnostico {
    private DDiagnostico DatoDiagnostico;

    public NDiagnostico() {
    DatoDiagnostico = new DDiagnostico();
    }
    public void Registrar(int id, String descripcion ){
        DatoDiagnostico.setId(id);
        DatoDiagnostico.setDescripcion(descripcion);
        DatoDiagnostico.Registrar();
    }
    
    public DefaultTableModel getDiagnostico(){
        return DatoDiagnostico.getTabla();
    }
    
    public DefaultComboBoxModel ListarComboD(){
        return DatoDiagnostico.getCombo();
    }
    
    public void Modificar(int id, String descripcion){
        DatoDiagnostico.setId(id);
        DatoDiagnostico.setDescripcion(descripcion);
        DatoDiagnostico.Modificar();
    }
    
    public void Eliminar(int id){
        DatoDiagnostico.setId(id);
        DatoDiagnostico.Eliminar();
    }
    
//    public int getId(String x){
//        DatoPacinte.setNombre(x);
//        return DatoPaciente.getFila();
//    }

 
     public DefaultComboBoxModel buscarPacientes(){
        return DatoDiagnostico.getCombo();
    }
}
