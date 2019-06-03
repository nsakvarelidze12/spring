package pak.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoAbstract<T> {

    // Container Managed Persistence Context:
    // container is responsible for Persistence Context injection and disposal
    // Container Managed Persistence Context may only be used with JTA
    // in JTA, CMT or BMT could be used
    //
    // application managed Persistence Context:
    // application is responsible for Persistence Context creation and disposal
    // application managed Persistence Context may be used with both JTA and Resource Local
    // in Resource Local, the application must manage the transaction completely by itself

    // example of Container Managed Persistence Context
    @PersistenceContext
    private EntityManager em;

    public void save(T o) {
        em.persist(o);
    }

    public T findById(Class<T> c, int id) {
        return em.find(c, id);
    }

}
