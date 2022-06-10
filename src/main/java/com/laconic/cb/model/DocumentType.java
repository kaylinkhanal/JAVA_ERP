package com.laconic.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DOCUMENT_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DOCUMENT_TYPE_ID")
    private Long documentTypeId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DOCUMENT_TYPE_NAME")
    private String documentTypeName;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
