package com.example.ksoft.account.service;

import com.example.ksoft.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
     List<Account> withdrawal(double amount, Long client_id, Long accountId);
     List<Account> deposit(double amount, Long client_id, Long accountId);

}
