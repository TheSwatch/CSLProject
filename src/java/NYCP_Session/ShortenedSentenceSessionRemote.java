package NYCP_Session;

import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface ShortenedSentenceSessionRemote {

    public void insertShortenedSentence(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision, int duration);

    public void deleteShortenedSentence(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision);    
}
