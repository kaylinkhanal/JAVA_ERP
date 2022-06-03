package com.laconic.cb.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;


public class EmailSender {

    private final JavaMailSender javaMailSender;

    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

//    public void sendEmail(String sendTo, String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(sendTo);
//        message.setText(content);
//        message.setSubject(subject);
//        message.setFrom("mandeepdhakal11@gmail.com");
//        message.setSentDate(new Date());
//        message.setReplyTo("mandeepdhakal11@gmail.com");
//        javaMailSender.send(message);
//    }
}
