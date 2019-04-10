package pak.persistence.dao;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pak.persistence.model.RegEmp;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RegEmpDao extends DaoAbstract<RegEmp> implements RegEmpDaoInt {

}
