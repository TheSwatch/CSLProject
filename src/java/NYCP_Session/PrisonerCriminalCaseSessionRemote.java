package NYCP_Session;

import NYCP_Entities.PrisonerCriminalCase;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface PrisonerCriminalCaseSessionRemote {

    public PrisonerCriminalCase insertPrisonerCriminalCase(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName);

    public void deletePrisonerCriminalCase(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName);   
}
