create table BOOKING  (
    BOOKING_ID	NUMBER(22) not null,
    BRANCH VARCHAR2(100) not null,
    LOCATION VARCHAR2(50) not null,
    STATUS VARCHAR2(100),
    DOCUMENT_NAME VARCHAR2(100),
    DOCUMENT_URL VARCHAR2(100),
    CASE_ID NUMBER(22),
    CREATION_DATE	DATE,
    DISABLE_BY	VARCHAR2(20),
    DISABLE_DATE	DATE,
    LAST_UPDATED_BY	VARCHAR2(20),
    LAST_UPDATE_DATE	DATE,
    IS_DELETED VARCHAR2(1) not null,
    primary key (BOOKING_ID),
    CONSTRAINT Case_Booking_FK FOREIGN KEY (CASE_ID) REFERENCES CASE(CASE_ID)
)