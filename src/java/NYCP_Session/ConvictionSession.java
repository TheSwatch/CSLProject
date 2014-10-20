/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Conviction;
import NYCP_Entities.ConvictionPK;
import java.util.Date;

@javax.ejb.Stateless(mappedName = "ejb/Conviction+", name = "Conviction")
/**
 *
 * @author loic
 */

public class ConvictionSession implements ConvictionSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insertConviction(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision) {
        Conviction conviction = new Conviction(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        conviction.setDuration(10);
        _entity_manager.persist(conviction);
    }
    
    @Override
    public String deleteConviction(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision) {
        String message;
        
        Conviction conviction = _entity_manager.find(Conviction.class, new ConvictionPK(decisionTypeNumber, prisonFileNumber, dateOfDecision));
        if(conviction != null)
        {
            message = "Conviction number : " + decisionTypeNumber + " found.";
        }
        else{
            message = "Conviction number : " + decisionTypeNumber + " not found.";
        }
            
        _entity_manager.remove(conviction);
        return message;
    }
    
    
}
