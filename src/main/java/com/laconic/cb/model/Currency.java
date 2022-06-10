package com.laconic.cb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY")
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CURRENCY_ID")
    private Long currencyId;
    @Column(name = "CURRENCY_NAME")
    private String currencyName;
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
}
