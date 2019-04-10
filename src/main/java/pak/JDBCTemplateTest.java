package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.config.ConfigJdbc;
import pak.jdbctemplate.Employee;
import pak.jdbctemplate.EmployeeDao;

public class JDBCTemplateTest {

    private static Logger logger = LoggerFactory.getLogger(AOPTest.class/*"customLogger"*/);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigJdbc.class);
        EmployeeDao ed = ctx.getBean(EmployeeDao.class);

        //ed.saveEmployee(new Employee(3, "name1", 5000.15f));

        for (Employee e : ed.queryEmployee()) {
            logger.info("{} {} {}", e.getId(), e.getName(), e.getSalary());
        }

//        EmployeeDao ed2 = ctx.getBean(EmployeeDao.class);
//        if (ed == ed2) {
//            logger.info("reference same");
//        } else {
//            logger.info("not same");
//        }
    }

}
