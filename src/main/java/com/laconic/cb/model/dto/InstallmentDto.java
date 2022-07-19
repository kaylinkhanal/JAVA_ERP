package com.laconic.cb.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InstallmentDto {
    private Long installmentId;
    private String installmentNumber;
    private Date installmentDate;
    private String sequence;
    private String caseRemark;
    private String rejectRemark;
    private String installmentTitle;
    private String vat;
    private Long currency;
    private Double exchangeRate;
    private String paymentTerm;
    private String bankAccount;
    private Double nonVat;
    private Double subtotalVat;
    private Double subtotalAmount;
    private Long customer;
    private Long caseDto;
    private List<InstallmentDetailDto> dtoList;
}
