package web;
import dao.DaoImpl;
import model.Account;
import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException, SQLException, ParseException {
        System.out.println("BOOK MANAGEMENT SYSTEM");
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rt");

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Account account = new Account();
        Bank bank = new Bank();
        User user = new User();
        DaoImpl daoimpl= new DaoImpl();

        boolean flag = true;
        while (flag) {

            System.out.println("1. Insert ");
            System.out.println("2. Insert Bank");
            System.out.println("3. Insert Mapping");
            System.out.println("4.Update account Prime status");
            System.out.println("5. 3 query");
            System.out.println("6.");
            System.out.println("7. Date Query  ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    daoimpl.inser();
                    break;
                case 2:
                    daoimpl.insertBank();
                    break;
                case 3:
                    daoimpl.insertMappingInsert();
                    break;
                case 4:
                    daoimpl.updateAccountStatus();
                    break;
                case 5:
                    daoimpl.updateAccountBalance();
                    break;
                case 6:
                    daoimpl.deleteData();
                    break;
                case 7:
                    EntityManager entityManager = entityManagerFactory.createEntityManager();
                    daoimpl.getUsersWithAccountsBefore2023(entityManager);
                    break;
                case 8:
                    break;
                case 0:
                    flag = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
"C:\Program Files\Java\jdk-19\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\lib\idea_rt.jar=50937:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.3.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\Coditas\IdeaProjects\JPAMapping\target\classes;C:\Users\Coditas\.m2\repository\org\glassfish\web\javax.servlet.jsp.jstl\1.2.4\javax.servlet.jsp.jstl-1.2.4.jar;C:\Users\Coditas\.m2\repository\javax\servlet\jsp\jstl\jstl-api\1.2\jstl-api-1.2.jar;C:\Users\Coditas\.m2\repository\org\hibernate\hibernate-core\5.6.5.Final\hibernate-core-5.6.5.Final.jar;C:\Users\Coditas\.m2\repository\org\jboss\logging\jboss-logging\3.4.3.Final\jboss-logging-3.4.3.Final.jar;C:\Users\Coditas\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\Coditas\.m2\repository\net\bytebuddy\byte-buddy\1.12.7\byte-buddy-1.12.7.jar;C:\Users\Coditas\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\Coditas\.m2\repository\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.1.1.Final\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;C:\Users\Coditas\.m2\repository\org\jboss\jandex\2.4.2.Final\jandex-2.4.2.Final.jar;C:\Users\Coditas\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\Coditas\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\Coditas\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.1.2.Final\hibernate-commons-annotations-5.1.2.Final.jar;C:\Users\Coditas\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\Coditas\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.1\jaxb-runtime-2.3.1.jar;C:\Users\Coditas\.m2\repository\org\glassfish\jaxb\txw2\2.3.1\txw2-2.3.1.jar;C:\Users\Coditas\.m2\repository\com\sun\istack\istack-commons-runtime\3.0.7\istack-commons-runtime-3.0.7.jar;C:\Users\Coditas\.m2\repository\org\jvnet\staxex\stax-ex\1.8\stax-ex-1.8.jar;C:\Users\Coditas\.m2\repository\com\sun\xml\fastinfoset\FastInfoset\1.2.15\FastInfoset-1.2.15.jar;C:\Users\Coditas\.m2\repository\mysql\mysql-connector-java\8.0.28\mysql-connector-java-8.0.28.jar;C:\Users\Coditas\.m2\repository\com\google\protobuf\protobuf-java\3.11.4\protobuf-java-3.11.4.jar web.main
BOOK MANAGEMENT SYSTEM
Apr 27, 2023 3:54:00 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
Apr 27, 2023 3:54:00 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
Apr 27, 2023 3:54:00 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Apr 27, 2023 3:54:01 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
Apr 27, 2023 3:54:01 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/eval_10?createDatabaseIfNotExist=true]
Apr 27, 2023 3:54:01 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=root}
Apr 27, 2023 3:54:01 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:54:01 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:54:02 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 27, 2023 3:54:03 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@32b0876c] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    alter table Account 
       add constraint FK5hx7appo1o2iikulb02dm8y8 
       foreign key (user_userId) 
       references User (userId)
Hibernate: 
    
    alter table Bank_Account 
       add constraint FKd3tkoit12ciiilypiux2cjwbn 
       foreign key (accountList_Account_id) 
       references Account (Account_id)
Hibernate: 
    
    alter table Bank_Account 
       add constraint FKniie3k3199kj6lym6oqpdjmp1 
       foreign key (bankList_bank_id) 
       references Bank (bank_id)
Apr 27, 2023 3:54:03 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Apr 27, 2023 3:54:03 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
Apr 27, 2023 3:54:03 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Apr 27, 2023 3:54:03 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/eval_10?createDatabaseIfNotExist=true]
Apr 27, 2023 3:54:03 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=root}
Apr 27, 2023 3:54:03 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Apr 27, 2023 3:54:03 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Apr 27, 2023 3:54:03 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
Apr 27, 2023 3:54:03 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@71b639d0] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    alter table Account 
       add constraint FK5hx7appo1o2iikulb02dm8y8 
       foreign key (user_userId) 
       references User (userId)
Hibernate: 
    
    alter table Bank_Account 
       add constraint FKd3tkoit12ciiilypiux2cjwbn 
       foreign key (accountList_Account_id) 
       references Account (Account_id)
Hibernate: 
    
    alter table Bank_Account 
       add constraint FKniie3k3199kj6lym6oqpdjmp1 
       foreign key (bankList_bank_id) 
       references Bank (bank_id)
Apr 27, 2023 3:54:03 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
1. Insert 
2. Insert Bank
3. Insert Mapping
4.Update account Prime status
5. 3 query
6.
7. Date Query  
7
Hibernate: 
    select
        distinct user0_.userId as userid1_3_,
        user0_.Balance as balance2_3_,
        user0_.user_name as user_nam3_3_ 
    from
        User user0_ 
    inner join
        Account accountlis1_ 
            on user0_.userId=accountlis1_.user_userId 
    where
        accountlis1_.account_date<?
Mrunmai
Aryanman
Yash
1. Insert 
2. Insert Bank
3. Insert Mapping
4.Update account Prime status
5. 3 query
6.
7. Date Query  

