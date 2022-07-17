package com.laconic.cb.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EMAIL_TEMPLATE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailTemplate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TEMPLATE_ID")
    private Long templateId;
    @Column(name = "TEMPLATE_NAME")
    private String templateName;
    @Column(name = "MANAGE")
    private String manage;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
    @Transient
    private MultipartFile attachImage;
}

