/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.PrisonerCriminalCase;


/**
 *
 * @author loic
 */

@javax.ejb.Remote
public interface PrisonerCriminalCaseSessionRemote {

    public PrisonerCriminalCase insertPrisonerCriminalCase(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName);

    public String deletePrisonerCriminalCase(String prisonFileNumber, String criminalCaseNumber, String jurisdictionName);
    
}
