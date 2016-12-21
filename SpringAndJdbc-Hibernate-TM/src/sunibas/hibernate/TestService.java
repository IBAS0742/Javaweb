package sunibas.hibernate;

/**
 * Created by ibas on 12/20/16.
 */
public class TestService {
    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public void save(TestEntity testEntity) {
        testDao.save(testEntity);
    }
}
