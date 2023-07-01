package com.app.gorworld.repo;

import com.app.gorworld.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepo extends MongoRepository<Transaction, Long> {
}
