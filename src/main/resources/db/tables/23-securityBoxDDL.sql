create table SECURITY_BOX  (
    SECURITY_BOX_ID	NUMBER(22) not null,
    SECURITY_DEPOSIT DECIMAL(9,2),
    BRANCH_NAME	VARCHAR2(100),
    LOCKER_SIZE	VARCHAR2(100),
    LOCKER_TYPE	VARCHAR2(100),
    SECURITY_BOX_NUMBER	NUMBER,
    primary key (SECURITY_BOX_ID)
)