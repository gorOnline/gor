package com.app.gorworld.service;

import com.app.gorworld.model.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class MongoSequenceGeneratorService {

//    @Autowired
//    MongoOperations mongoOperations;
//
//    public Long getSequenceNumber(String sequenceName){
//        Query query = new Query(Criteria.where("id").is(sequenceName));
//        Update update = new Update().inc("seqNo",1);
//
//        DbSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), DbSequence.class);
//        return Objects.isNull(counter) ? 1 : counter.getSeqNo();
//    }
}
