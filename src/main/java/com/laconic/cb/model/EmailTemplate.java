package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

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
}

