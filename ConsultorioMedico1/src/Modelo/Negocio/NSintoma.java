/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DSintoma;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NSintoma {
    private DSintoma DatoSintoma;

    public NSintoma() {
    DatoSintoma = new DSintoma();
    }
    public void Registrar(int id, String descripcion ){
        DatoSintoma.setId(id);
        DatoSintoma.setDescripcion(descripcion);
        DatoSintoma.Registrar();
    }
    public DefaultTableModel getSintoma(){
        return DatoSintoma.getTabla();
    }
    
    public DefaultComboBoxModel ListarComboS(){
        return DatoSintoma.getCombo();
    }
    
    public void Modificar(int id, String descripcion){
        DatoSintoma.setId(id);
        DatoSintoma.setDescripcion(descripcion);
        DatoSintoma.Modificar();
    }
    
    public void Eliminar(int id){
        DatoSintoma.setId(id);
        DatoSintoma.Eliminar();
    }

   

      public DefaultComboBoxModel buscarPacientes(){
        return DatoSintoma.getCombo();
    }
}
