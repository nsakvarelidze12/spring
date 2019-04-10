package pak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pak.config.MyConfig;
import pak.config.MyConfig2;
import pak.hibernate.RegEmp;
import pak.hibernate.RegEmpService;

public class JPATest {

    private static Logger logger = LoggerFactory.getLogger(Test.class/*"customLogger"*/);

    public static void main(String[] args) {


        // app managed
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Emp e1 = new Emp();
//        e1.setName("n3");
//        em.persist(e1);
//        RegEmp remp1 = new RegEmp();
//        remp1.setName("n2");
//        remp1.setSalary(5000.15f);
//        em.persist(remp1);
//        em.getTransaction().commit();
//
//        RegEmp regEmp = em.find(RegEmp.class, 2);
//        logger.info("{} {} {}", regEmp.getId(), regEmp.getName(), regEmp.getSalary());
//
//        em.close();
//        emf.close();

        // container managed
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig2.class);
        for (String name : ctx.getBeanDefinitionNames()) {
            logger.info(name);
        }
        RegEmpService regEmpService = ctx.getBean(RegEmpService.class);
        RegEmp re = new RegEmp();
        re.setName("n3");
        re.setSalary(5000.15F);
        regEmpService.save(re);
        regEmpService.findById(RegEmp.class, 302);

        logger.info("DONE");

    }

}
