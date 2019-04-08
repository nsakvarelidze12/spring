package pak.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Transactional(propagation = Propagation.REQUIRED)
public class EmpDao {

    @PersistenceContext
    private EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveRegEmp(RegEmp re) {
        em.persist(re);
    }

    public void findRegEmpById(Long id) {
        RegEmp regEmp = em.find(RegEmp.class, id);
        logger.info("{} {} {}", regEmp.getId(), regEmp.getName(), regEmp.getSalary());
    }

}
