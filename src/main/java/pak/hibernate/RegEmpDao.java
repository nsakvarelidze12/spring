package pak.hibernate;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RegEmpDao extends DaoAbstract<RegEmp> implements RegEmpDaoInt {

}
