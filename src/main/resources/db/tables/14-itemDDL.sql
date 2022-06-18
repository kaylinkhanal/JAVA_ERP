create table ITEM  (
      ITEM_ID	NUMBER(22) not null,
      ITEM_NAME VARCHAR2(100) not null,
      ITEM_PART_NAME VARCHAR2(100) not null,
      STATUS VARCHAR2(100) not null,
      CREATION_DATE	DATE,
      DISABLE_BY	VARCHAR2(20),
      DISABLE_DATE	DATE,
      LAST_UPDATED_BY	VARCHAR2(20),
      LAST_UPDATE_DATE	DATE,
      IS_DELETED VARCHAR2(1) not null,
      primary key (ITEM_ID)
)
