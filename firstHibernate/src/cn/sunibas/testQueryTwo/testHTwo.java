package cn.sunibas.testQueryTwo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.List;

/**
 * Created by ibas on 12/2/16.
 * 测试一对多的关系
 */
public class testHTwo {
    static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Employee.class)
                .addClass(Dept.class)
                .buildSessionFactory();
    }

    @Test
    public void insertData(){
        Session session = sf.openSession();
        session.beginTransaction();

        Dept depta = new Dept();
        Dept deptb = new Dept();

        Employee ea = new Employee();
        Employee eb = new Employee();
        Employee ec = new Employee();
        Employee ed = new Employee();
        Employee ee = new Employee();

        depta.setDeptName("one");
        deptb.setDeptName("two");

        ea.setEmpName("ea");
        eb.setEmpName("eb");
        ec.setEmpName("ec");
        ed.setEmpName("ed");
        ee.setEmpName("ee");

        depta.getEmps().add(ea);
        depta.getEmps().add(eb);
        depta.getEmps().add(ec);
        deptb.getEmps().add(ed);
        deptb.getEmps().add(ee);

        session.save(depta);
        session.save(deptb);
        session.save(ea);
        session.save(eb);
        session.save(ec);
        session.save(ed);
        session.save(ee);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testQuerying(){
        Session session = sf.openSession();

        //say something about fetch
        saySomethingFetch();
        //联合
        testJoin(session);

        session.close();
    }

    public void testJoin(Session session) {
//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e inner join e.dept");
//        System.out.println(query.list());
        //[[Ljava.lang.Object;@e7edb54, [Ljava.lang.Object;@....
        //from debug:
        // [
        //  {
        //      { empId : 1 , empName : ea dept : { deptId : 1 , deptName : one } } ,
        //      { deptId : 1 , deptName : one }
        //  } , ...
        // ]


//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e left join e.dept");
//        List<Object> object = query.list();
        //[ {
        //      { empId : 1 , empName : ea dept : { deptId : 1 , deptName : one } }
        //      { deptId : 1 , deptName : one },
        //  } , ...
        //]

//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e right join e.dept");
//        List<Object> object = query.list();
        //没有执行,应该就顺序 不同

        //有 fetch 的结果是,两个表的数据连接查询后结果被保存到一个类中,而没有 fetch 会被保存到两个类中 <<<1>>>
//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e left join fetch e.dept");
//        List<Object> object = query.list();
        /**
         * [ {
         *     empId = 1,
         *     empName = "ea",
         *     dept = {
         *         deptId = 1,
         *         deptName = "one",
         *         emps = [...]
         *     }
         *  }, ...
         * ]
         * */

        /*

//        no test
//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e right join fetch e.dept");
//        List<Object> object = query.list();
//        Query query = session.createQuery("from cn.sunibas.testQueryTwo.Employee e inner join fetch e.dept");
//        List<Object> object = query.list();
        * */

        System.out.println("pause");
    }

    //<<<1>>>
    public void saySomethingFetch(){
        System.out.println( "Something about fetch : "
                + "\r\n" + "假设有两个类A和B"
                + "\r\n" + "表结构如下"
                + "\r\n" + "table A (aid , name)"
                + "\r\n" + "table B (bid , age)"
                + "\r\n" + "例如查询如下"
                + "\r\n" + "from A inner join [fetch] B"
                + "\r\n" + "1.如果没有fetch,辣么查询结构是这样的 : "
                + "\r\n" + "[{A , B},{A , B}, ...]"
                + "\r\n" + "2.如果有fetch查询结果是这样的:"
                + "\r\n" + "[A , A , ...]"
                + "\r\n" + "3.两者区别好像有一点模糊,"
                + "\r\n" + "这里之所以加了fetch后只返回一个类,是因为A中有B的映射,B中有A的映射,"
                + "\r\n" + "即A中有B的一个'引用'(借用这个名称),B中有A的'引用',"
                + "\r\n" + "将B合并到A的时候,自然就只有一个A对象."
        );
    }
}
