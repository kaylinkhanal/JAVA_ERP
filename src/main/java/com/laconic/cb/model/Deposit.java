package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laconic.cb.model.dto.DepositDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "DEPOSIT")
@AllArgsConstructor
@NoArgsConstructor
public class Deposit extends BaseEntity {
    @Id
    @SequenceGenerator(name = "deposit_SEQ_GEN", sequenceName = "Deposit_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Deposit_SEQ_GEN")
    @Column(name = "DEPOSIT_ID")
    private Long depositId;
    @Column(name = "DEPOSIT_NUMBER")
    private String depositNumber;
    @Column(name = "DEPOSIT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date depositDate;
    @Column(name = "SEQUENCE")
    private String sequence;
    @Column(name = "CASE_REMARK")
    private String caseRemark;
    @Column(name = "REJECT_REMARK")
    private String rejectRemark;
    @Column(name = "DEPOSIT_TITLE")
    private String depositTitle;
    @Column(name = "VAT")
    private String vat;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "CASE_ID")
    private Case caseDto;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToMany(mappedBy = "deposit")
    @JsonIgnore
    private List<DepositDetail> depositDetails;
    @Column(name = "EXCHANGE_RATE")
    private Double exchangeRate;
    @Column(name = "PAYMENT_TERM")
    private String paymentTerm;
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Column(name = "NON_VAT")
    private Double nonVat;
    @Column(name = "SUBTOTAL_VAT")
    private Double subtotalVat;
    @Column(name = "SUBTOTAL_AMOUNT")
    private Double subtotalAmount;
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;

    public Deposit(DepositDto dto) {
        this.setDepositId(dto.getDepositId());
        this.setDepositNumber(dto.getDepositNumber());
        this.setDepositDate(dto.getDepositDate());
        this.setSequence(dto.getSequence());
        this.setCaseRemark(dto.getCaseRemark());
        this.setRejectRemark(dto.getRejectRemark());
        this.setDepositTitle(dto.getDepositTitle());
        this.setVat(dto.getVat());
        this.setExchangeRate(dto.getExchangeRate());
        this.setPaymentTerm(dto.getPaymentTerm());
        this.setBankAccount(dto.getBankAccount());
        this.setNonVat(dto.getNonVat());
        this.setSubtotalAmount(dto.getSubtotalAmount());
        this.setAmount(dto.getAmount());
        this.setSubtotalVat(dto.getSubtotalVat());

    }
}