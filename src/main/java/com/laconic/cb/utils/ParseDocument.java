package com.laconic.cb.utils;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.Document;
import com.laconic.cb.model.dto.DocumentAttributes;

import java.util.Date;
import java.util.Optional;

public class ParseDocument {

    public static String getParsedDocument(String content, Optional<Case> caseDto, Optional<Document> document) {
        if (document.isPresent() && caseDto.isPresent()) {
            Case dbCase = caseDto.get();
            String nationality = (dbCase.getCustomer().getAddress().size() > 0 ?
                    dbCase.getCustomer().getAddress().get(0).getCountry().getCountryName() :
                    (dbCase.getCustomer().getSite().size() > 0 ?
                            dbCase.getCustomer().getSite().get(0).getCountry().getCountryName() : "" ));
            String address = (dbCase.getCustomer().getAddress().size() > 0 ?
                    dbCase.getCustomer().getAddress().get(0).getAddressNo() :
                    (dbCase.getCustomer().getSite().size() > 0 ?
                            dbCase.getCustomer().getSite().get(0).getAddress() : "" ));
            String fullName = dbCase.getCustomer().getFullName() != null ? dbCase.getCustomer().getFullName() : dbCase.getCustomer().getCompanyName();
            String contactNo = (dbCase.getCustomer().getContactNo() != null ?
                    dbCase.getCustomer().getContactNo() :
                    (dbCase.getCustomer().getSite().size() > 0 ?
                            dbCase.getCustomer().getSite().get(0).getPhone1() : "" ));
            String passportNumber = dbCase.getCustomer().getIdPassportNo() != null ? dbCase.getCustomer().getIdPassportNo() : dbCase.getCustomer().getTaxId();;
            String dateOfBirth = dbCase.getCustomer().getDateOfBirth() != null ? dbCase.getCustomer().getDateOfBirth().toString() : dbCase.getCustomer().getRegisterDate().toString();
            String email = dbCase.getCustomer().getEmail() != null ? dbCase.getCustomer().getEmail() : dbCase.getCustomer().getWebsite();;
            if (document.get().getContent() != null) {
                if (content != null) {
                    if (content.contains("@ExecutorName")) {
                        content = content.replace("@ExecutorName", fullName);
                    }
                    if (content.contains("@Email")) {
                        content = content.replace("@Email", email);
                    }
                    if (content.contains("@PassportNumber")) {
                        content = content.replace("@PassportNumber", passportNumber);
                    }
                    if (content.contains("@Nationality")) {
                        content = content.replace("@Nationality", nationality);
                    }
                    if (content.contains("@ContactNumber")) {
                        content = content.replace("@ContactNumber", contactNo);
                    }
                    if (content.contains("@DOB")) {
                        content = content.replace("@DOB", dateOfBirth);
                    }
                    if (content.contains("@EffectiveDateTo")) {
                        content = content.replace("@EffectiveDate", new Date().toString());
                    }
                    if (content.contains("@EffectiveDateFrom")) {
                        content = content.replace("@EffectiveDate", new Date().toString());
                    }
                    if (content.contains("@Address")) {
                        content = content.replace("@Address", address);
                    }
                }
            }
        }
        return content;
    }

    public static String getBlankDocument(String content) {
        if (content != null) {
            if (content.contains("@ExecutorName")) {
                content = content.replace("@ExecutorName", ".............................");
            }
            if (content.contains("@Email")) {
                content = content.replace("@Email", ".............................");
            }
            if (content.contains("@PassportNumber")) {
                content = content.replace("@PassportNumber", ".............................");
            }
            if (content.contains("@Nationality")) {
                content = content.replace("@Nationality", ".............................");
            }
            if (content.contains("@ContactNumber")) {
                content = content = content.replace("@ContactNumber", ".............................");
            }
            if (content.contains("@DOB")) {
                content = content.replace("@DOB", ".............................");
            }
            if (content.contains("@EffectiveDateTo")) {
                content = content.replace("@EffectiveDateTo", ".............................");
            }
            if (content.contains("@EffectiveDateFrom")) {
                content = content.replace("@EffectiveDateFrom", ".............................");
            }
            if (content.contains("@Address")) {
                content = content.replace("@Address", ".............................");
            }
        }
        return content;
    }
}
