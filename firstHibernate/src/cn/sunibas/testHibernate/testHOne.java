package cn.sunibas.testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import org.hibernate.cfg.Configuration;

/**
 * Created by ibas on 11/29/16.
 */
public class testHOne {
    @Test
    public void funOne(){
        System.out.println("funOne");
    }

    //This is the first test , and at the next test I will make something different .
    //这是第一个测试，接下来的测试将会有所不同。
    @Test
    public void funTwo() throws Exception{
        //http://blog.csdn.net/54powerman/article/details/50345227
        mytable mt = new mytable();
        mt.setCol1("first");
        mt.setCol2("second");

        Configuration conf = new Configuration();
        conf.configure();

        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(mt);

        tx.commit();

        session.close();

        sf.close();
    }

    //test to connect database
    //测试连接数据库
    @Test
    public void testCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("exception " + e.toString());
        }
    }
}
