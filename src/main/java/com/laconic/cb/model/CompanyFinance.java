package com.laconic.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "COMPANY_FINANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyFinance extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
