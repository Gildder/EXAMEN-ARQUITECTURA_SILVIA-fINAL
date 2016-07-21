/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Dato.DTurno;
import Vista.VMedico;
import Modelo.Negocio.NMedico;
import Modelo.Negocio.Registrando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author silvita
 */
public class CMedico implements ActionListener{
    //clase plantilla
    Registrando nuevoMedico;
    VMedico Vista;

    public CMedico(NMedico NegocioMedico,VMedico Vista) {
        this.nuevoMedico = NegocioMedico;
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
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        switch ( CNotaPago.AccionMVC.valueOf( ae.getActionCommand() ) )
        {
            case btnregistrar:
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombre=Vista.getjTextField2().getText();
                String especialidad=Vista.getjTextField3().getText();
                String codprofesional= Vista.getjTextField4().getText();
                DTurno tur =(DTurno)Vista.getjComboBox1().getSelectedItem();
                
                nuevoMedico.Nuevo(id,nombre,especialidad,0,codprofesional,tur.getId(),"");
                Vista.Actualizate();
                break;
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombreM=Vista.getjTextField2().getText();
                String especialidadM=Vista.getjTextField3().getText();
                String codprofesionalM= Vista.getjTextField4().getText();
                DTurno turM =(DTurno)Vista.getjComboBox1().getSelectedItem();
               
                nuevoMedico.Actualizar(idM,nombreM,especialidadM,0,codprofesionalM,turM.getId(),"");
                Vista.Actualizate();
                
               
                break;
            case btneliminar:
                nuevoMedico.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
                
        }
    }
 
    
     public static void main(String[] args) {  
       
        NMedico modelo = new NMedico();
        VMedico vista = new VMedico();
        CMedico control = new CMedico(modelo, vista);
        vista.setVisible(true);
    }
}
