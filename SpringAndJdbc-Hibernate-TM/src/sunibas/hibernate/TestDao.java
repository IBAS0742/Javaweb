package sunibas.hibernate;

import org.hibernate.SessionFactory;

/**
 * Created by ibas on 12/20/16.
 */
public class TestDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(TestEntity testEntity){
        sessionFactory.getCurrentSession().save(testEntity);
    }
}
