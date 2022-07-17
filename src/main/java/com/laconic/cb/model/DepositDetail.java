package com.laconic.cb.model;

import com.laconic.cb.model.dto.DepositDetailDto;
import lombok.*;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "DEPOSIT_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class DepositDetail extends BaseEntity {
    @Id
    @SequenceGenerator(name = "DepositDetail_SEQ_GEN", sequenceName = "DepositDetail_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DepositDetail_SEQ_GEN")
    @Column(name = "DEPOSIT_DETAIL_ID")
    private Long depositDetailId;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "DEPOSIT_ID", nullable = false)
    private Deposit deposit;
    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    @Column(name = "ITEM_AMOUNT")
    private Double itemAmount;

    public DepositDetail(DepositDetailDto dto) {
        this.setDepositDetailId(dto.getDepositDetailId());
        this.setItemAmount(dto.getItemAmount());
    }
}