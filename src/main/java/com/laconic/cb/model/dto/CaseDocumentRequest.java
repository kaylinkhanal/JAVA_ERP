package com.laconic.cb.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CaseDocumentRequest {
    private String documentName;
    private MultipartFile multipartFile;
    private Long caseId;
}
