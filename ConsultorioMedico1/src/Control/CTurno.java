/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Negocio.NTurno;
import Vista.VTurno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author silvita
 */
public class CTurno implements ActionListener{
    private NTurno NegocioTurno;
    private VTurno Vista;
    
    
    public enum AccionMVC
    {
        btnregistrar,
        btnmodificar,
        btneliminar
    }
    
    public CTurno(NTurno Modelo,VTurno Vista){
        
        this.NegocioTurno=Modelo;
        this.Vista=Vista;
        initComponente();
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
        switch ( CPaciente.AccionMVC.valueOf( ae.getActionCommand() ) )
        {
            case btnregistrar:
               String x =Vista.getjTextField1().getText();
               if(x!=""){
//                NegocioPaciente.SetPaciente(Integer.valueOf(Vista.getjTextField1().getText()), Vista.getjTextField2().getText(),Integer.valueOf(Vista.getjTextField3()), Vista.getjTextField4().getText());
//                Vista.Actualizate();
//                }else{
//                    System.out.println("introduce id");
//                }
//             
//                
//                break;
                
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String descripcion=Vista.getjTextField2().getText();
                String horainicio=Vista.getjTextField3().getText();
                String horafin= Vista.getjTextField4().getText();
                
                NegocioTurno.Registrar(id, descripcion, horainicio,horafin);
                Vista.Actualizate();
                }else{
                    System.out.println("introduce id");
                }
                break;
                
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String descripcionM=Vista.getjTextField2().getText();
                String horainicioM=Vista.getjTextField3().getText();
                String horafinM= Vista.getjTextField4().getText();
                
                NegocioTurno.Modificar(idM, descripcionM, horainicioM,horafinM);
                Vista.Actualizate();
                break;
        
//            case btnmodificar:
//                NegocioPaciente.Modificar(Integer.valueOf(Vista.getjTextField1().getText()), Vista.getjTextField2().getText());
//                Vista.Actualizate();
//                break;
            case btneliminar:
                NegocioTurno.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
          
        }
     }
    
     public static void main(String[] args) {  
        NTurno modelo=new NTurno();
        VTurno vista = new VTurno();
        CTurno control = new CTurno(modelo, vista);
        vista.setVisible(true);
    }
}
