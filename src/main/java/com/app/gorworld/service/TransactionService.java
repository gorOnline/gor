package com.app.gorworld.service;

import com.app.gorworld.model.Movies;
import com.app.gorworld.model.Transaction;
import com.app.gorworld.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    MongoSequenceGeneratorService sequenceGeneratorService;
    public Long createTransaction(Transaction transaction) {
        transaction.setId(sequenceGeneratorService.getSequenceNumber(Transaction.SEQUENCE_NAME));
        return transactionRepo.save(transaction).getId();
    }

    public List<Transaction> listTransaction() {
        return transactionRepo.findAll();
    }
}
