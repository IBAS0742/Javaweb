package cn.sunibas.testComponent;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created by ibas on 12/9/16.
 */
public class testOne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Car.class)
                .buildSessionFactory();
    }

    @Test
    public void testO(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        Car c = new Car();
        Wheel w = new Wheel();
        c.setName("a");
        c.setWheel(w);
        w.setNumber(1);

        session.save(c);

        session.getTransaction().commit();

        /**
         * Result
         mysql> show tables;
         +--------------------+
         | Tables_in_forstudy |
         +--------------------+
         | t_car              |
         +--------------------+
         1 row in set (0.00 sec)

         mysql> select * from t_car;
         +----+------+--------+
         | id | name | number |
         +----+------+--------+
         |  1 | a    |      1 |
         +----+------+--------+
         1 row in set (0.00 sec)

         * */
    }
}
