/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import java.util.Date;

/**
 *
 * @author loic
 */
@javax.ejb.Remote
public interface ShortenedSentenceSessionRemote {

    public String insertShortenedSentence(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision, int duration);

    public String deleteShortenedSentence(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision);
    
}
