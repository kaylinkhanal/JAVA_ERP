package com.laconic.cb.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentAttributes {
    private String executorName;
    private String nationality;
    private String contactNumber;
    private String dateOfBirth;
    private Long documentId;
    private String passportNumber;
    private String effectiveDateFrom;
    private String effectiveDateTo;
    private String address;
    private String email;
    private Long caseId;
}
