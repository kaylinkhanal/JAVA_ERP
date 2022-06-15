package com.laconic.cb.model;

import com.laconic.cb.enums.CaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CASE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CASE_ID")
    private Long caseId;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @Column(name = "OPERATING_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatingDate;
    @Column(name = "PROPOSAL_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date proposalDate;
    @Column(name = "ACCEPTANCE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date AcceptanceDate;
    @Column(name = "VALIDATION_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validationDate;
    @Column(name = "DISCARD_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date discardDate;
    @Column(name = "CLOSING_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date closingDate;
    @Column(name = "SUSPENSE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date suspenseDate;
    @OneToOne
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPerson;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
