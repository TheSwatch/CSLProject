/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Motive;
import java.util.Date;

/**
 *
 * @author loic
 */
@javax.ejb.Remote
public interface UseCaseSessionRemote {

    public void incarcerate(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth, Date dateOfIncarceration, Motive motive, String criminalCaseNumber, Date dateOfCriminalCase, String juridictionName);

    public void takeConvictionDecision(String decisionTypeNumber, String prisoner, Date dateOfDecision, Integer duration);

    public void takeFinalDischargeDecision(String decisionTypeNumber, String prisonerFileNumber, Date dateOfDecision, Date dateOFD);

    public void takeShortenedDecision(String decisionTypeNumber, String prisonerFileNumber, Date dateOfDecision, Integer duration);
    
}
