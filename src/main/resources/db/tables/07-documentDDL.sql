create table DOCUMENT  (
        DOCUMENT_ID	NUMBER(22) not null,
        DOCUMENT_NAME	VARCHAR2(100) not null,
        DOCUMENT_NO	NUMBER(22) not null,
        DOCUMENT_TYPE_ID	NUMBER(22) not null,
        BRANCH VARCHAR2(50) not null,
        CONTENT VARCHAR2(5000) not null,
        PRINTING_FORMAT VARCHAR2(100) not null,
        "LANGUAGE" VARCHAR2(50) not null,
        CREATED_BY	VARCHAR2(20),
        CREATION_DATE	DATE,
        DISABLE_BY	VARCHAR2(20),
        DISABLE_DATE	DATE,
        LAST_UPDATED_BY	VARCHAR2(20),
        LAST_UPDATE_DATE	DATE,
        primary key (DOCUMENT_ID),
        CONSTRAINT DocumentType_Document_FK FOREIGN KEY (DOCUMENT_TYPE_ID) REFERENCES DOCUMENT_TYPE(DOCUMENT_TYPE_ID)
)