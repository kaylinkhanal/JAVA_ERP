package com.laconic.cb.utils;

import com.laconic.cb.model.dto.DocumentAttributes;

public class ParseDocument {

    public static String getParsedDocument(String content, DocumentAttributes documentAttributes) {
        if (content != null) {
            if (content.contains("@ExecutorName")) {
                content = content.replace("@ExecutorName", documentAttributes.getExecutorName());
            }
            if (content.contains("@Nationality")) {
                content = content.replace("@Nationality", documentAttributes.getNationality());
            }
            if (content.contains("@ContactNumber")) {
                content = content.replace("@ContactNumber", documentAttributes.getContactNumber());
            }
            if (content.contains("@DOB")) {
                content = content.replace("@DOB", documentAttributes.getDateOfBirth());
            }
            if (content.contains("@EffectiveDateTo")) {
                content = content.replace("@EffectiveDate", documentAttributes.getEffectiveDateTo() != null ? documentAttributes.getEffectiveDateTo() : "");
            }
            if (content.contains("@EffectiveDateFrom")) {
                content = content.replace("@EffectiveDate", documentAttributes.getEffectiveDateFrom() != null ? documentAttributes.getEffectiveDateFrom() : "");
            }
            if (content.contains("@Address")) {
                content = content.replace("@Address", documentAttributes.getAddress());
            }
        }
        return content;
    }

    public static String getBlankDocument(String content) {
        if (content != null) {
            if (content.contains("@ExecutorName")) {
                content = content.replace("@ExecutorName", ".............................");
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
