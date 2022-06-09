create table CURRENCY  (
    CURRENCY_ID	NUMBER(22) not null,
    CURRENCY_CODE	VARCHAR2(250) not null,
    CURRENCY_NAME	VARCHAR2(250) not null,
    primary key (CURRENCY_ID)
)