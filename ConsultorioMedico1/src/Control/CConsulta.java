/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Dato.DDiagnostico;
import Modelo.Dato.DMedico;
import Modelo.Dato.DPaciente;
import Modelo.Dato.DSintoma;
import Modelo.Negocio.NConsulta;
import Modelo.Negocio.NFachada;
import Vista.VConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;

/**
 *
 * @author silvita
 */
public class CConsulta implements ActionListener{
   NConsulta NegocioConsulta;
    NFachada fachada =new NFachada();
   VConsulta Vista;

    public CConsulta(NConsulta NegocioConsulta,VConsulta Vista) {
        this.NegocioConsulta = NegocioConsulta;
        
        
        
        this.Vista=Vista;
        initComponente();
    }
    
    public enum AccionMVC
    {
        btnregistrar,
        btnmodificar,
        btneliminar
    }

    public void initComponente(){
      this.Vista.btnregistrar.setActionCommand( "btnregistrar" );
        this.Vista.btnregistrar.addActionListener(this);
        this.Vista.btnmodificar.setActionCommand( "btnmodificar" );
        this.Vista.btnmodificar.addActionListener(this);
        this.Vista.btneliminar.setActionCommand( "btneliminar" );
        this.Vista.btneliminar.addActionListener(this);
        
        cargaCombo();
    }
    
     public void cargaCombo(){
        Vista.getjComboBox1().setModel((ComboBoxModel) fachada.buscarMedicos());
        Vista.getjComboBox2().setModel((ComboBoxModel) fachada.buscarDiagnosticos());
        Vista.getjComboBox3().setModel((ComboBoxModel) fachada.buscarPaciente());
        Vista.getjComboBox4().setModel((ComboBoxModel) fachada.buscarSintomas());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        switch ( CNotaPago.AccionMVC.valueOf( ae.getActionCommand() ) )
        {
            case btnregistrar:
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String fecha=Vista.getjTextField2().getText();
                String hora= Vista.getjTextField3().getText();
                DMedico idmedi=(DMedico)Vista.getjComboBox1().getSelectedItem();
                DDiagnostico iddiag=(DDiagnostico)Vista.getjComboBox2().getSelectedItem();
                DPaciente idpaci=(DPaciente)Vista.getjComboBox3().getSelectedItem(); 
                DSintoma idsint=(DSintoma)Vista.getjComboBox4().getSelectedItem();
//                NegocioConsulta.Registrar(id,fecha,hora,idmedi.getId(),iddiag.getId(),idpaci.getId(),idsint.getId());
                fachada.registrarConsulta(id,fecha,hora,idmedi.getId(),iddiag.getId(),idpaci.getId(),idsint.getId());
                Vista.Actualizate();
                break;
   
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String fechaM=Vista.getjTextField2().getText();
                String horaM= Vista.getjTextField3().getText();
                DMedico idmediM=(DMedico)Vista.getjComboBox1().getSelectedItem();
                DDiagnostico iddiagM=(DDiagnostico)Vista.getjComboBox2().getSelectedItem();
                DPaciente idpaciM=(DPaciente)Vista.getjComboBox3().getSelectedItem(); 
                DSintoma idsintM=(DSintoma)Vista.getjComboBox4().getSelectedItem();
                NegocioConsulta.Modificar(idM,fechaM,horaM,idmediM.getId(),iddiagM.getId(),idpaciM.getId(),idsintM.getId());
                Vista.Actualizate();
               
                break;
            case btneliminar:
                NegocioConsulta.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
                
        }
    }
 
     public static void main(String[] args) {  
        NConsulta modelo= new NConsulta();
        VConsulta vista = new VConsulta();
        CConsulta control = new CConsulta(modelo, vista);
        vista.setVisible(true);
    } 
}
