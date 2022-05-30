create table DOCUMENT_TYPE  (
      DOCUMENT_TYPE_ID	NUMBER(22) not null,
      DOCUMENT_TYPE_NAME	VARCHAR2(100) not null,
      DESCRIPTION	VARCHAR2(500) not null,
      IS_DELETED VARCHAR2(1) not null,
      CREATED_BY	VARCHAR2(20),
      CREATION_DATE	DATE,
      DISABLE_BY	VARCHAR2(20),
      DISABLE_DATE	DATE,
      LAST_UPDATED_BY	VARCHAR2(20),
      LAST_UPDATE_DATE	DATE,
      primary key (DOCUMENT_TYPE_ID)
)