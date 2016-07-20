/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DTurno;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NTurno {
    private DTurno DatoTurno;

    public NTurno() {
    DatoTurno = new DTurno();
    }
    public void Registrar(int id, String descripcion,String horainicio,String horafin ){
        DatoTurno.setId(id);
        DatoTurno.setDescripcion(descripcion);
        DatoTurno.setHorainicio(horainicio);
        DatoTurno.setHorafin(horafin);
        DatoTurno.Registrar();
    }
    
    public DefaultTableModel getTurno(){
        return DatoTurno.getTabla();
    }
    
    public DefaultComboBoxModel ListarCombo(){
        return DatoTurno.getCombo();
    }
    
    public void Modificar(int id, String descripcion,String horainicio,String horafin){
        DatoTurno.setId(id);
        DatoTurno.setDescripcion(descripcion);
        DatoTurno.setHorainicio(horainicio);
        DatoTurno.setHorafin(horafin);
        DatoTurno.Modificar();;
    }
    
    public void Eliminar(int id){
        DatoTurno.setId(id);
        DatoTurno.Eliminar();
    }
    
//    public int getId(String x){
//        DatoTurno.setId(x);
//        return DatoTurno.getFila();
//    }
}
