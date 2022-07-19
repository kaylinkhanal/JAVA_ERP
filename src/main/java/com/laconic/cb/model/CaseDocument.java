package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CASE_DOCUMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaseDocument extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CASE_DOCUMENT_ID")
    private Long caseDocumentId;
    @Column(name = "CASE_ID")
    private Long caseId;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
    @Column(name = "DOCUMENT_URL")
    private String documentUrl;
}
