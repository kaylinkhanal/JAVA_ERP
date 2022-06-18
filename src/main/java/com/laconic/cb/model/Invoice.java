package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @Column(name = "VAT")
    private String vat;
    @OneToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
    @OneToOne
    @JoinColumn(name = "CASE_ID")
    private Case caseDto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    @JsonIgnore
    private List<InvoiceDetail> invoiceDetails;
    @Column(name = "EXCHANGE_RATE")
    private Double exchangeRate;
    @Column(name = "PAYMENT_TERM")
    private String paymentTerm;
    @Column(name = "BANK_ACCOUNT")
    private String bankAccount;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
