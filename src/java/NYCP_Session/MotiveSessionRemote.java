/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Motive;
import java.util.Collection;

/**
 *
 * @author loic
 */
@javax.ejb.Remote
public interface MotiveSessionRemote {

    public Motive insertMotive(String motiveNumber, String motiveLabel);
    
    public String deleteMotive(String motiveNumber);

    public Collection getAllMotive();
    
}
