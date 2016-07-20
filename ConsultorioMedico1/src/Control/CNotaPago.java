/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Modelo.Dato.DPaciente;
import Modelo.Dato.DUsuario;
import Vista.VNotaPago;
import Modelo.Negocio.NNotapago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author silvita
 */
public class CNotaPago implements ActionListener {
    NNotapago NegocioNotaPago;
    VNotaPago Vista;

    public CNotaPago(NNotapago NegocioNotapago,VNotaPago Vista) {
        this.NegocioNotaPago = NegocioNotapago;
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
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String descripcion=Vista.getjTextField2().getText();
                String fecha=Vista.getjTextField3().getText();
                String hora= Vista.getjTextField4().getText();
                int monto =Integer.valueOf(Vista.getjTextField5().getText().toString());
                DUsuario usu=(DUsuario)Vista.getjComboBox1().getSelectedItem();
                DPaciente paci=(DPaciente)Vista.getjComboBox2().getSelectedItem(); 
                
                NegocioNotaPago.Registrar(id, descripcion, fecha,hora,monto ,paci.getId(),usu.getId());
                Vista.Actualizate();
                break;
            case btnmodificar:
                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String descripcionM=Vista.getjTextField2().getText();
                String fechaM=Vista.getjTextField3().getText();
                String horaM= Vista.getjTextField4().getText();
                int montoM =Integer.valueOf(Vista.getjTextField5().getText().toString());
                DPaciente paciM=(DPaciente)Vista.getjComboBox2().getSelectedItem();
                DUsuario usuM=(DUsuario)Vista.getjComboBox1().getSelectedItem();
                
                NegocioNotaPago.Modificar(idM, descripcionM, fechaM, horaM, montoM ,paciM.getId(),usuM.getId() );
                Vista.Actualizate();
                
               
                break;
            case btneliminar:
                NegocioNotaPago.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
                
        }
    }
 
     public static void main(String[] args) {  
        NNotapago modeloP= new NNotapago();
        VNotaPago vista = new VNotaPago();
        CNotaPago control = new CNotaPago(modeloP, vista);
        vista.setVisible(true);
    }
}
