create table DEPOSIT  (
    DEPOSIT_ID	NUMBER(22) not null,
    DEPOSIT_NUMBER VARCHAR2(100) not null,
    DEPOSIT_DATE Date not null,
    SEQUENCE VARCHAR2(50) not null,
    CASE_REMARK VARCHAR2(50) not null,
    REJECT_REMARK VARCHAR2(100) not null,
    DEPOSIT_TITLE VARCHAR2(100) not null,
    VAT VARCHAR2(100) not null,
    EXCHANGE_RATE DECIMAL(9,2) not null,
    PAYMENT_TERM VARCHAR2(100) not null,
    BANK_ACCOUNT VARCHAR2(100) not null,
    NON_VAT DECIMAL(9,2),
    SUBTOTAL_VAT DECIMAL(9,2),
    SUBTOTAL_AMOUNT DECIMAL(9,2),
    AMOUNT DECIMAL(9,2),
    STATUS VARCHAR2(100),
    CREATION_DATE	DATE,
    DISABLE_BY	VARCHAR2(20),
    DISABLE_DATE	DATE,
    LAST_UPDATED_BY	VARCHAR2(20),
    LAST_UPDATE_DATE	DATE,
    IS_DELETED VARCHAR2(1) not null,
    CASE_ID NUMBER(22),
    CURRENCY_ID NUMBER(22),
    CUSTOMER_ID NUMBER(22),
    primary key (DEPOSIT_ID),
    CONSTRAINT Customer_DEPOSIT_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
    CONSTRAINT Currency_DEPOSIT_FK FOREIGN KEY (CURRENCY_ID) REFERENCES CURRENCY(CURRENCY_ID)
)