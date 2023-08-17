package com.app.gorworld.controller;


import com.app.gorworld.dto.CreateTransactionDto;
import com.app.gorworld.dto.TransactionDto;
import com.app.gorworld.model.Transaction;
import com.app.gorworld.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    Logger log = LoggerFactory.getLogger(TransactionController.class);
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<CreateTransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        log.info("Inside -> createTransaction()");
        CreateTransactionDto result = new CreateTransactionDto();
        try {
            result.setTranId(transactionService.createTransaction(transactionDto));
            result.setMessage("Transaction created Successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Transaction>> listTransaction(){

        List<Transaction> result = transactionService.listTransaction();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
