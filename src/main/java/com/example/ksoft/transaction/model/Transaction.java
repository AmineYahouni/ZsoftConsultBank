package com.example.ksoft.transaction.model;

import com.example.ksoft.account.model.Account;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    private Long id;

    private Boolean state;// true si la transaction a réussie sinon false
    private Date date;

    private double amount;

    private double balance;

    @OneToOne
    private Account account;
}
