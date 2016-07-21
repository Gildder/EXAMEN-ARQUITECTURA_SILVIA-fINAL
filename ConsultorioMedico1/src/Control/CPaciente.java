/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Negocio.NPaciente;
import Modelo.Negocio.Registrando;
import Vista.VPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author silvita
 */
public class CPaciente implements ActionListener{
    private VPaciente Vista;
    
    //clase plantilla
    public Registrando nuevoPaciente;

   public CPaciente(NPaciente NegocioNPaciente,VPaciente Vista){
        
        this.nuevoPaciente= NegocioNPaciente;
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
        switch ( AccionMVC.valueOf( ae.getActionCommand() ) )
        {
            case btnregistrar:
               String x =Vista.getjTextField1().getText();
               if(x!=""){
              
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombre=Vista.getjTextField2().getText();
                String fechanac=Vista.getjTextField3().getText();
                String tiposangre= Vista.getjTextField5().getText();
                int telefono =Integer.valueOf(Vista.getjTextField4().getText().toString());
                int peso=Integer.valueOf(Vista.getjTextField6().getText().toString());
                String estado=Vista.getjTextFieldCivil();
                
                nuevoPaciente.Nuevo(id, nombre, fechanac,telefono,tiposangre,peso,estado);
                Vista.Actualizate();
                }else{
                    System.out.println("introduce id");
                }
                break;
                
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombreM=Vista.getjTextField2().getText();
                String fechanacM=Vista.getjTextField3().getText();
                String tiposangreM= Vista.getjTextField5().getText();
                int telefonoM=Integer.valueOf(Vista.getjTextField4().getText().toString());
                int pesoM=Integer.valueOf(Vista.getjTextField6().getText().toString());
                String estado=Vista.getjTextFieldCivil();

                nuevoPaciente.Actualizar(idM, nombreM, fechanacM,telefonoM,tiposangreM,pesoM,estado);
                Vista.Actualizate();
                break;
            case btneliminar:
                nuevoPaciente.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
          
        }
     }
    
     public static void main(String[] args) {  
        NPaciente modelo=new NPaciente();
        VPaciente vista = new VPaciente();
        CPaciente control = new CPaciente(modelo, vista);
        vista.setVisible(true);
    }
}
