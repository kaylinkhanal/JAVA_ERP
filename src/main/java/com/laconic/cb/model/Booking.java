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
public class Booking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_ID")
    private Long bookingId;
    @Column(name = "BRANCH")
    private String branch;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NUMBER")
    private Integer number;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CASE_ID", nullable = false)
    private Case caseDto;
    @Transient
    private MultipartFile multipartFile;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
//    @OneToMany
//    @NotFound(action = NotFoundAction.EXCEPTION)
//    @JoinColumn(name = "BOOKING_ID",
//            referencedColumnName = "BOOKING_ID",
//            insertable = false, updatable = false,
//            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private List<BookingDocument> bookingDocuments = new ArrayList<>();
}
