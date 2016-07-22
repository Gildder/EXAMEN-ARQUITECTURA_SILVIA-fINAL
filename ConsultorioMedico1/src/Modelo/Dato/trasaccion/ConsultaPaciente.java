/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dato.trasaccion;

import Modelo.Dato.DConsulta;
import java.util.Date;

/**
 *
 * @author root
 */
public interface ConsultaPaciente extends TransactionPaciente{
    public boolean changeDate(long transactionID,Date olddate,DConsulta consulta);
    public boolean addConsulta(long transactionID, DConsulta consulta);
    
}
