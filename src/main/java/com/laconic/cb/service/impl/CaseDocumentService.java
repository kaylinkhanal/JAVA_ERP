package com.laconic.cb.service.impl;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.CaseDocument;
import com.laconic.cb.model.dto.CaseDocumentRequest;
import com.laconic.cb.repository.ICaseDocumentRepository;
import com.laconic.cb.service.ICaseDocumentService;
import com.laconic.cb.service.ICaseService;
import liquibase.util.file.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class CaseDocumentService implements ICaseDocumentService {

    @Value("${server.file.basepath}")
    String filePath;

    private final ICaseService caseService;
    private final ICaseDocumentRepository caseDocumentRepository;

    public CaseDocumentService(ICaseService caseService, ICaseDocumentRepository caseDocumentRepository) {
        this.caseService = caseService;
        this.caseDocumentRepository = caseDocumentRepository;
    }

    @Override
    public Case uploadCaseDocument(CaseDocumentRequest request) throws Exception {
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString()+"."+ FilenameUtils.getExtension(request.getMultipartFile().getOriginalFilename());
        createFile(filePath+"/temp/"+request.getCaseId()+"/", fileName, request.getMultipartFile());
        Case caseDto = caseService.findById(request.getCaseId()).get();
        CaseDocument caseDocument = CaseDocument.builder()
                .caseDocumentId(request.getCaseId())
                .caseId(caseDto.getCaseId())
                .documentName(request.getDocumentName())
                .documentUrl(filePath.concat("/temp/"+request.getCaseId().toString()+"/"+ fileName))
                .build();
        saveDocument(caseDocument);
        return caseDto;
    }


    private void deleteCaseDocument(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
        }
    }

    @Override
    public Case deleteCaseDocument(Long caseId, Long documentId) {
        CaseDocument caseDocument = caseDocumentRepository.findByCaseIdAndCaseDocumentId(caseId, documentId);
        if (caseDocument != null) {
            caseDocumentRepository.delete(caseDocument);
            deleteCaseDocument(caseDocument.getDocumentUrl());
        }
        return caseService.findById(caseId).get();
    }

    @Override
    public CaseDocument saveDocument(CaseDocument caseDocument) {
        return caseDocumentRepository.save(caseDocument);
    }

    private void createFile(String path, String fileName, MultipartFile multipartFile) throws Exception {
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(path + fileName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(f);) {
            fileOutputStream.write(multipartFile.getBytes());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No file");
        }
    }
}
