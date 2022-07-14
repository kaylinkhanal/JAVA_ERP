package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "INVOICE_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail extends BaseEntity {
    @Id
    @SequenceGenerator(name = "InvoiceDetail_SEQ_GEN", sequenceName = "InvoiceDetail_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvoiceDetail_SEQ_GEN")
    @Column(name = "INVOICE_DETAIL_ID")
    private Long invoiceDetailId;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;
    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @OneToOne
    @JoinColumn(name = "INSTALLMENT_ID")
    private Installment installment;
    @Column(name = "ITEM_AMOUNT")
    private Double itemAmount;
    @Column(name = "INSTALLMENT_AMOUNT")
    private Double installmentAmount;
    @Column(name = "AMOUNT")
    private Double amount;
}
