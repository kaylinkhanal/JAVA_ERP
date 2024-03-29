create table TITLE  (
       TITLE_ID	NUMBER(22) not null,
       CASE_TYPE_CODE	VARCHAR2(100) not null,
       CASE_TYPE_NAME	VARCHAR2(100) not null,
       DURATION	NUMBER,
       PRICE	VARCHAR2(20),
       CREATION_DATE	DATE,
       DISABLE_BY	VARCHAR2(20),
       DISABLE_DATE	DATE,
       LAST_UPDATED_BY	VARCHAR2(20),
       LAST_UPDATE_DATE	DATE,
       IS_DELETED VARCHAR2(1),
       primary key (TITLE_ID)
)