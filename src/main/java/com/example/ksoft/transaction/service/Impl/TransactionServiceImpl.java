package com.example.ksoft.transaction.service.Impl;

import com.example.ksoft.transaction.dao.TransactionDao;
import com.example.ksoft.transaction.model.Transaction;
import com.example.ksoft.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao;

    @Autowired
    TransactionServiceImpl(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    @Transactional
    @Override
    public Transaction save(Transaction transaction) {
        return transactionDao.save(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionDao.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionDao.findById(id).orElseThrow();
    }
}
