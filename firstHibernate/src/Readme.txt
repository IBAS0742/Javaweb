###Here, my environment is :
###OS(系统) : UBUNTU 14.04 TLS
###IDE(编译器) : INTELLIJ IDEA 14.0.5
###DATABASE(数据库) : 5.7.16 MySQL Community Server (GPL)
###JDK : 1.8.0_111
###Project Langure Level : 6


#You can reference the （你可以参考） /Hibernate_lib/hibernate3.jar!/org/hibernate/hibernate-mapping-3.0.dtd
#and (和) /Hibernate_lib/hibernate3.jar!/org/hibernate/hibernate-configuration-3.0.dtd
#to know more about setting the configure(xml) file.
#以了解更多关于如何配置配置文件的知识。

Say something for the package "cn.sunibas.*"
说明有关于cn.sunibas包下的内容
%If you are a beginner , I hope you read my project order by as follow statement . %
%如果你是一个新手，我希望你按照以下顺序进行阅读。%
%At the previous examples, I will show some detail more and show less at later period. %
%前期的例子中，将比较详细，后期将会简略。%

#1.package(包) cn.sunibas.testHibernate;
    This is the first package that I write , and I write a very very simple example to explain hwo the hibernate working .
    这是我写的第一个包，一个最为简单的例子介绍hibernate配置。

#2.package(包) cn.sunibas.testRelate
    In this package , I will tell you about how to configured the related classes .
    这个包下配置的是有联系的类。(关系型表结构)
    #package(包) cn.sunibas.testRelateOTO/testRelateTwo
    #This is a similar example.(和以上例子相似)
    ###########
    #package(包) cn.sunibas.testRelateOTOPK
    #This is a similar example , but the foreign key is as same as the primary key for the table.
    #(和以上例子相似，只是这里的外键同时作为主键)
    ###########
    #package(包) cn.sunibas.testRelateThree
    #This is a similar example , but two table related by another table.
    #和以上例子相似，只是将表关系保存到另一个表

#3.package(包) cn.sunibas.testComponent
    In this package , I will show a example about how to make two related classes to be store in a table.
    这里将讲解怎样将两个相关的类保存到一个数据表中。（组件映射）

#4.package(包) cn.sunibas.testInheritance    (not recommend)
    In this package , I test to write a class which is inherited from another class.
    这个包中将测试继承关系的类。
    (All the subclass are according to a table.每个类对应于一张表。)
    #cn.sunibas.testInheritanceOneTable
    #All class is according to one table.所有的类对应于一张表。
    ###########
    #cn.sunibas.testInheritanceThreeTable   (not recommend)
    #All class is according to a table and superclass also have one table.(每个类包括父类都有一张表。)
    ###########
    #cn.sunibas.testInheritanceUnionTable
    #All class is accordiong to one table.(除了父类每个类对应一张表。)

#5.package(包) cn.sunibas.testQueryOne
    In this package, I will test some query (HQL) fro single table testing.(这里我将测试一些单表hql查询。)
    ###########
    #cn.sunibas.testQueryTwo
    #In this package, I will test some query (HQL) fro multi-table testing.(这里我将测试一些多表联合hql查询。)
    ###########
    #cn.sunibas.testQueryThree
    #In this package, I will test some query statement which I define at the xml.(这里测试一些在xml中定义的hql语句。)
    ###########
    #cn.sunibas.testQueryFour
    #In this package, I will test some other query (cri).(这里将测试其他查询)
    ###########
    #cn.sunibas.testQueryFour
    #In this package, I will test some paging query (cri).(这里将测试分页查询)



#About Connection pool (关于连接池)
数据库中(IN DATABASE)
mysql> show processlist; -- 可以显示连接数
+----+------+-----------+----------+---------+------+----------+------------------+
| Id | User | Host      | db       | Command | Time | State    | Info             |
+----+------+-----------+----------+---------+------+----------+------------------+
|  2 | root | localhost | forstudy | Query   |    0 | starting | show processlist |
+----+------+-----------+----------+---------+------+----------+------------------+
1 row in set (0.00 sec)

#以下配置 C3P0 的一些配置项,应该放在配置映射文件前
    <property name="hibernate.connection.driver_class">
        org.hibernate.connection.C3P0ConnectionProvider         <!-- 配置驱动 -->
    </property>
    <property name="hibernate.c3p0.max_size">4</property>         <!-- 配置最大连接数 -->
    <property name="hibernate.c3p0.min_size">2</property>         <!-- 配置最小连接数 -->
    <property name="hibernate.c3p0.timeout">5000</property>         <!-- 配置连接超时时间 -->
    <property name="hibernate.c3p0.max_statements">10</property>         <!-- 配置一次最多查询语句 -->
    <property name="hibernate.c3p0.idle_test_period">30000</property>         <!-- 配置测试连接时间<<<1>>> -->
    <property name="hibernate.c3p0.acquire_increment">2</property>         <!-- 配置一次增加连接数<<<2>>> -->
    <!-- 以下为缓存配置 -->
    <class-cache class="类名" usage="缓存策略"></class-cache>              <!-- 缓存对象 -->
    <collection-cache collection="类名.集合属性" usage="缓存策略"></collection-cache>        <!-- 集合缓存<<<3>>> -->
    <!-- ###### 以下为注解 ###### -->
    <!-- <<<1>>>
        这里假设测试连接时间为1min,用途是:
        当一个连接被占用后,如果没有被释放,
        同时,连接时间又极长,
        并且连接过程中没有任何查询,
        那么可能发生的问题是,连接会失效,
        这里的设置就是,每过1min发送一个无意义的查询语句,
        使连接一直有效.
     -->
    <!-- <<<2>>>
        假如,当前最大连接数为8,最小为2,一次增加连接数为4,
        那么查询开始时会先申请2个连接,然后如果连接不够就申请4个(即当前有6个),
        如果还是不够就继续申请4个,但是6 + 4 > 8,只能再申请2个,
        这里的一次申请,不是申请了就一定用到,只是规定不够的时候一次申请多少.
     -->
    <!-- <<<3>>>
        其中的 collection 为类中的集合属性,例如类结构如下时:
        class A {
            private int aid;
            private List<B> bs;
            ...
        }
        collection 就可以写 A.bs.
        同时必须为 B 写缓存策略.即
        <class-cache class="B" usage="缓存策略"></class-cache>
     -->



