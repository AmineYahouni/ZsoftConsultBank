package com.example.ksoft.transaction.service;

import com.example.ksoft.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {

    /**
     * save the transaction passed in param.
     *
     * @param transaction the transaction to save.
     * @return the saved transaction.
     */
    Transaction save(Transaction transaction);


}
