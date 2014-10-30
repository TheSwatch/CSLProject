/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Incarceration;
import NYCP_Entities.JudicialDecision;
import NYCP_Entities.Motive;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author loic
 */
@javax.ejb.Stateless(mappedName = "ejb/UseCaseSession+", name = "UseCaseSession")

public class UseCaseSession implements UseCaseSessionRemote {

    @EJB
    private PrisonerSessionRemote prisoner;
    @EJB
    private CriminalCaseSessionRemote criminalCase;
    @EJB
    private PrisonerCriminalCaseSessionRemote prisonerCriminalCase;
    @EJB
    private ConvictionSessionRemote conviction;
    @EJB
    private FinalDischargeSessionRemote finalDischarge;
    @EJB
    private ShortenedSentenceSessionRemote shortenedSentence;

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;

    
   
    @Override
    public void incarcerate(final String prisonFileNumber,final String givenName,final String surname,final Date dateOfBirth,final String placeOfBirth,final Date dateOfIncarceration,final Motive motive,final String criminalCaseNumber,final Date dateOfCriminalCase,final String juridictionName){
        
        prisoner.insertPrisoner(prisonFileNumber, givenName, surname, dateOfBirth, placeOfBirth);
        criminalCase.insertCriminalCase(criminalCaseNumber, juridictionName, dateOfCriminalCase);
        Incarceration incarceration = new Incarceration(prisonFileNumber);
        incarceration.setDateOfIncarceration(dateOfIncarceration);
        incarceration.setMotiveNumber(motive);
        incarceration.setPrisonerCriminalCase(prisonerCriminalCase.insertPrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, juridictionName));

        System.out.println("TEST :" + incarceration);

        _entity_manager.persist(incarceration);      
    }
    
    @Override
    public void takeConvictionDecision(final String decisionTypeNumber, final String prisonerFileNumber, final Date dateOfDecision, final Integer duration){
        
        conviction.insertConviction(decisionTypeNumber, prisonerFileNumber, dateOfDecision, duration);      
    }
    
    @Override
    public void takeFinalDischargeDecision(final String decisionTypeNumber, final String prisonerFileNumber, final Date dateOfDecision, final Date dateOFD){
        
        finalDischarge.insertFinalDischarge(decisionTypeNumber, prisonerFileNumber, dateOfDecision, dateOFD);
    }
    
    @Override
    public void takeShortenedDecision(final String decisionTypeNumber, final String prisonerFileNumber, final Date dateOfDecision, final Integer duration){
        
        shortenedSentence.insertShortenedSentence(decisionTypeNumber, prisonerFileNumber, dateOfDecision, duration);
    }
}
