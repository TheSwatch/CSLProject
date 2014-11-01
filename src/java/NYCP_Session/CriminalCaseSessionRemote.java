package NYCP_Session;

import java.util.Date;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface CriminalCaseSessionRemote {

    public void insertCriminalCase(String criminalCaseNumber, String jurisdictionName, Date dateOfCriminalCase);

    public void deleteCriminalCase(String criminalCaseNumber, String jurisdictionName);   
}
