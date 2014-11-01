package NYCP_Session;

import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface ConvictionSessionRemote {

    public void insertConviction(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision, Integer duration);

    public void deleteConviction(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision); 
}
