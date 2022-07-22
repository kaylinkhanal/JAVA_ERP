package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COMPANY_FINANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyFinance extends  BaseEntity {
    @Id
    @SequenceGenerator(name = "CompanyFinance_SEQ_GEN", sequenceName = "CompanyFinance_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CompanyFinance_SEQ_GEN")
    @Column(name = "FINANCE_ID")
    private Long financeId;
    @Column(name = "AVERAGE_LIMIT")
    private String averageLimit;
    @Column(name = "PAYMENT_TERM")
    private String paymentTerm;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
