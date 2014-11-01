package NYCP_Session;

import NYCP_Entities.Prisoner;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Query;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/Prisoner+", name = "Prisoner")

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
    public void deletePrisoner(final String prisonFileNumber){
        
        Prisoner prisoner = _entity_manager.find(Prisoner.class, prisonFileNumber);
        _entity_manager.remove(prisoner);
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
