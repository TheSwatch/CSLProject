/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.JudicialDecision;
import NYCP_Entities.JudicialDecisionPK;
import java.util.Date;

@javax.ejb.Stateless(mappedName = "ejb/JudicialDecision+", name = "JudicialDecision")
/**
 *
 * @author loic
 */

public class JudicialDecisionSession implements JudicialDecisionSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insertJudicialDecision(final String decisionTypeNumber,final String prisonFileNumber,final Date dateOfDecision){
        JudicialDecision judicialDecision = new JudicialDecision(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        _entity_manager.persist(judicialDecision);
    }
    
    @Override
    public String deleteJudicialDecision(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision){
        
        String message;
        
        JudicialDecision judicialDecision = _entity_manager.find(JudicialDecision.class, new JudicialDecisionPK(decisionTypeNumber,prisonFileNumber,dateOfDecision));
        if(judicialDecision != null){
            message = "Judicial Decision number : " + decisionTypeNumber + " found.";
        }else{
            message = "Judicial Decision number : " + decisionTypeNumber + " not found.";
        }
        
        _entity_manager.remove(judicialDecision);
        
        return message;
    }
}
