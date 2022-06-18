package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "ITEM")
@AllArgsConstructor
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Item_SEQ_GEN", sequenceName = "Item_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Item_SEQ_GEN")
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "ITEM_PART_NAME")
    private String itemPartName;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
