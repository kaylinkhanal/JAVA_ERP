create table ADDRESS  (
    ADDRESS_ID	NUMBER(22) not null,
    ADDRESS_TYPE	VARCHAR2(250) not null,
    ADDRESS_NO	VARCHAR2(250) not null,
    COUNTRY_ID NUMBER(22) not null,
    CUSTOMER_CODE	NUMBER(22),
    CUSTOMER_ID NUMBER(22) not null,
    PHONE1	VARCHAR2(250) not null,
    PHONE2	VARCHAR2(250),
    FAX	VARCHAR2(250),
    IS_DELETED VARCHAR2(1) not null,
    primary key (ADDRESS_ID),
    CONSTRAINT Country_Address_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY(COUNTRY_ID),
    CONSTRAINT Customer_Address_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID)
)