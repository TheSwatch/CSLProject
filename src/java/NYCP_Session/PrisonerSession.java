/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;

import NYCP_Entities.Prisoner;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Query;

@javax.ejb.Stateless(mappedName = "ejb/Prisoner+", name = "Prisoner")
/**
 *
 * @author loic
 */

public class PrisonerSession implements PrisonerSessionRemote {
    
    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
    public void insertPrisoner(final String prisonFileNumber, final String givenName, final String surname, final Date dateOfBirth, final String placeOfBirth){
        
        Prisoner prisoner = new Prisoner(prisonFileNumber);
        prisoner.setGivenName(givenName);
        prisoner.setSurname(surname);
        prisoner.setDateOfBirth(dateOfBirth);
        prisoner.setPlaceOfBirth(placeOfBirth);
        _entity_manager.persist(prisoner);
        
    }
    
    @Override
    public String deletePrisoner(final String prisonFileNumber){
        String message;
        
        Prisoner prisoner = _entity_manager.find(Prisoner.class, prisonFileNumber);
        if(prisoner != null){
            message = "Prisoner number : " + prisonFileNumber + " found.";
        }else{
            message = "Prisoner number : " + prisonFileNumber + " not found.";
        }
        
        _entity_manager.remove(prisoner);
        
        return message;
    }
    
    @Override
    public Collection getAllPrisoner()
    {
        Collection prisoners;
        Query q = _entity_manager.createNamedQuery("Prisoner.findAll");
        prisoners = q.getResultList();
        return prisoners;
    }
    
    @Override
    public Collection getUnderRemand(){
        
        Collection prisoners;
        Query q = _entity_manager.createNamedQuery("Prisoner.findUnderRemand");
        prisoners = q.getResultList();
        return prisoners;
    }
}
