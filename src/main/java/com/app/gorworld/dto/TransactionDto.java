package com.app.gorworld.dto;

import com.app.gorworld.model.enums.PLAN;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {
    String tranId;

    String tranStatus;

    String mobileNumber;

    String plan;
}
