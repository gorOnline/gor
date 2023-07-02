package com.app.gorworld.controller;


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
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDto transactionDto) {
        log.info("Inside -> createTransaction()");
        try {
            Long result = transactionService.createTransaction(transactionDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Transaction>> listTransaction(){

        List<Transaction> result = transactionService.listTransaction();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
