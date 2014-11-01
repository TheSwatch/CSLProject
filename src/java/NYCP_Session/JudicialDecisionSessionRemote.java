package NYCP_Session;

import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface JudicialDecisionSessionRemote {

    public void insertJudicialDecision(final String decisionTypeNumber,final String prisonFileNumber,final Date dateOfDecision);

    public void deleteJudicialDecision(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision);
    
}
