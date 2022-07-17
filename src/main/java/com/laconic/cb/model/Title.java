package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TITLE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Title extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TITLE_ID")
    private Long titleId;
    @Column(name = "CASE_TYPE_NAME")
    private String caseTypeName;
    @Column(name = "CASE_TYPE_CODE")
    private String caseTypeCode;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "PRICE")
    private String price;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
    @Column(name = "DISABLE_BY")
    private String disableBy;
    @Column(name = "DISABLE_DATE")
    private Date disableDate;
}
