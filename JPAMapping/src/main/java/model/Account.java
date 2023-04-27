package model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Account_id;

    private String Account_Type;

    private String Status;

    private Date account_date;

    public Account() {
    }

    public Account(String account_Type, String status, Date account_date, User user) {
        Account_Type = account_Type;
        Status = status;
        this.account_date = account_date;
        this.user = user;
    }

    @ManyToOne()
    private User user;

    @ManyToMany(mappedBy = "accountList")
    private List<Bank>bankList;


}
