/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.estado;

/**
 *
 * @author silvita
 */
public class Accion {
    protected EstadoAccion estadoCivil;

    public Accion() {
        this.estadoCivil = new Soltero(this);
    }

    public void Soltero(int id) {
        estadoCivil.estaSoltero(id);
    }

    public void Casado(int id) {
        estadoCivil.estaSoltero(id);
    }

    public void Viudo(int id) {
        estadoCivil.estaSoltero(id);
    }

    public void EstadoSiguiente() {
         estadoCivil = estadoCivil.EstadoSiguiente();
    }

    

}
