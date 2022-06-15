package com.laconic.cb.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private Long customerId;
    private String type;
    private String customerName;
    private String address;
    private String contactPerson;
    private String idPassportNo;
    private String gender;
}
