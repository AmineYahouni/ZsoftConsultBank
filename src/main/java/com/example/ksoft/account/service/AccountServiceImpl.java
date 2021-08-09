package com.example.ksoft.account.service;

import com.example.ksoft.account.dao.AccountDao;
import com.example.ksoft.account.model.Account;
import com.example.ksoft.client.model.Client;
import com.example.ksoft.client.service.ClientService;
import com.example.ksoft.transaction.model.Transaction;
import com.example.ksoft.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    ClientService clientService;

    AccountDao accountDao;

    TransactionService transactionService;



    @Transactional
    @Override
    public List<Account>  deposit(double amount, Long client_id, Long accountId){
        Client client;
        client = clientService.findById(client_id) ;
        client.setAccounts(client.getAccounts().stream().map(account -> {
            boolean state =true;
            if(Objects.equals(account.getId(), accountId)){
                account.setBalance(account.getBalance()+ amount);
                this.AccountStatement(amount, account, client_id, state);
            }
            return account;
        }).collect(Collectors.toList()));

        return clientService.save(client).getAccounts();
    }

    @Transactional
    @Override
    public List<Account> withdrawal(double amount, Long client_id, Long accountId){
        Client client;
            client = clientService.findById(client_id);
            var accounts = client.getAccounts();
                 accounts = accounts.stream().map(account -> {
                if(Objects.equals(account.getId(), accountId)){
                    boolean state =false;
                    if (account.getBalance() <amount) {
                        this.AccountStatement(amount, account, client_id, state);
                    }else{
                        state=true;
                        account.setBalance(account.getBalance() - amount);
                        this.AccountStatement(amount, account, client_id, state);

                    }
                }
            return account;
                    }).collect(Collectors.toList());

        client.setAccounts(accounts);

       return clientService.save(client).getAccounts();

    }

    @Transactional
    void AccountStatement(double amount, Account account, Long clientId, boolean state){
        Client client;
        client = clientService.findById(clientId);
        var transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setBalance(account.getBalance());
        transaction.setAmount(amount);
        transaction.setDate(new Date());
        transaction.setState(state);
        var transactions = client.getTransactions();
        transactions.add(transaction);
        client.setTransactions(transactions);
        transactionService.save(transaction);
       // clientService.save(client);
        System.out.println("Balance : "+ account.getBalance() +" Amount : "+amount+" Date :"+new Date());
    }
}
