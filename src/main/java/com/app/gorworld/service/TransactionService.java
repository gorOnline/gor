package com.app.gorworld.service;

import com.app.gorworld.dto.TransactionDto;
import com.app.gorworld.exception.UserNotFoundException;
import com.app.gorworld.model.Transaction;
import com.app.gorworld.model.User;
import com.app.gorworld.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    UserService userService;

    @Autowired
    GorUtilService gorUtilService;

    @Autowired
    MongoSequenceGeneratorService sequenceGeneratorService;

    public Long createTransaction(TransactionDto transactionDto) throws UserNotFoundException {
        String mobileNumber = transactionDto.getMobileNumber();

        User user = userService.checkUserExists(mobileNumber);
        Transaction transaction = new Transaction();
        transaction.setId(sequenceGeneratorService.getSequenceNumber(Transaction.SEQUENCE_NAME));
        transaction.setTranId(transactionDto.getTranId());
        transaction.setTranStatus(transactionDto.getTranStatus());
        transaction.setMobileNumber(mobileNumber);
        transaction.setPlan(gorUtilService.convertToPLAN(transactionDto.getPlan()));
        transaction.setTranDate(new Date());

        Long tranId = transactionRepo.save(transaction).getId();
        if (transactionDto.getTranStatus().equals("Success")) {
            userService.updateUserPlan(transactionDto.getPlan(), user);
        }
        return tranId;
    }

    public List<Transaction> listTransaction() {
        return transactionRepo.findAll();
    }
}
