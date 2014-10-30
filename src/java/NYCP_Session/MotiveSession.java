/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NYCP_Session;
import NYCP_Entities.Motive;
import java.util.Collection;
import javax.persistence.Query;


@javax.ejb.Stateless(mappedName = "ejb/Motive+", name = "Motive")
/**
 *
 * @author loic
 */

public class MotiveSession implements MotiveSessionRemote {

    @javax.persistence.PersistenceContext(name = "NYCPPU")
    private javax.persistence.EntityManager _entity_manager;
    
    @Override
     public Motive insertMotive(final String motiveNumber, final String motiveLabel) {
        String message;
        
        Motive motive = new Motive(motiveNumber);
        motive.setMotiveLabel(motiveLabel);
        _entity_manager.persist(motive);
        
        message = "Motive created";
        
        return motive;
    }
    
    @Override
    public String deleteMotive(final String motiveNumber) {
        String message;
        
        Motive motive = _entity_manager.find(Motive.class, motiveNumber);
        if(motive != null)
        {
            message = "Motive number : " + motiveNumber + " found.";
        }
        else{
            message = "Motive number : " + motiveNumber + " not found.";
        }
            
        _entity_manager.remove(motive);
        return message;
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
    public Motive find(final String motiveNumber){
        Motive motive = _entity_manager.find(Motive.class, motiveNumber);
        return motive;
    }
    
}
