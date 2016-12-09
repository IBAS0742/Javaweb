package cn.sunibas.testRelateTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by ibas on 12/2/16.
 */
public class testRTwo {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(One.class)
                .addClass(Two.class)
                .buildSessionFactory();
    }

    @Test
    public void testOne(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        One oo = new One();
        One ot = new One();
        Two two = new Two();

        two.getOnes().add(oo);
        two.getOnes().add(ot);

        session.save(oo);
        session.save(ot);
        session.save(two);

        session.getTransaction().commit();
        session.close();
    }
}
