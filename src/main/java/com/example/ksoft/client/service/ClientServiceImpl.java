package com.example.ksoft.client.service;

import com.example.ksoft.account.dao.AccountDao;
import com.example.ksoft.account.model.Account;
import com.example.ksoft.client.dao.ClientDao;
import com.example.ksoft.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientDao clientDao;

    @Autowired
    AccountDao accountDao;

    @Transactional
    @Override
    public Client createClient() {
        var accounts = new ArrayList<Account>();
        var account = new Account();
        account.setBalance(2000);
        account.setType("Compte courant");
        account = accountDao.save(account); // récuperer la nouvelle valeur de notre id aprés insertion
        accounts.add(account);
        account = new Account();
        account.setBalance(5000);
        account.setType("Livret A");
        account = accountDao.save(account);
        accounts.add(account);
        account = new Account();
        account.setBalance(5000);
        account.setType("Livret jeune");
        account = accountDao.save(account);
        accounts.add(account);
        var client = new Client();
        client.setEmail("billel.boudjit@zsoft-consulting.com");
        client.setBirthDate("01/01/1900");
        client.setFirstName("Billel");
        client.setLastName("Boudjit");
        client.setAccounts(accounts);
        client.setTransactions(new ArrayList<>());
        return  clientDao.save(client);
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientDao.findById(id).orElseThrow();
    }
}
