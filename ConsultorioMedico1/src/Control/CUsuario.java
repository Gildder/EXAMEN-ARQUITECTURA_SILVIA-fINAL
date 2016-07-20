/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Negocio.NUsuario;
import Vista.VTurno;
import Vista.VUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author silvita
 */
public class CUsuario implements ActionListener{
    private NUsuario NegocioUsuario;
    private VUsuario Vista;
    
    
    public enum AccionMVC
    {
        btnregistrar,
        btnmodificar,
        btneliminar
    }
    
    public CUsuario(NUsuario Modelo,VUsuario Vista){
        
        this.NegocioUsuario=Modelo;
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

                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombre=Vista.getjTextField2().getText();
                int telefono =Integer.valueOf(Vista.getjTextField3().getText().toString());
                String tipo=Vista.getjTextField4().getText();
                String ci= Vista.getjTextField5().getText();
                String contrasena=Vista.getjTextField6().getText();
             
                NegocioUsuario.Registrar(id, nombre,telefono,tipo,ci,contrasena);
                Vista.Actualizate();
                }else{
                    System.out.println("introduce id");
                }
                break;
                
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String nombreM=Vista.getjTextField2().getText();
                int telefonoM =Integer.valueOf(Vista.getjTextField3().getText().toString());
                String tipoM=Vista.getjTextField4().getText();
                String ciM= Vista.getjTextField5().getText();
                String contrasenaM=Vista.getjTextField6().getText();
             
                NegocioUsuario.Modificar(idM, nombreM,telefonoM,tipoM,ciM,contrasenaM);
                Vista.Actualizate();
                break;
        
            case btneliminar:
                NegocioUsuario.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
          
        }
     }
    
     public static void main(String[] args) {  
        NUsuario modelo=new NUsuario();
        VUsuario vista = new VUsuario();
        CUsuario control = new CUsuario(modelo, vista);
        vista.setVisible(true);
    }
}
