/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.PrisonerCriminalCase;
import NYCP_Entities.PrisonerCriminalCasePK;

@javax.ejb.Stateless(mappedName = "ejb/PrisonerCriminalCase+", name = "PrisonerCriminalCase")
/**
 *
 * @author loic
 */


public class PrisonerCriminalCaseSession implements PrisonerCriminalCaseSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public PrisonerCriminalCase insertPrisonerCriminalCase(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName) {
        String message;
        
        PrisonerCriminalCase prisonCriminalCase = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);

        _entity_manager.persist(prisonCriminalCase);
        
        message = "Prisoner Criminal Case created";
        
        return prisonCriminalCase;
    }
    
    @Override
    public String deletePrisonerCriminalCase(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName) {
        String message;
        
        PrisonerCriminalCase prisonCriminalCase = _entity_manager.find(PrisonerCriminalCase.class, new PrisonerCriminalCasePK(prisonFileNumber, criminalCaseNumber, jurisdictionName));
        if(prisonCriminalCase != null)
        {
            message = "PrisonerCriminalCase number : " + prisonFileNumber + " found.";
        }
        else{
            message = "PrisonerCriminalCase number : " + prisonFileNumber + " not found.";
        }
            
        _entity_manager.remove(prisonCriminalCase);
        return message;
    }
    
}
