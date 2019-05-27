package br.com.cresol.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;

public abstract class AbstractDAO {

    @PersistenceContext(unitName = "CresolApp", synchronization = SynchronizationType.SYNCHRONIZED)
    protected EntityManager entityManager; 
    
    
    public EntityManager getEntityManager() {
    	return entityManager;
    }
    
}
