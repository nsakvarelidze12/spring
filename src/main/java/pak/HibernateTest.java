package pak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pak.hibernate.RegEmp;

public class HibernateTest {

    private static Logger logger = LoggerFactory.getLogger(Test.class/*"customLogger"*/);

    public static void main(String[] args) {

        // !!! USE HIBERNATE JPA IMPLEMENTATION, NOT THIS !!!

/*        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml.bak").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

//        Emp e1 = new Emp();
//        e1.setName("n1");
//        session.save(e1);

//        RegEmp remp1 = new RegEmp();
//        remp1.setName("n2");
//        remp1.setSalary(5000.15f);
//        session.save(remp1);

//        t.commit();

        RegEmp regEmp = session.find(RegEmp.class, 2);
        logger.info("{} {} {}", regEmp.getId(), regEmp.getName(), regEmp.getSalary());

        session.close();
        factory.close();
        logger.info("DONE");*/

    }

}
