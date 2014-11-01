package NYCP_Session;

import NYCP_Entities.Motive;
import java.util.Collection;
import javax.persistence.Query;

/**
 *
 * @author Loïc Irles
 */

@javax.ejb.Stateless(mappedName = "ejb/Motive+", name = "Motive")

public class MotiveSession implements MotiveSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
     public Motive insertMotive(final String motiveNumber, final String motiveLabel) {
        
        Motive motive = new Motive(motiveNumber);
        motive.setMotiveLabel(motiveLabel);
        _entity_manager.persist(motive);        
        return motive;
    }
    
    @Override
    public void deleteMotive(final String motiveNumber) {
        
        Motive motive = _entity_manager.find(Motive.class, motiveNumber);
        _entity_manager.remove(motive);
    }
    
    @Override
    public Collection getAllMotive()
    {
        Collection motives;
        Query q = _entity_manager.createNamedQuery("Motive.findAll");
        motives = q.getResultList();
        return motives;
    }
    
    @Override
    public Motive findMotive(final String motiveNumber){
        
        Motive motive = _entity_manager.find(Motive.class, motiveNumber);
        return motive;
    }   
}
