package com.laconic.cb.utils;

public class ParseEmail {

    public static String getEmailTemplate(String content) {
        if (content != null) {
            if (content.contains("@CustomerName")) {
                content = content.replace("@CustomerName", ".............................");
            }
        }
        return content;
    }
}
