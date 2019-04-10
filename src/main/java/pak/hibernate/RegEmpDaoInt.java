package pak.hibernate;

public interface RegEmpDaoInt {

    public void save(RegEmp o);

    public RegEmp findById(Class<RegEmp> c, int id);

}
