package com.laconic.cb.model;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "BOOKING")
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_ID")
    private Long bookingId;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
    @Column(name = "DOCUMENT_URL")
    private String documentUrl;
    @Transient
    private MultipartFile document;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "CASE_ID", nullable = false)
    @Column(name = "CASE_ID")
    private Long caseId;
    @OneToMany
    @NotFound(action = NotFoundAction.EXCEPTION)
    @JoinColumn(name = "BOOKING_ID",
            referencedColumnName = "BOOKING_ID",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private List<BookingDetail> bookingDetails = new ArrayList<>();
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
