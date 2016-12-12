package cn.sunibas.testQueryFour;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by ibas on 12/12/16.
 */
public class testFour {
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

        //criteriaQuery(session);
        queryQuery(session);

        session.close();
    }

    public void criteriaQuery(Session session) {
        Criteria criteria = session.createCriteria(cn.sunibas.testQueryOne.mytableCp.class);
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4}
         * ]
         * */

        criteria.add(Restrictions.eq("col1",3));
        //[{ col1 : 3 , col2 : something2}]

        /*
        criteria.add(Restrictions.[a]);
        a可以有很多选项
        * */

         System.out.println(criteria.list());
    }

    public void queryQuery(Session session) {
        //这种方法的缺点是只能对应一种数据库,优点是容易看.
        Query query = session.createSQLQuery("select * from t_mytable");
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4}
         * ]
         * */
        System.out.println(query.list());
    }

}
