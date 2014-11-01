package NYCP_Session;

import NYCP_Entities.JudicialDecision;
import NYCP_Entities.JudicialDecisionPK;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/JudicialDecision+", name = "JudicialDecision")

public class JudicialDecisionSession implements JudicialDecisionSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insertJudicialDecision(final String decisionTypeNumber,final String prisonFileNumber,final Date dateOfDecision){
        
        JudicialDecision judicialDecision = new JudicialDecision(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        _entity_manager.persist(judicialDecision);
    }
    
    @Override
    public void deleteJudicialDecision(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision){
        
        JudicialDecision judicialDecision = _entity_manager.find(JudicialDecision.class, new JudicialDecisionPK(decisionTypeNumber,prisonFileNumber,dateOfDecision)); 
        _entity_manager.remove(judicialDecision);
    }
}
