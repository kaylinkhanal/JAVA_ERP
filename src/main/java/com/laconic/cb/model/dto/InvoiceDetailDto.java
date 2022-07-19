package com.laconic.cb.model.dto;

import lombok.Data;

@Data
public class InvoiceDetailDto {
    private Long invoiceDetailId;
    private String itemName;
    private Long item;
    private Double itemAmount;
    private Double installmentAmount;
    private String installmentName;
    private Long installment;
    private Double depositAmount;
    private String depositName;
    private Long deposit;
    private Long invoiceId;
}
