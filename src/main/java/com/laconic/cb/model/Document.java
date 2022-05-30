package com.laconic.cb.model;

import com.laconic.cb.model.BaseEntity;
import com.laconic.cb.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOCUMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
    @OneToOne
    @JoinColumn(name = "DOCUMENT_TYPE_ID")
    private DocumentType documentType;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "document_no_sequence", sequenceName= "document_no_sequence",
            initialValue = 0001, allocationSize = 10)
    private Long documentNo;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
