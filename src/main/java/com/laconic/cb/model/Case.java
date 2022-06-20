package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.laconic.cb.enums.CaseStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CASE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Case extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Case_SEQ_GEN", sequenceName = "Case_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Case_SEQ_GEN")
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
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
