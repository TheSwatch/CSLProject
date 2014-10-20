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
public interface IncarcerateSessionRemote {
    
    public void incarcerate(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth, Date dateOfIncarceration, String motiveNumber, String motiveLabel, String criminalCaseNumber, Date dateOfCriminalCase, String juridictionName);
    
}
