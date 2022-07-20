package com.laconic.cb.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING_DOCUMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_DOCUMENT_ID")
    private Long bookingDocumentId;
    @Column(name = "BOOKING_ID")
    private Long bookingId;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
    @Column(name = "DOCUMENT_URL")
    private String documentUrl;
}
