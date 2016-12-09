package cn.sunibas.testRelate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by ibas on 12/2/16.
 * 测试一对多的关系
 */
public class testROne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Employee.class)
                .addClass(Dept.class)
                .buildSessionFactory();
    }

    @Test
    public void testOne(){
        Session session = sf.openSession();
        session.beginTransaction();

        Dept dept = new Dept();
        dept.setDeptName("sunibas");

        Employee empo = new Employee();
        Employee empt = new Employee();
        empo.setEmpName("ibas");
        empt.setEmpName("bing");

        dept.getEmps().add(empo);
        dept.getEmps().add(empt);

        session.save(empo);
        session.save(empt);
        session.save(dept);

        session.getTransaction().commit();
        session.close();
    }
}
