package com.laconic.cb.model;

import com.laconic.cb.enums.AddressType;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
