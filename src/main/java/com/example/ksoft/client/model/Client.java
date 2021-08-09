package com.example.ksoft.client.model;

import com.example.ksoft.account.model.Account;
import com.example.ksoft.transaction.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    private Long id;

    @Column(name="last_name")
    private String lastName;


    @Column(name="first_name")
    private String firstName;


    @Column(name="birth_date")
    private String birthDate;

    private String email;

    @OneToMany
    private List<Account> accounts;

    @OneToMany
    private List<Transaction> transactions;

}
