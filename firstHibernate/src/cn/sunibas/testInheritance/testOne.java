package cn.sunibas.testInheritance;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by ibas on 12/9/16.
 */
public class testOne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Cat.class)
                .buildSessionFactory();
    }

    @Test
    public void testO(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        Cat c = new Cat();
        c.setId(1);
        c.setName("kitty");
        c.setIndex(12);
        session.save(c);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testT(){
        //In this test , you should set the hibernate.hbm2ddl.auto to update in hibernate.cfg.xml,
        //在这个测试中，你必须将hibernate.cfg.xml中的hibernate.hbm2ddl.auto设置为update。
        Session session = sf.openSession();

        //这里的Cat用的是全路径，因为这里不能直接使用Cat，如果在某些可以直接使用Cat的地方，
        //如果使用Animal，必须使用全路径。
        Query q = session.createQuery("from cn.sunibas.testInheritance.Animal");

        List<Cat> cats = q.list();
        //List<Animal> cats = q.list();
        System.out.print(cats);

        session.close();
    }
}
