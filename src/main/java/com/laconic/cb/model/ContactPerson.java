package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.laconic.cb.enums.AddressType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTACT_PERSON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactPerson extends BaseEntity {
    @Id
    @SequenceGenerator(name = "ContactPerson_SEQ_GEN", sequenceName = "ContactPerson_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContactPerson_SEQ_GEN")
    @Column(name = "CONTACT_PERSON_ID")
    private Long contactPersonId;
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "CONTACT_CODE")
    private String contactCode;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CON_STATUS")
    private String conStatus;
//    @Column(name = "CUSTOMER_ID", unique = true, updatable = false, nullable = false)
//    private Long customerId;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;
    @Column(name = "DECISION_MAKER")
    private String decisionMaker;
    @Column(name = "DEP")
    private String dep;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "EXT")
    private String ext;
    @Column(name = "FLAG")
    private String flag;
    @Column(name = "FOR_B2B_FLAG")
    private String forB2BFlag;
    @Column(name = "FOR_SALE_FLAG")
    private String forSaleFlag;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "REMARK_LCN")
    private String remarkLcn;
    @Column(name = "ROW_NUMBER")
    private Long rowNumber;
    @OneToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;
    @Column(name = "TITLE")
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "ADDRESS_TYPE")
    private AddressType addressType;
    @Column(name = "RELATIONSHIP")
    private String relationship;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
