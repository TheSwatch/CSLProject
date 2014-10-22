/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Incarceration;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author loic
 */
@javax.ejb.Stateless(mappedName = "ejb/UseCaseSession+", name = "UseCaseSession")

public class UseCaseSession implements UseCaseSessionRemote {

    /*@EJB
    private PrisonerSession prisoner;
    private MotiveSession motive;
    private CriminalCaseSession criminalCase;
    private PrisonerCriminalCaseSession prisonerCriminalCase;

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;*/

    
    @Override
    public void incarcerate(final String prisonFileNumber,final String givenName,final String surname,final Date dateOfBirth,final String placeOfBirth,final Date dateOfIncarceration,final String motiveNumber,final String motiveLabel,final String criminalCaseNumber,final Date dateOfCriminalCase,final String juridictionName){
            /*prisoner.insertPrisoner(prisonFileNumber, givenName, surname, dateOfBirth, placeOfBirth);
            criminalCase.insertCriminalCase(criminalCaseNumber, juridictionName, dateOfCriminalCase);
            Incarceration incarceration = new Incarceration(prisonFileNumber);
            incarceration.setDateOfIncarceration(dateOfIncarceration);
            incarceration.setMotiveNumber(motive.insertMotive(motiveNumber, motiveLabel));
            incarceration.setPrisonerCriminalCase(prisonerCriminalCase.insertPrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, juridictionName));

            System.out.println("TEST :" + incarceration);

            _entity_manager.persist(incarceration);*/
    }
}
