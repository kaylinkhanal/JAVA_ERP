package com.laconic.cb.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass //Not a JPA Entity
//Configure JPA entity listener to capture auditing information on persisting and updating entities
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {
    @Column(name = "CREATED_BY")
    @CreatedBy
    private String createdBy;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;

    @LastModifiedBy
    @Column(name = "DISABLE_BY")
    private String disableBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "DISABLE_DATE")
    private Date disableDate;

    @LastModifiedBy
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;
}
