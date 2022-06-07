package com.laconic.cb.model;

import com.laconic.cb.enums.CaseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Date operatingDate;
    @Column(name = "PROPOSAL_DATE")
    private Date proposalDate;
    @Column(name = "ACCEPTANCE_DATE")
    private Date AcceptanceDate;
    @Column(name = "VALIDATION_DATE")
    private Date validationDate;
    @Column(name = "DISCARD_DATE")
    private Date discardDate;
    @Column(name = "CLOSING_DATE")
    private Date closingDate;
    @Column(name = "SUSPENSE_DATE")
    private Date suspenseDate;
    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private ContactPerson contactPerson;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
