/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo.Negocio;

/**
 *
 * @author gildder
 */
public abstract class Registrando {
    public abstract boolean Validar(int id, String nombre,String fechanac,int telefono,String tiposangre,int peso );
    public abstract void Registrar(int id, String nombre,String fechanac,int telefono,String tiposangre,int peso,String estado);
    public abstract void Modificar(int id, String nombre,String fechanac,int telefono,String tiposangre,int peso, String estado );
    
    public void Nuevo(int id, String nombre,String fechanac,int telefono,String tiposangre,int peso, String estado ){
        Validar(id, nombre, fechanac, telefono, tiposangre, peso);
        Registrar(id, nombre,fechanac,telefono,tiposangre,peso,estado);
    }
    
    public void Actualizar(int id, String nombre,String fechanac,int telefono,String tiposangre,int peso, String estado ){
        Validar(id, nombre, fechanac, telefono, tiposangre, peso);
        Modificar(id, nombre,fechanac,telefono,tiposangre,peso,estado);
    }
}
