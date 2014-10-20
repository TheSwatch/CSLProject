/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author loic
 */
@javax.ejb.Remote
public interface PrisonerSessionRemote {

    public void insertPrisoner(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth);

    public String deletePrisoner(String prisonFileNumber);

    public Collection getAllPrisoner();
    
}
