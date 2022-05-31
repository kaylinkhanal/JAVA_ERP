create table CUSTOMER  (
    CUSTOMER_ID	NUMBER(22) not null,
    FIRST_NAME VARCHAR2(250) not null,
    LAST_NAME VARCHAR2(250) not null,
    GENDER VARCHAR2(50) not null,
    DOB DATE not null,
    ID_PASSPORT_NO VARCHAR2(50) not null,
    EMAIL VARCHAR2(50),
    CONTACT_NO VARCHAR2(50) not null,
    code NUMBER(22),
    REGISTER_DATE DATE not null,
    CREATED_BY	VARCHAR2(20),
    CREATION_DATE	DATE,
    DISABLE_BY	VARCHAR2(20),
    DISABLE_DATE	DATE,
    LAST_UPDATED_BY	VARCHAR2(20),
    LAST_UPDATE_DATE	DATE,
    IS_DELETED VARCHAR2(1) not null,
    primary key (CUSTOMER_ID),
    CONSTRAINT gender_enum CHECK (GENDER IN ('Male', 'Female', 'Other'))
)
