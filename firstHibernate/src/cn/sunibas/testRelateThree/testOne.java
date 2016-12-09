package cn.sunibas.testRelateThree;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created by ibas on 12/2/16.
 */
public class testOne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(RTone.class)
                .addClass(RTtwo.class)
                .buildSessionFactory();
    }

    @Test
    public void testOne_(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        RTone oo = new RTone();
        RTone ot = new RTone();
        RTone of = new RTone();
        RTtwo to = new RTtwo();
        RTtwo tt = new RTtwo();

        oo.setLabel("one one");
        ot.setLabel("one two");
        of.setLabel("one four");

        to.setLabel("two one");
        tt.setLabel("tow two");

//        oo.getSet().add(to);
//        oo.getSet().add(tt);
//        ot.getSet().add(to);
//        of.getSet().add(tt);

        to.getSet().add(oo);
        to.getSet().add(ot);
        tt.getSet().add(oo);
        tt.getSet().add(of);

        session.save(oo);
        session.save(ot);
        session.save(of);
        session.save(to);
        session.save(tt);

        session.getTransaction().commit();
        session.close();
    }
}
