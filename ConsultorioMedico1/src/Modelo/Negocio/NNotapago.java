/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DNotaPago;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NNotapago {
    private DNotaPago DatoNotapago;

    public NNotapago() {
    DatoNotapago= new DNotaPago();
    }
    
    
    
    public DefaultTableModel ListaTabla(){
        return DatoNotapago.getTabla();
    }
    
    public void Registrar(int id,String descripcion,String fecha,String hora,int monto,int paciente,int usuario){
     DatoNotapago.setId(id);
     DatoNotapago.setDescripcion(descripcion);
     DatoNotapago.setFecha(fecha);
     DatoNotapago.setHora(hora);
     DatoNotapago.setMonto(monto);
     DatoNotapago.setPaci(paciente);
     DatoNotapago.setUsu(usuario);
     DatoNotapago.Registrar();
     
    }
    
    
    
    public void Modificar(int id,String descripcion,String fecha,String hora,int monto,int paciente,int usuario){
     DatoNotapago.setId(id);
     DatoNotapago.setDescripcion(descripcion);
     DatoNotapago.setFecha(fecha);
     DatoNotapago.setHora(hora);
     DatoNotapago.setMonto(monto);
     DatoNotapago.setPaci(paciente);
     DatoNotapago.setUsu(usuario);
     DatoNotapago.Modificar();
     
     
    }
    
    public void Eliminar(int id){
        DatoNotapago.setId(id);
        DatoNotapago.Eliminar();
    }
    
}
