package com.example.ksoft.account.service;

import com.example.ksoft.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
     /**
      * make the withdrawal for the gievent account and client.
      * If the balance is good enough, we make the transaction with state true else we don't make the transaction with state false.
      *
      * @param amount the amount to withdraw.
      * @param accountId the id of the account where the withdrawal will happen.
      * @param client_id the id of the client who have the account.
      * @return the list accounts of the client with the new balance.
      */
     List<Account> withdrawal(double amount, Long client_id, Long accountId);

     /**
      * make the deposit for the gievent account and client.
      * we make the transaction with state true.
      *
      * @param amount the amount to deposit.
      * @param accountId the id of the account where the deposit will happen.
      * @param client_id the id of the client who have the account.
      * @return the list accounts of the client with the new balance.
      */
     List<Account> deposit(double amount, Long client_id, Long accountId);

}
