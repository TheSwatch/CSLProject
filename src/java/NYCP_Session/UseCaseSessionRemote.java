package NYCP_Session;

import NYCP_Entities.Motive;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface UseCaseSessionRemote {

    public void incarcerate(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth, Date dateOfIncarceration, Motive motive, String criminalCaseNumber, Date dateOfCriminalCase, String juridictionName);

    public void takeConvictionDecision(String decisionTypeNumber, String prisoner, Date dateOfDecision, Integer duration);

    public void takeFinalDischargeDecision(String decisionTypeNumber, String prisonerFileNumber, Date dateOfDecision, Date dateOFD);

    public void takeShortenedDecision(String decisionTypeNumber, String prisonerFileNumber, Date dateOfDecision, Integer duration);   
}
