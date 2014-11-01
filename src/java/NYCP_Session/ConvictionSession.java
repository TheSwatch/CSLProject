package NYCP_Session;

import NYCP_Entities.Conviction;
import NYCP_Entities.ConvictionPK;
import NYCP_Entities.JudicialDecision;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/Conviction+", name = "Conviction")

public class ConvictionSession implements ConvictionSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insertConviction(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision, final Integer duration) {
        
        JudicialDecision judicialDecision = new JudicialDecision(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        Conviction conviction = new Conviction(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        conviction.setDuration(duration);
        judicialDecision.setConviction(conviction);
        _entity_manager.persist(judicialDecision);        
    }
    
    @Override
    public void deleteConviction(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision) {
        
        Conviction conviction = _entity_manager.find(Conviction.class, new ConvictionPK(decisionTypeNumber, prisonFileNumber, dateOfDecision));            
        _entity_manager.remove(conviction);
    }    
}
