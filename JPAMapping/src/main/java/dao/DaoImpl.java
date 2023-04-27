package dao;

import model.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.Date.valueOf;

public class DaoImpl implements dao{
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rt");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void inser() throws IOException, ParseException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("enter name of User");
        String EnterShopName = br.readLine();
        System.out.println("enter name of Balance");
        int id = Integer.parseInt(br.readLine());

        User user = new User();
        user.setUser_name(EnterShopName);
        user.setBalance(id);


        entityManager.persist(user);

        int choice;
        do {
            System.out.println("enter 1 to add Acount\n0 to exit");
            choice = Integer.parseInt(br.readLine());
            if (choice == 1) {

                System.out.println("enter type account name");
                String type=br.readLine();
                System.out.println("enter status name");
                String status=br.readLine();
                System.out.println("Enter Student_date of Enrollment (yyyy-MM-dd):");
                String dateString = br.readLine();
                Date datepulish = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

                Account customer=new Account(type,status,datepulish,user);
                entityManager.persist(customer);

            }
        }while(choice!=0);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void insertBank() throws IOException, ParseException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("Number Bank to insert");
        int choies= Integer.parseInt(br.readLine());

        for (int i=0;i<choies;i++) {
            System.out.println("Enter Bank Name");
            String product = br.readLine();


            Bank product1=new Bank();
            product1.setBank_name(product);
            entityManager.persist(product1);

        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void insertMappingInsert() throws IOException, ParseException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("enter BankId");
        int studentId= Integer.parseInt(br.readLine());

        Bank student = entityManager.find(Bank.class,studentId);

        entityManager.persist(student);

        System.out.println("Enter Number Account to add");
        int choies= Integer.parseInt(br.readLine());

        List<Account> subjectList=new ArrayList<>();
        for (int i=0;i<choies;i++) {

            System.out.println("Enter Account Id ");
            int subject_Id = Integer.parseInt(br.readLine());
            Account subject = entityManager.find(Account.class,subject_Id );

            subjectList.add(subject);
            entityManager.persist(subject);

        }
        System.out.println("Add in list");
        student.setAccountList(subjectList);

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();



    }

    public void updateAccountStatus() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Account> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Account.class);
        Root<Account> accountRoot = criteriaUpdate.from(Account.class);

        Subquery<User> subquery = criteriaUpdate.subquery(User.class);
        Root<User> subqueryRoot = subquery.from(User.class);
        subquery.select(subqueryRoot);
        subquery.where(criteriaBuilder.greaterThan(subqueryRoot.<Integer>get("Balance"), 100000));

        criteriaUpdate.set(accountRoot.get("Status"), "Prime");
        criteriaUpdate.where(accountRoot.get("user").in(subquery));

        Query query = entityManager.createQuery(criteriaUpdate);
        int updatedCount = query.executeUpdate();
        System.out.println("Number of accounts updated: " + updatedCount);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void deleteData() throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("Enter User Id :");
        int Userid = Integer.parseInt(br.readLine());


        Bank user = entityManager.find(Bank.class, Userid );
        if (user == null) {
            System.out.println(" not found");
        } else {
            entityManager.remove(user);
            entityManager.getTransaction().commit(); // commit the transaction before closing the EntityManager
            System.out.println("Data deleted !!");
            entityManager.close();
        }

    }
    public void updateAccountBalance() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
        Root<User> userRoot = criteriaUpdate.from(User.class);

        criteriaUpdate.set(userRoot.<Number>get("Balance"), criteriaBuilder.diff(userRoot.<Number>get("Balance"), 250));
        criteriaUpdate.where(criteriaBuilder.and(
                criteriaBuilder.lessThan(userRoot.<Comparable>get("Balance"), 100000),
                criteriaBuilder.equal(userRoot.get("Status"), "Prime")
        ));

        Query query = entityManager.createQuery(criteriaUpdate);
        int updatedCount = query.executeUpdate();
        System.out.println("Number of accounts updated: " + updatedCount);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void getUsersWithAccountsBefore2023(EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        Join<User, Account> account = user.join("accountList");

        java.sql.Date date = java.sql.Date.valueOf("2023-01-01");
        Predicate predicate = cb.lessThan(account.<java.sql.Date>get("account_date"), date);

        query.select(user).distinct(true).where(predicate);

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        List<User> users = typedQuery.getResultList();

        for (User user1 : users) {
            System.out.println(user1.getUser_name());
        }
    }










    @Override
    public void insert() throws IOException, ParseException {

    }

    @Override
    public void update(int id) throws IOException {

    }

    @Override
    public void delete(int id) throws IOException {

    }

    @Override
    public void Show(int id) throws IOException {

    }
}
