create table BOOKING_DETAIL  (
    BOOKING_DETAIL_ID	NUMBER(22) not null,
    BOOKING_SIZE VARCHAR2(100),
    BOOKING_TYPE VARCHAR2(100),
    BOOKING_NUMBER NUMBER,
    BOOKING_ID NUMBER(22),
    STATUS VARCHAR2(100),
    CREATION_DATE	DATE,
    DISABLE_BY	VARCHAR2(20),
    DISABLE_DATE	DATE,
    LAST_UPDATED_BY	VARCHAR2(20),
    LAST_UPDATE_DATE	DATE,
    IS_DELETED VARCHAR2(1) not null,
    primary key (BOOKING_DETAIL_ID),
    CONSTRAINT Booking_BookingDetail_FK FOREIGN KEY (BOOKING_ID) REFERENCES BOOKING(BOOKING_ID)
)