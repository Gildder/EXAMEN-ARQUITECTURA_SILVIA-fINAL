/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.trasaccion;

/**
 *
 * @author root
 */
public interface TransactionPaciente {
    public boolean join(long transactionID);
    public boolean commit(long transactionID);
    public boolean cancel(long transactionID);
}
