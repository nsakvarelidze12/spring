package pak.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional(propagation = Propagation.REQUIRED)
public class RegEmpService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    //@Qualifier("regEmpDao")
    private RegEmpDaoInt regEmpDao;

    public void save(RegEmp re) {
        regEmpDao.save(re);
    }

    public void findById(Class<RegEmp> c, int id) {
        RegEmp re = regEmpDao.findById(c, id);
        logger.info("{} {} {}", re.getId(), re.getName(), re.getSalary());
    }

}
