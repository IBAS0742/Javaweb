package cn.sunibas.testQueryThree;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by ibas on 12/12/16.
 */
public class testHThree {

    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(cn.sunibas.testQueryOne.mytableCp.class)
                .buildSessionFactory();
    }

    @Test
    public void testXmlQuery(){
        Session session = sf.openSession();

        //getAll(session);
        //getWhere(session,"getWhere");
        //getWhere(session,"getWhere1");

        session.close();
    }

    public void getAll(Session session) {
        Query query = session.getNamedQuery("getAll");
        System.out.println(query.list());
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4}
         * ]
         * */
    }

    public void getWhere(Session session,String sql) {
        Query query = session.getNamedQuery(sql);
        query.setInteger(0,2);

        System.out.println(query.list());
        //[{ col1 : 1 , col2 : something0}]
    }
}
