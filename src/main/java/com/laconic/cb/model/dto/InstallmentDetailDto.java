package com.laconic.cb.model.dto;

import lombok.Data;

@Data
public class InstallmentDetailDto {
    private Long installmentDetailId;
    private String itemName;
    private Long item;
    private Double itemAmount;
    private Long installmentId;
}
