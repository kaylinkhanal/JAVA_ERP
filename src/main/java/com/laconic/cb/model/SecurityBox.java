package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "SECURITY_BOX")
@AllArgsConstructor
@NoArgsConstructor
public class SecurityBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SECURITY_BOX_ID")
    private Long securityBoxId;
    @Column(name = "SECURITY_DEPOSIT")
    private Double securityDeposit;
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Column(name = "LOCKER_SIZE")
    private String lockerSize;
    @Column(name = "LOCKER_TYPE")
    private String lockerType;
    @Column(name = "SECURITY_BOX_NUMBER")
    private Integer securityBoxNumber;
}
