package cn.sunibas.testQueryOne;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ibas on 11/29/16.
 */
public class testHOne {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(mytableCp.class)
                .buildSessionFactory();
    }

    @Test
    public void insertData(){
        Session session = sf.openSession();
        session.getTransaction().begin();

        for (int i = 0;i < 10;i++) {
            mytableCp mytable = new mytableCp();
            mytable.setCol2("something" + i);
            session.save(mytable);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void hqlQuery(){
        Session session = sf.openSession();
        //全部查询
        //allQuery1(session);
        //allQuery2(session);

        //查询某一列
        //queryOneColumn(session);

        //条件查询
        //queryAboutCondition(session);
        //queryAboutCondition1(session);

        //聚合
        //queryCount(session);
        queryGroupBY(session);

        session.close();
    }

    public void allQuery1(Session session){
        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp");
        System.out.println(q.list());
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4},
         *  { col1 : 6 , col2 : something5},
         *  { col1 : 7 , col2 : something6},
         *  { col1 : 8 , col2 : something7},
         *  { col1 : 9 , col2 : something8},
         *  { col1 : 10 , col2 : something9}
         * ]
         * */
    }

    public void allQuery2(Session session) {
        //Query q = session.createQuery("select * from cn.sunibas.testQueryOne.mytableCp"); // Error
        Query q = session.createQuery("select ta from cn.sunibas.testQueryOne.mytableCp ta");
        System.out.println(q.list());
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4},
         *  { col1 : 6 , col2 : something5},
         *  { col1 : 7 , col2 : something6},
         *  { col1 : 8 , col2 : something7},
         *  { col1 : 9 , col2 : something8},
         *  { col1 : 10 , col2 : something9}
         * ]
         * */
    }

    public void queryOneColumn(Session session){
//        Query q = session.createQuery("select ta.col2 from cn.sunibas.testQueryOne.mytableCp ta");
//        System.out.print(q.list());
       /* *
         * [something0, something1, something2, something3, something4, something5,
         * something6, something7, something8, something9]
         * */


//        Query q = session.createQuery("select ta.col1 from cn.sunibas.testQueryOne.mytableCp ta");
//        System.out.print(q.list());
        /**
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * */


//        Query q = session.createQuery("select ta.col1,ta.col2 from cn.sunibas.testQueryOne.mytableCp ta");
//        System.out.print(q.list());
        /**
         * [
         *  [Ljava.lang.Object;@343570b7,
         *  [Ljava.lang.Object;@157853da,
         *  [Ljava.lang.Object;@71c3b41,
         *  [Ljava.lang.Object;@236e3f4e,
         *  [Ljava.lang.Object;@3cc1435c,
         *  [Ljava.lang.Object;@6bf0219d,
         *  [Ljava.lang.Object;@dd0c991,
         *  [Ljava.lang.Object;@5f16132a,
         *  [Ljava.lang.Object;@69fb6037,
         *  [Ljava.lang.Object;@36d585c
         * ]
         * */


//        Query q = session.createQuery("select ta.col1,ta.col2 from cn.sunibas.testQueryOne.mytableCp ta");
//        Iterator<mytableCp> iterator = q.list().iterator();
//        while (iterator.hasNext()) {
//            mytableCp o = (mytableCp)iterator.next();
//            System.out.println(o);
//        }
        /**
         * java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to cn.sunibas.testQueryOne.mytableCp
         * */

//        Query q = session.createQuery("select new mytableCp(ta.col1,ta.col2) from cn.sunibas.testQueryOne.mytableCp ta");
//        System.out.print(q.list());
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4},
         *  { col1 : 6 , col2 : something5},
         *  { col1 : 7 , col2 : something6},
         *  { col1 : 8 , col2 : something7},
         *  { col1 : 9 , col2 : something8},
         *  { col1 : 10 , col2 : something9}
         * ]
         * */
    }

    public void queryAboutCondition(Session session){
        //简单条件查询
//        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp mt where col1<3");
//        System.out.println(q.list());
        /* *
         *[{ col1 : 1 , col2 : something0}, { col1 : 2 , col2 : something1}]
         * */


//        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp mt where col1<?");
//        q.setParameter(0,3);
//        //q.setInteger(0,3);//等价以上
//        System.out.println(q.list());
        /**
         * [{ col1 : 1 , col2 : something0}, { col1 : 2 , col2 : something1}]
         * */


//      这里的 :col 是一个整体,不能分开,一般无法分清就将所有地方都连在一起
//        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp mt where col1<:col1");
//        q.setParameter("col1",2);
//        System.out.println(q.list());
        //[{ col1 : 1 , col2 : something0}]


//        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp mt where col1<? and col2=?");
//        q.setParameter(0,10);
//        q.setParameter(1,"something1");
//        System.out.println(q.list());
        //[{ col1 : 2 , col2 : something1}]

        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp mt where col1 between ? and ?");
        q.setParameter(0,7);
        q.setParameter(1,9);
        System.out.println(q.list());
        /**
         * [
         *  { col1 : 7 , col2 : something6},
         *  { col1 : 8 , col2 : something7},
         *  { col1 : 9 , col2 : something8}
         * ]
         * */

     }

    public void queryAboutCondition1(Session session){
//        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp where col1 like ?");
//        q.setInteger(0,1);
//        System.out.println(q.list());
        //[{ col1 : 1 , col2 : something0}]

        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp where col2 like ?");
        q.setParameter(0,"something0");
        System.out.println(q.list());
        //[{ col1 : 1 , col2 : something0}]
    }

    public void queryCount(Session session){
//        Query q = session.createQuery("select count(*) from cn.sunibas.testQueryOne.mytableCp");
//        System.out.println(q.list());
//        //[10]
//        System.out.println(q.uniqueResult());
//        //10


//        Query q = session.createQuery("select count(1) from cn.sunibas.testQueryOne.mytableCp");
//        System.out.println(q.list());
//        //unexpected token: 1 near line 1,
//        System.out.println(q.uniqueResult());
//        //unexpected token: 1 near line 1,
        /**
         mysql> select count(1) from t_mytable;
         +----------+
         | count(1) |
         +----------+
         |       10 |
         +----------+
         1 row in set (0.00 sec)
         * */
    }

    public void queryGroupBY(Session session) {
        Query q = session.createQuery("from cn.sunibas.testQueryOne.mytableCp group by col1");
        System.out.println(q.list());
        /**[
         *  { col1 : 1 , col2 : something0},
         *  { col1 : 2 , col2 : something1},
         *  { col1 : 3 , col2 : something2},
         *  { col1 : 4 , col2 : something3},
         *  { col1 : 5 , col2 : something4},
         *  { col1 : 6 , col2 : something5},
         *  { col1 : 7 , col2 : something6},
         *  { col1 : 8 , col2 : something7},
         *  { col1 : 9 , col2 : something8},
         *  { col1 : 10 , col2 : something9}
         * ]
         * */
    }
}
