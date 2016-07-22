/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.trasaccion;

import Modelo.Dato.DConsulta;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class ApuntarConsulta implements ConsultaPaciente{
    
    private HashMap consultas;
    public long currentTransaction;
    private DConsulta oldConsulta;
    private Date newDate;

    public ApuntarConsulta() {
        this.consultas=new HashMap();
        this.newDate=null;
        this.oldConsulta=null;
    }
    
    private void remove(String id){
        if(this.consultas.containsKey(id) ){
            this.consultas.remove(id);
        }
    }
    private void add(long id, DConsulta e){
        this.consultas.put(id, e);
        if(e.isNuevo)
            e.Registrar();
        else
            e.Modificar();
    }

    @Override
    public boolean changeDate(long transactionID, Date newdate, DConsulta consulta) {
        if(this.currentTransaction==transactionID &&
            this.consultas.containsKey(consulta.getFecha())){
            
            try {
                this.oldConsulta=(DConsulta) ((DConsulta) this.consultas.get(consulta.getId())).clone();
                this.newDate=newdate;
                return true;
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(ApuntarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;
    }
  
    @Override
    public boolean join(long transactionID) {
        if(this.currentTransaction!=0){
            return false;
        }
        this.currentTransaction=transactionID;
        return true;
    }

    @Override
    public boolean commit(long transactionID) {
        if(this.currentTransaction!=transactionID){
            if(oldConsulta!=null){
                add(transactionID, oldConsulta);
            }
        }
        return false;
    }

    @Override
    public boolean cancel(long transactionID) {
        this.currentTransaction=0;
        if(this.consultas.containsKey(transactionID)){
            this.consultas.remove(transactionID);
            return true;
        }
        return false;
    }

    @Override
    public boolean addConsulta(long transactionID, DConsulta consulta) {
        if(!this.consultas.containsValue(consulta)){
            this.consultas.put(transactionID, consulta);
            return true;
        }
        return false;
            
    }

    @Override
    public String toString() {
        return "Apuntado consulta{" + "consulta=" + consultas + '}';
    }
    
    
}
