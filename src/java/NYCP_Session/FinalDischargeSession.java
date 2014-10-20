/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.FinalDischarge;
import NYCP_Entities.FinalDischargePK;
import java.util.Date;

@javax.ejb.Stateless(mappedName = "ejb/FinalDischarge+", name = "FinalDischarge")

/**
 *
 * @author loic
 */

public class FinalDischargeSession implements FinalDischargeSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public String insertFinalDischarge(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision, final Date dateOfFinalDischarge) {
        String message;
        
        FinalDischarge finalDischages = new FinalDischarge(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        finalDischages.setDateOfFinalDischarge(dateOfFinalDischarge);
        _entity_manager.persist(finalDischages);
        
        message = "FinalDischarges created";
        
        return message;
    }
    
    @Override
    public String deleteFinalDischarges(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision) {
        String message;
        
        FinalDischarge finalDischarge = _entity_manager.find(FinalDischarge.class, new FinalDischargePK(decisionTypeNumber, prisonFileNumber, dateOfDecision));
        if(finalDischarge != null)
        {
            message = "Criminal case number : " + decisionTypeNumber + " found.";
        }
        else{
            message = "Criminal case number : " + decisionTypeNumber + " not found.";
        }
            
        _entity_manager.remove(finalDischarge);
        return message;
    }
}
