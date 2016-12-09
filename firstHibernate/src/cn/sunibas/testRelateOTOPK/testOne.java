package cn.sunibas.testRelateOTOPK;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created by ibas on 12/4/16.
 */
public class testOne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(One.class)
                .addClass(Two.class)
                .buildSessionFactory();
    }

    @Test
    public void testOne_(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        One o = new One();
        Two t = new Two();
        o.setName("one");
        t.setName("two");
        o.setTwo(t);
        t.setOne(o);

        session.save(t);

        session.getTransaction().commit();
        session.close();
    }
}
