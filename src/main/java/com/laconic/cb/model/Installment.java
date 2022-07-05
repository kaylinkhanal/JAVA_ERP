package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laconic.cb.model.BaseEntity;
import com.laconic.cb.model.Case;
import com.laconic.cb.model.Currency;
import com.laconic.cb.model.InvoiceDetail;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "INSTALLMENT")
@AllArgsConstructor
@NoArgsConstructor
public class Installment extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Installment_SEQ_GEN", sequenceName = "Installment_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Installment_SEQ_GEN")
    @Column(name = "INSTALLMENT_ID")
    private Long installmentId;
    @Column(name = "INSTALLMENT_NUMBER")
    private String installmentNumber;
    @Column(name = "INSTALLMENT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date installmentDate;
    @Column(name = "SEQUENCE")
    private String sequence;
    @Column(name = "CASE_REMARK")
    private String caseRemark;
    @Column(name = "REJECT_REMARK")
    private String rejectRemark;
    @Column(name = "INSTALLMENT_TITLE")
    private String installmentTitle;
    @Column(name = "VAT")
    private String vat;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @OneToOne
    @JoinColumn(name = "CASE_ID")
    private Case caseDto;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "installment")
    @JsonIgnore
    private List<InstallmentDetail> installmentDetails;
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
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}