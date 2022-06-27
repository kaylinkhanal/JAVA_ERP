package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "INSTALLMENT_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class InstallmentDetail extends BaseEntity {
    @Id
    @SequenceGenerator(name = "InstallmentDetail_SEQ_GEN", sequenceName = "InstallmentDetail_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InstallmentDetail_SEQ_GEN")
    @Column(name = "INSTALLMENT_DETAIL_ID")
    private Long installmentDetailId;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "INSTALLMENT_ID", nullable = false)
    private Installment installment;
    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}
