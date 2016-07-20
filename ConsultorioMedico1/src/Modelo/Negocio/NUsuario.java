/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DUsuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NUsuario {
    private DUsuario DatoUsuario;

    public NUsuario() {
    DatoUsuario = new DUsuario();
    }
    public void Registrar(int id, String nombre,int telefono,String tipo,String ci, String contrasena ){
        DatoUsuario.setId(id);
        DatoUsuario.setNombre(nombre);
        DatoUsuario.setTelefono(telefono);
        DatoUsuario.setTipo(tipo);
        DatoUsuario.setCi(ci);
        DatoUsuario.setContrasena(contrasena);
        DatoUsuario.Registrar();
        
    }
    
    public DefaultTableModel getUsuario(){
        return DatoUsuario.getTabla();
    }
       
    public DefaultComboBoxModel ListarCombo(){
        return DatoUsuario.getCombo();
    }
   
    
    public void Modificar(int id, String nombre,int telefono,String tipo,String ci, String contrasena){
        DatoUsuario.setId(id);
        DatoUsuario.setNombre(nombre);
        DatoUsuario.setTelefono(telefono);
        DatoUsuario.setTipo(tipo);
        DatoUsuario.setCi(ci);
        DatoUsuario.setContrasena(contrasena);
        DatoUsuario.Modificar();
    }
    
    public void Eliminar(int id){
        DatoUsuario.setId(id);
        DatoUsuario.Eliminar();
    }
}
