package NYCP_Session;

import NYCP_Entities.JudicialDecision;
import NYCP_Entities.ShortenedSentence;
import NYCP_Entities.ShortenedSentencePK;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/ShortenedSentence+", name = "ShortenedSentence")

public class ShortenedSentenceSession implements ShortenedSentenceSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insertShortenedSentence(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision, final int duration){
        
        JudicialDecision judicialDecision = new JudicialDecision(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        ShortenedSentence shortenedSentence = new ShortenedSentence(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        shortenedSentence.setDuration(duration);
        judicialDecision.setShortenedSentence(shortenedSentence);
        _entity_manager.persist(judicialDecision);        
    }
    
    @Override
    public void deleteShortenedSentence(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision){
        
        ShortenedSentence shortenedSentence = _entity_manager.find(ShortenedSentence.class, new ShortenedSentencePK(decisionTypeNumber, prisonFileNumber, dateOfDecision));
        _entity_manager.remove(shortenedSentence);
    }
}
