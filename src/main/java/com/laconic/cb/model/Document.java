package com.laconic.cb.model;

import com.laconic.cb.model.BaseEntity;
import com.laconic.cb.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
    @Generated(GenerationTime.INSERT)
    @SequenceGenerator(name = "document_no_seq_gen", sequenceName = "document_no_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_no_seq_gen")
    @Column(name = "DOCUMENT_NO", insertable = false, columnDefinition = "serial")
    private Long documentNo;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;
    @Column(name = "PRINTING_FORMAT")
    private String printingFormat;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
