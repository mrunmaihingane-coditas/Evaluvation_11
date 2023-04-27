package model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String user_name;

    private int Balance;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Account> accountList;

    public User(String user_name, int balance) {
        this.user_name = user_name;
        Balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", user_name='" + user_name + '\'' +
                ", Balance=" + Balance +
                ", accountList=" + accountList +
                '}';
    }

    public User(){

    }


}
