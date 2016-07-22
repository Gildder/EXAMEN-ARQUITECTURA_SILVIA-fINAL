/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.Dato.DConsulta;
import Modelo.Dato.trasaccion.ApuntarConsulta;
import Modelo.Dato.trasaccion.ConsultaPaciente;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author silvita
 */
public class NConsulta {
     private DConsulta DatoConsulta;
     //clase del patron trasancion
     private ConsultaPaciente  consultaPaciente;
    static ApuntarConsulta apuntarConsulta;
    public NConsulta() {
        DatoConsulta= new DConsulta();
        consultaPaciente = new ApuntarConsulta();
        apuntarConsulta = new ApuntarConsulta();
    }
    
    
    public DefaultTableModel ListaTabla(){
        return DatoConsulta.getTabla();
    }
    
    public void Registrar(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsint ){
     DatoConsulta.isNuevo=true;
     DatoConsulta.setId(id);
     DatoConsulta.setFecha(fecha);
     DatoConsulta.setHora(hora);
     DatoConsulta.setIdpaci(idpaci);
     DatoConsulta.setIdmedi(idmedi);
     DatoConsulta.setIddiag(iddiag);
     DatoConsulta.setIdsint(idsint);
     
     
     Date nuevaFecha=new Date(fecha);
     consultaPaciente.addConsulta((long)id, DatoConsulta);
     if(changeDateConsulta((long) id,nuevaFecha , DatoConsulta)){
         DatoConsulta.Registrar();
        consultaPaciente.commit((long) id);
     }else{
         consultaPaciente.cancel((long) id);
     }
     
    }
    
    
    public void Modificar(int id,String fecha,String hora,int idpaci,int idmedi ,int iddiag, int idsint){
     DatoConsulta.isNuevo=false;
     DatoConsulta.setId(id);
     DatoConsulta.setFecha(fecha);
     DatoConsulta.setHora(hora);
     DatoConsulta.setIdpaci(idpaci);
     DatoConsulta.setIdmedi(idmedi);
     DatoConsulta.setIddiag(iddiag);
     DatoConsulta.setIdsint(idsint);
     
     //trasaccion
     Date nuevaFecha=new Date(fecha);
     consultaPaciente.addConsulta((long)id, DatoConsulta);
     if(changeDateConsulta((long) id,nuevaFecha , DatoConsulta)){
        DatoConsulta.Modificar();
        consultaPaciente.commit((long) id);
     }else{
         consultaPaciente.cancel((long) id);
     }
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
    
    //Metodos de Trasaction
    public static boolean changeDateConsulta(long idtrasac, Date fecha,DConsulta consulta){
            apuntarConsulta.changeDate(idtrasac, fecha, consulta);
            if(!apuntarConsulta.join(idtrasac)){
                return false;
            }
           if(!apuntarConsulta.changeDate(idtrasac, fecha, consulta)) 
               return false;
        return true;
    }
    public static void commitAll(long transactionID,ConsultaPaciente agendas[]){
        for (ConsultaPaciente agenda : agendas) {
            agenda.commit(transactionID);
        }
    }
    public static void cancelAll(long transactionID,ConsultaPaciente agendas[]){
        for (ConsultaPaciente agenda : agendas) {
            agenda.cancel(transactionID);
        }
    }
    
}
