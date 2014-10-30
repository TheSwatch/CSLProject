/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import java.util.Date;


/**
 *
 * @author loic
 */
@javax.ejb.Remote
public interface FinalDischargeSessionRemote {

    public void insertFinalDischarge(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision, Date dateOfFinalDischarge);

    public String deleteFinalDischarges(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision);
    
}
