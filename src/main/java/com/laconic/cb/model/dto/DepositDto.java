package com.laconic.cb.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DepositDto {
    private Long depositId;
    private String depositNumber;
    private Date depositDate;
    private String sequence;
    private String caseRemark;
    private String rejectRemark;
    private String depositTitle;
    private String vat;
    private Long currency;
    private Double exchangeRate;
    private String paymentTerm;
    private String bankAccount;
    private Double nonVat;
    private Double subtotalVat;
    private Double amount;
    private Double subtotalAmount;
    private Long customer;
    private Long caseDto;
    private List<DepositDetailDto> dtoList;
}
