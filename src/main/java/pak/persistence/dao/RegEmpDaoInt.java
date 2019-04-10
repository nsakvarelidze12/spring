package pak.persistence.dao;

import pak.persistence.model.RegEmp;

public interface RegEmpDaoInt {

    public void save(RegEmp o);

    public RegEmp findById(Class<RegEmp> c, int id);

}
