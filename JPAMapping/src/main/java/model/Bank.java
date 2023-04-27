package model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;
@Entity
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bank_id;

    private String Bank_name;

    @ManyToMany
    private List<Account>accountList;





}
