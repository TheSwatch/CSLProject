/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Incarceration;
import java.util.Date;


/**
 *
 * @author loic
 */
@javax.ejb.Stateless(mappedName = "ejb/IncarcerateSession+", name = "IncarcerateSession")
public class IncarcerateSession implements IncarcerateSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void incarcerate(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth, Date dateOfIncarceration, String motiveNumber, String motiveLabel, String criminalCaseNumber, Date dateOfCriminalCase, String juridictionName){
        try{
            javax.naming.Context jndi_context = new javax.naming.InitialContext();

            PrisonerSessionRemote prisoner = (NYCP_Session.PrisonerSessionRemote) jndi_context.lookup("ejb/Prisoner+");
            MotiveSessionRemote motive = (NYCP_Session.MotiveSessionRemote) jndi_context.lookup("ejb/Motive+");
            CriminalCaseSessionRemote criminalCase = (NYCP_Session.CriminalCaseSessionRemote) jndi_context.lookup("ejb/CriminalCase+");
            PrisonerCriminalCaseSessionRemote prisonerCriminalCase = (NYCP_Session.PrisonerCriminalCaseSessionRemote) jndi_context.lookup("ejb/PrisonerCriminalCase+");

            prisoner.insertPrisoner(prisonFileNumber, givenName, surname, dateOfBirth, placeOfBirth);
            criminalCase.insertCriminalCase(criminalCaseNumber, juridictionName, dateOfCriminalCase);

            Incarceration incarceration = new Incarceration(prisonFileNumber);
            incarceration.setDateOfIncarceration(dateOfIncarceration);
            incarceration.setMotiveNumber(motive.insertMotive(motiveNumber, motiveLabel));
            incarceration.setPrisonerCriminalCase(prisonerCriminalCase.insertPrisonerCriminalCase(prisonFileNumber, criminalCaseNumber, juridictionName));

            System.out.println("TEST :" + incarceration);

            _entity_manager.persist(incarceration);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
