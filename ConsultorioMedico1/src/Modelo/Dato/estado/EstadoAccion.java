/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.estado;

/**
 *
 * @author silvita
 */
public abstract class EstadoAccion {
    public Accion estados;
    
    public EstadoAccion(Accion estados) {
        this.estados = estados;
    }

    public abstract void estaSoltero(int id);
    public abstract void estaCasado(int id);
    public abstract void estaViudo(int id);
    public abstract EstadoAccion EstadoSiguiente();
}
