package com.laconic.cb.model.dto;

import lombok.Data;

@Data
public class DocumentAttributes {
    private String executorName;
    private String nationality;
    private String contactNumber;
    private String dateOfBirth;
    private String documentType;
    private String passportNumber;
    private String effectiveDateFrom;
    private String effectiveDateTo;
    private String address;
}
