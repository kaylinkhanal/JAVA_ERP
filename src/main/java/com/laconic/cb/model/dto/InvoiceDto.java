package com.laconic.cb.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceDto {
    private Long invoiceId;
    private String invoiceNumber;
    private Date invoiceDate;
    private String re;
    private String caseRemark;
    private String rejectRemark;
    private String invoiceTitle;
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
    private String description;
    private Double amount;
    private List<InvoiceDetailDto> dtoList;
}
