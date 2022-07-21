package com.laconic.cb.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Table(name = "BOOKING_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_DETAIL_ID")
    private Long bookingDetailId;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "BOOKING_SIZE")
    private String size;
    @Column(name = "BOOKING_TYPE")
    private String type;
    @Column(name = "BOOKING_NUMBER")
    private Integer bookingNumber;
    @Column(name = "BOOKING_ID")
    private Long bookingId;
    @Column(name = "IS_DELETED")
    private Boolean isDeleted = false;
}
