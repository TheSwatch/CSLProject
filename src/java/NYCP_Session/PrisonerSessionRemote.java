package NYCP_Session;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface PrisonerSessionRemote {

    public void insertPrisoner(String prisonFileNumber, String givenName, String surname, Date dateOfBirth, String placeOfBirth);

    public void deletePrisoner(String prisonFileNumber);

    public Collection getAllPrisoner();

    public Collection getUnderRemand();    
}
