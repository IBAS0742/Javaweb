package cn.sunibas.testQueryFive;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by ibas on 12/12/16.
 */
public class testFive {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(cn.sunibas.testQueryOne.mytableCp.class)
                .buildSessionFactory();
    }

    @Test
    public void testQuery() {
        Session session = sf.openSession();

        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp");
        //[{ col1 : 1 , col2 : something0}, { col1 : 2 , col2 : something1}, { col1 : 3 , col2 : something2}, { col1 : 4 , col2 : something3}, { col1 : 5 , col2 : something4}]

        q.setFirstResult(2);
        q.setMaxResults(2);
        //[{ col1 : 3 , col2 : something2}, { col1 : 4 , col2 : something3}]

        System.out.println(q.list());

        session.close();
    }

}
