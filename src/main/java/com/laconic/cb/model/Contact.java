package com.laconic.cb.model;

import com.laconic.cb.enums.AddressType;
import com.laconic.cb.enums.Relationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CONTACT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID")
    private Long contactId;
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "CONTACT_CODE")
    private String contactCode;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CON_STATUS")
    private String conStatus;
    @Column(name = "CUSTOMER_CODE")
    private String customerCode;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "DECISION_MAKER")
    private String decisionMaker;
    @Column(name = "DEP")
    private String dep;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
//    @Column(name = "DISABLE_BY")
//    private String disableBy;
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
    @Column(name = "SITE_CODE")
    private String siteCode;
    @OneToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;
    @Column(name = "TITLE")
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "ADDRESS_TYPE")
    private AddressType addressType;
    @Enumerated(EnumType.STRING)
    @Column(name = "RELATIONSHIP")
    private Relationship relationship;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
