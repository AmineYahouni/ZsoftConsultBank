package com.example.ksoft.client.controler;

import com.example.ksoft.account.dao.AccountDao;
import com.example.ksoft.account.service.AccountService;
import com.example.ksoft.client.dao.ClientDao;
import com.example.ksoft.account.model.Account;
import com.example.ksoft.client.model.Client;
import com.example.ksoft.client.service.ClientService;
import com.example.ksoft.transaction.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankController {


    ClientService clientService;

    AccountService accountService;



    @GetMapping("/clientAndAccounts")
    public Client createClient(){

       return clientService.createClient();

    }

    @PutMapping("client/{cId}/account/{aId}/withdrawal")
    public List<Account> Withdrawal(@PathVariable Long aId, @RequestBody double montant, @PathVariable Long cId){
        return accountService.withdrawal(montant,cId,aId);
    }


    @PutMapping("client/{cId}/account/{aId}/deposit")
    public List<Account> deposit(@PathVariable Long aId, @RequestBody double montant, @PathVariable Long cId){
        return accountService.deposit(montant,cId,aId);
    }



    @GetMapping("client/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long id){
        return clientService.findById(id).getTransactions();
    }
}
