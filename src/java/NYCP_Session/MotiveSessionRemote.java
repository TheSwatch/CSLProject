package NYCP_Session;

import NYCP_Entities.Motive;
import java.util.Collection;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Remote
public interface MotiveSessionRemote {

    public Motive insertMotive(String motiveNumber, String motiveLabel);
    
    public void deleteMotive(String motiveNumber);

    public Collection getAllMotive();

    public Motive findMotive(String motiveNumber);    
}
