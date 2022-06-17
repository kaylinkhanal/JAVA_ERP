package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SITE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Site extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Site_SEQ_GEN", sequenceName = "Site_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Site_SEQ_GEN")
    @Column(name = "SITE_ID")
    private Long siteId;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "BRANCH_NO")
    private String branchNo;
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "COUNTRY_ID")
    private Long CountryId;
    @Column(name = "CUSTOMER_CODE")
    private String customerCode;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;
    @Column(name = "DISTRICT")
    private String district;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "MAIN_OFFICE")
    private String mainOffice;
    @Column(name = "PHONE1")
    private String phone1;
    @Column(name = "PHONE2")
    private String phone2;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "REMARK_LCN")
    private String remarkLcn;
    @Column(name = "ROW_NUMBER")
    private Long rowNumber;
    @Column(name = "SITE_CODE")
    private String siteCode;
    @Column(name = "SITE_NAME")
    private String siteName;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "SUB_DISTRICT")
    private String subDistrict;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
