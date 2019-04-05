package pak.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EntManBean {

    // container managed
    @PersistenceContext(unitName = "myUnit")
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public EntityManager getEM() {
        return em;
    }

}
