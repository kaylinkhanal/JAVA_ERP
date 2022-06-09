package com.laconic.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "COMPANY")
@AllArgsConstructor
@NoArgsConstructor
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPANY_ID")
    private Long companyId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "REGISTER_DATE")
    private Date registerDate;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "TAX_ID")
    private String taxId;
    @Column(name = "BUSINESS_TYPE")
    private String businessType;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "TRADING_RELATION")
    private String tradingRelation;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
}
