package pak.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoAbstract<T> {

    @PersistenceContext
    private EntityManager em;

    public void save(T o) {
        em.persist(o);
    }

    public T findById(Class<T> c, int id) {
        return em.find(c, id);
    }

}
