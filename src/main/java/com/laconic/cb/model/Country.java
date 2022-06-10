package com.laconic.cb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "COUNTRY_ID")
    private Long countryId;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
}
