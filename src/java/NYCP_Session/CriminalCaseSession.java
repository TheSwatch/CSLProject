package NYCP_Session;

import NYCP_Entities.CriminalCase;
import NYCP_Entities.CriminalCasePK;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/CriminalCase+", name = "CriminalCase")

public class CriminalCaseSession implements CriminalCaseSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insertCriminalCase(final String criminalCaseNumber, final String jurisdictionName, final Date dateOfCriminalCase ){

        CriminalCase criminalCase = new CriminalCase(criminalCaseNumber, jurisdictionName);
        criminalCase.setDateOfCriminalCase(dateOfCriminalCase);
        _entity_manager.persist(criminalCase);
    }
    
    @Override
    public void deleteCriminalCase(final String criminalCaseNumber, final String jurisdictionName) {
        
        CriminalCase criminalCase = _entity_manager.find(CriminalCase.class, new CriminalCasePK(criminalCaseNumber, jurisdictionName));
        _entity_manager.remove(criminalCase);
    }
}
