package NYCP_Session;

import NYCP_Entities.FinalDischarge;
import NYCP_Entities.FinalDischargePK;
import NYCP_Entities.JudicialDecision;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/FinalDischarge+", name = "FinalDischarge")

public class FinalDischargeSession implements FinalDischargeSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;

    @Override
    public void insertFinalDischarge(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision, final Date dateOfFinalDischarge) {
        
        JudicialDecision judicialDecision = new JudicialDecision(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        FinalDischarge finalDischages = new FinalDischarge(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        finalDischages.setDateOfFinalDischarge(dateOfFinalDischarge);
        judicialDecision.setFinalDischarge(finalDischages);
        _entity_manager.persist(judicialDecision);
    }
    
    @Override
    public void deleteFinalDischarges(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision) {
        
        FinalDischarge finalDischarge = _entity_manager.find(FinalDischarge.class, new FinalDischargePK(decisionTypeNumber, prisonFileNumber, dateOfDecision));
        _entity_manager.remove(finalDischarge);
    }
}
