/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Negocio.NSintoma;
import Vista.VSintoma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author silvita
 */
public class CSintoma implements ActionListener{
    private NSintoma NegocioSintoma;
    private VSintoma Vista;

    
    
    public enum AccionMVC
    {
        btnregistrar,
        btnmodificar,
        btneliminar
    }
    
    public CSintoma(NSintoma Modelo,VSintoma Vista){
        
        this.NegocioSintoma=Modelo;
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
//            case btnregistrar:
//                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
//                String descripcion=Vista.getjTextField2().getText();
//                NegocioDiagnostico.Registrar(id,descripcion);
//                Vista.Actualizate();
//                break;
                
//            case btnmodificar:
//                int idM =Integer.valueOf(Vista.getjTextField1().getText().toString());
//                String descripcionM=Vista.getjTextField2().getText();
//                NegocioDiagnostico.Modificar(idM, descripcionM);
//                Vista.Actualizate();
//                break;
        case btnregistrar:
                String x =Vista.getjTextField1().getText();
                if(x!=""){
  //              NegocioDiagnostico.Registrar(Integer.valueOf(Vista.getjTextField1().getText()), Vista.getjTextField2().getText());
    //            Vista.Actualizate();
                int id =Integer.valueOf(Vista.getjTextField1().getText().toString());
                String descripcion=Vista.getjTextField2().getText();
                NegocioSintoma.Registrar(id,descripcion);
                Vista.Actualizate();
                }else{
                    System.out.println("introduce id");
                }
            break;
            case btnmodificar:
                NegocioSintoma.Modificar(Integer.valueOf(Vista.getjTextField1().getText()), Vista.getjTextField2().getText());
                Vista.Actualizate();
                break;
            case btneliminar:
                NegocioSintoma.Eliminar(Integer.valueOf(Vista.getjTextField1().getText()));
                Vista.Actualizate();
                break;
          
        }
     }
    
     public static void main(String[] args) {  
        NSintoma modelo=new NSintoma();
        VSintoma vista = new VSintoma();
        CSintoma control = new CSintoma(modelo, vista);
        vista.setVisible(true);
    }
}
