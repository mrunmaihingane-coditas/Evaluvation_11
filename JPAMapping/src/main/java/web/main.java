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
