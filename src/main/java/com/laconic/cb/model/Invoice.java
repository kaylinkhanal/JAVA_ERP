package com.laconic.cb.model;

import com.laconic.cb.model.dto.InvoiceDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "INVOICE")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Invoice_SEQ_GEN", sequenceName = "Invoice_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Invoice_SEQ_GEN")
    @Column(name = "INVOICE_ID")
    private Long invoiceId;
    @Column(name = "RE")
    private String re;
    @Column(name = "CASE_REMARK")
    private String caseRemark;
    @Column(name = "REJECT_REMARK")
    private String rejectRemark;
    @Column(name = "INVOICE_TITLE")
    private String invoiceTitle;
    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;
    @Column(name = "INVOICE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;
    @Column(name = "VAT")
    private String vat;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CASE_ID", nullable = false)
    private Case caseDto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails;
    @Column(name = "EXCHANGE_RATE")
    private Double exchangeRate;
    @Column(name = "PAYMENT_TERM")
    private String paymentTerm;
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
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

    public Invoice(InvoiceDto dto) {
        this.setInvoiceId(dto.getInvoiceId());
        this.setInvoiceNumber(dto.getInvoiceNumber());
        this.setInvoiceDate(dto.getInvoiceDate());
        this.setRe(dto.getRe());
        this.setCaseRemark(dto.getCaseRemark());
        this.setRejectRemark(dto.getRejectRemark());
        this.setInvoiceTitle(dto.getInvoiceTitle());
        this.setVat(dto.getVat());
        this.setExchangeRate(dto.getExchangeRate());
        this.setPaymentTerm(dto.getPaymentTerm());
        this.setBankAccount(dto.getBankAccount());
        this.setNonVat(dto.getNonVat());
        this.setSubtotalAmount(dto.getSubtotalAmount());
        this.setDescription(dto.getDescription());
        this.setAmount(dto.getAmount());
    }
}
