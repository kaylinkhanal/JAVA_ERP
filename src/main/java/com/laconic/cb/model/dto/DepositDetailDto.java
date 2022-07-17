package com.laconic.cb.model.dto;

import lombok.Data;

@Data
public class DepositDetailDto {
    private String itemName;
    private Long item;
    private Double itemAmount;
}
