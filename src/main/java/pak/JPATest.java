package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.config.MyConfig;
import pak.hibernate.RegEmp;
import pak.hibernate.EntManBean;

import javax.persistence.EntityManager;

public class JPATest {

    private static Logger logger = LoggerFactory.getLogger(Test.class/*"customLogger"*/);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        EntManBean emb = ctx.getBean(EntManBean.class);
        EntityManager em = emb.getEM();

        // app managed
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
//        EntityManager em = emf.createEntityManager();

//        em.getTransaction().begin();
//        Emp e1 = new Emp();
//        e1.setName("n1");
//        em.persist(e1);
//        RegEmp remp1 = new RegEmp();
//        remp1.setName("n2");
//        remp1.setSalary(5000.15f);
//        em.persist(remp1);
//        em.getTransaction().commit();

        RegEmp regEmp = em.find(RegEmp.class, 2);
        logger.info("{} {} {}", regEmp.getId(), regEmp.getName(), regEmp.getSalary());

        //em.close();
        //emf.close();
        logger.info("DONE");

    }

}
