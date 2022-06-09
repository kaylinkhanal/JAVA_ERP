package com.laconic.cb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "COMPANY_CONTACT_PERSON")
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactPerson extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_PERSON_ID")
    private Long contactPersonId;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "DEP")
    private String dep;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @OneToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;
    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
