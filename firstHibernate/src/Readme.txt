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




