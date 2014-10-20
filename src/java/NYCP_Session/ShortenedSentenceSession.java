/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.ShortenedSentence;
import NYCP_Entities.ShortenedSentencePK;
import java.util.Date;

@javax.ejb.Stateless(mappedName = "ejb/ShortenedSentence+", name = "ShortenedSentence")
/**
 *
 * @author loic
 */

public class ShortenedSentenceSession implements ShortenedSentenceSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public String insertShortenedSentence(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision, final int duration){
        
        String message;
        
        ShortenedSentence shortenedSentence = new ShortenedSentence(decisionTypeNumber, prisonFileNumber, dateOfDecision);
        shortenedSentence.setDuration(duration);
        _entity_manager.persist(shortenedSentence);
        
        message = "shortenedSentence created";
        
        return message;
        
    }
    
    @Override
    public String deleteShortenedSentence(final String decisionTypeNumber, final String prisonFileNumber, final Date dateOfDecision){
        String message;
        
        ShortenedSentence shortenedSentence = _entity_manager.find(ShortenedSentence.class, new ShortenedSentencePK(decisionTypeNumber, prisonFileNumber, dateOfDecision));
        if(shortenedSentence != null){
            message = "shortenedSentence number : " + decisionTypeNumber + " found.";
        }else{
            message = "shortenedSentence number : " + decisionTypeNumber + " not found.";
        }
        
        _entity_manager.remove(shortenedSentence);
        
        return message;
    }
}