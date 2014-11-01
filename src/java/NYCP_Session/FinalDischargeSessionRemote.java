package NYCP_Session;

import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface FinalDischargeSessionRemote {

    public void insertFinalDischarge(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision, Date dateOfFinalDischarge);

    public void deleteFinalDischarges(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision);   
}
