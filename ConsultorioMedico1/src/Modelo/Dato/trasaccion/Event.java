/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.trasaccion;

import java.util.Date;

/**
 *
 * @author root
 */
public class Event {
    private Date fecha;
    private String nombre;
    private String lugar;

    public Event() {
    }
    

    public Event(Date fecha, String nombre, String lugar) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.lugar = lugar;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Event{" + "fecha=" + fecha + ", nombre=" + nombre + ", lugar=" + lugar + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        Event e=new Event(fecha, nombre, lugar);
        return e;
    }
    
    
}
