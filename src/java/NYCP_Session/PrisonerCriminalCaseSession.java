package NYCP_Session;

import NYCP_Entities.PrisonerCriminalCase;
import NYCP_Entities.PrisonerCriminalCasePK;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/PrisonerCriminalCase+", name = "PrisonerCriminalCase")

public class PrisonerCriminalCaseSession implements PrisonerCriminalCaseSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public PrisonerCriminalCase insertPrisonerCriminalCase(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName) {
        
        PrisonerCriminalCase prisonCriminalCase = new PrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, jurisdictionName);
        _entity_manager.persist(prisonCriminalCase);
        return prisonCriminalCase;
    }
    
    @Override
    public void deletePrisonerCriminalCase(final String prisonFileNumber, final String criminalCaseNumber, final String jurisdictionName) {
        
        PrisonerCriminalCase prisonCriminalCase = _entity_manager.find(PrisonerCriminalCase.class, new PrisonerCriminalCasePK(prisonFileNumber, criminalCaseNumber, jurisdictionName));            
        _entity_manager.remove(prisonCriminalCase);
    }   
}
