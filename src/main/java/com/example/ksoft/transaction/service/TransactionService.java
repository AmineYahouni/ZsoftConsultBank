package com.example.ksoft.transaction.service;

import com.example.ksoft.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> findAll();

    Transaction findById(Long id);
}
