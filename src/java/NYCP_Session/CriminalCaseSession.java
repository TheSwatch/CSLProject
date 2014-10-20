/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.CriminalCase;
import NYCP_Entities.CriminalCasePK;
import java.util.Date;

@javax.ejb.Stateless(mappedName = "ejb/CriminalCase+", name = "CriminalCase")

/**
 *
 * @author loic
 */

public class CriminalCaseSession implements CriminalCaseSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public String insertCriminalCase(final String criminalCaseNumber, final String jurisdictionName, final Date dateOfCriminalCase ){
        String message;
        
        CriminalCase criminalCase = new CriminalCase(criminalCaseNumber, jurisdictionName);
        criminalCase.setDateOfCriminalCase(dateOfCriminalCase);
        _entity_manager.persist(criminalCase);
        
        message = "Criminal Case created.";
        
        return message;
    }
    
    @Override
    public String deleteCriminalCase(final String criminalCaseNumber, final String jurisdictionName) {
        String message;
        
        CriminalCase criminalCase = _entity_manager.find(CriminalCase.class, new CriminalCasePK(criminalCaseNumber, jurisdictionName));
        if(criminalCase != null)
        {
            message = "Criminal case number : " + criminalCaseNumber + " found.";
        }
        else{
            message = "Criminal case number : " + criminalCaseNumber + " not found.";
        }
            
        _entity_manager.remove(criminalCase);
        return message;
    }

}
