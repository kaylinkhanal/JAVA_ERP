package com.laconic.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.laconic.cb.enums.AddressType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @Id
    @SequenceGenerator(name = "Address_SEQ_GEN", sequenceName = "Address_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Address_SEQ_GEN")
    @Column(name = "ADDRESS_ID")
    private Long addressId;
    @Column(name = "ADDRESS_TYPE")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    @Column(name = "ADDRESS_NO")
    private String addressNo;
    @Column(name = "PHONE1")
    private String phone1;
    @Column(name = "PHONE2")
    private String phone2;
    @Column(name = "FAX")
    private String fax;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
