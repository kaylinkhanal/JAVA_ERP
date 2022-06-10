package com.laconic.cb.model;

import com.laconic.cb.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CODE")
    private Long code;
    @Column(name = "CONTACT_NO")
    private String contactNo;
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "ID_PASSPORT_NO")
    private String idPassportNo;
    @Column(name = "REGISTER_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;

//    @Column(name = "ACCOUNTING_DONATION_ID")
//    private Long accountingDonationId;
//    @Column(name = "ACCOUNTING_RECEIVABLE_ID")
//    private Long accountingReceivableId;
//    @Column(name = "ACCOUNT_ID")
//    private Long accountId;
//    @Column(name = "ACCOUNT_NUMBER")
//    private String accountNumber;
//    @Column(name = "ADDRESS", columnDefinition = "TEXT")
//    private String address;
//    @Column(name = "AGENT_FLAG")
//    private String agentFlag;
//    @Column(name = "AGREED_DISCOUNT")
//    private String agreed_discount;
//    @Column(name = "AREA")
//    private Long area;
//    @Column(name = "AREA_ID")
//    private Long areaId;
//    @Column(name = "AVG_CREDIT_LINE")
//    private Long avgCreditLine;
//    @Column(name = "AVG_FLAG")
//    private String avgFlag;
//    @Column(name = "BANK_NAME")
//    private String bankName;
//    @Column(name = "BILLING_CONDITION")
//    private String billingCondition;
//    @Column(name = "BILL_ITEM_TYPE_A")
//    private String billItemTypeA;
//    @Column(name = "BILL_ITEM_TYPE_B")
//    private String billItemTypeB;
//    @Column(name = "BUSINESS")
//    private String business;
//    @Column(name = "CAPACITY")
//    private Long capacity;
//    @Column(name = "COMPANY_FALG_TYPE")
//    private String companyFalgType;
//    @Column(name = "COMPANY_ID")
//    private Long companyId;
//    @Column(name = "COUNTRY_ID")
//    private Long countryId;
//    @Column(name = "CREATE_BY")
//    private String createBy;
//    @Column(name = "CURRENCY")
//    private String currency;
//    @Column(name = "CURRENCY_ID")
//    private Long currencyId;
//    @Column(name = "CURRENCY_RATE")
//    private Long currencyRate;
//    @Column(name = "CUSTOMER_CODE")
//    private String customerCode;
//    @Column(name = "CUSTOMER_FLAG")
//    private String customerFlag;
//    @Column(name = "CUSTOMER_GROUP")
//    private String customerGroup;
//    @Column(name = "CUSTOMER_GROUP_ID")
//    private Long customerGroupId;
//    @Column(name = "FIRSTNAME")
//    private String firstName;
//    @Column(name = "LASTNAME")
//    private String lastName;
//    @Column(name = "BIRTH")
//    private Date birth;
//    @Column(name = "GENDER")
//    private String gender;
//    @Column(name = "IDCARD_PASSPORT")
//    private String idCardPassport;
//    @Column(name = "CUSTOMER_REMARK")
//    private String customerRemark;
//    @Column(name = "CUSTOMER_TYPE")
//    private String customerType;
//    @Column(name = "DELIVERY_TERM_ID")
//    private Long deliveryTermId;
//    @Column(name = "DESCRIPTION")
//    private String description;
//    @Column(name = "DIRECTOR_NAME")
//    private String directorName;
//    @Column(name = "DONATION_FLAG")
//    private String donationFlag;
//    @Column(name = "EMPLOYEES")
//    private Long employees;
//    @Column(name = "EMPLOYER")
//    private String employer;
//    @Column(name = "EPN_SET_ID")
//    private Long epnSetId;
//    @Column(name = "ESTABLISHED_YEAR")
//    private Long establishedYear;
//    @Column(name = "FACTORY_ID")
//    private Long factoryId;
//    @Column(name = "FAX_1")
//    private String fax1;
//    @Column(name = "FAX_2")
//    private String fax2;
//    @Column(name = "FAX_3")
//    private String fax3;
//    @Column(name = "GRADING")
//    private String grading;
//    @Column(name = "INTERNAL_USER_FLAG")
//    private String internalUsedFlag;
//    @Column(name = "IRM_DATE_IN")
//    private Date irmDateIn;
//    @Column(name = "IRM_LEASE_NO")
//    private String irmLeaseNo;
//    @Column(name = "IRM_METER_ELEC")
//    private String irmMeterElec;
//    @Column(name = "IRM_METER_WATER")
//    private String irmMeterWater;
//    @Column(name = "IRM_STATUS")
//    private String irmStatus;
//    @Column(name = "IRM_TRANSFER_DATE")
//    private Date irmTransferDate;
//    @Column(name = "LCN_DB_LINK")
//    private String LcnDbLink;
//    @Column(name = "MAJOR_EQUIPMENT")
//    private String majorEquipment;
//    @Column(name = "MAJOR_MATERIAL_QUOTATION_TYPE")
//    private Long majorMaterialQuotationType;
//    @Column(name = "MARKET_SEGMENT")
//    private String marketSegment;
//    @Column(name = "OLD_CUSTOMER_CODE")
//    private String oldCustomerCode;
//    @Column(name = "OWNERSHIP_RATIO")
//    private Long ownershipRatio;
//    @Column(name = "PAID_CAPITAL")
//    private Long paidCapital;
//    @Column(name = "PAYMENT_CODE")
//    private String paymentCode;
//    @Column(name = "PERSONEL_FALG_TYPE")
//    private String personelFalgType;
//    @Column(name = "PUR_VAT_ACCOUNT_ID")
//    private Long purVatAccountId;
//    @Column(name = "QA_LEVEL")
//    private Long qaLevel;
//    @Column(name = "QUALITY")
//    private Long quality;
//    @Column(name = "REGISTER_CAPITAL")
//    private Long registerCapital;
//    @Column(name = "REMARK_LCN")
//    private String remarkLCN;
//    @Column(name = "REPORT_ENABLED_FLAG")
//    private String reportEnabledFlag;
//    @Column(name = "ROW_NUMBER")
//    private Long rowNumber;
//    @Column(name = "SALE_AREA_ID")
//    private Long saLeAreaId;
//    @Column(name = "SET_SELLING_ID")
//    private Long setSellingId;
//    @Column(name = "STATUS")
//    private String status;
//    @Column(name = "SUBSIDARIES")
//    private String subsidaries;
//    @Column(name = "SUP_VAT_ACCOUNT_ID")
//    private Long supVatAccountId;
//    @Column(name = "TAX_TYPE_ID")
//    private Long taxTypeId;
//    @Column(name = "TAX_NO")
//    private String taxNo;
//    @Column(name = "TEL_1")
//    private String tel1;
//    @Column(name = "TEL_2")
//    private String tel2;
//    @Column(name = "TEL_3")
//    private String tel3;
//    @Column(name = "TRANDING_PARTNER_TYPE_ID")
//    private Long trandingPartnerTypeId;
//    @Column(name = "TURNOVER")
//    private Long turnover;
//    @Column(name = "UPDATED_BY")
//    private String updated_by;
//    @Column(name = "UPDATED_DATE")
//    private Date updatedDate;
//    @Column(name = "WEBSITE")
//    private String website;
}
