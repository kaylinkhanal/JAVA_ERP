create table INVOICE_DETAIL  (
       INVOICE_DETAIL_ID	NUMBER(22) not null,
       INVOICE_ID	NUMBER(22) not null,
       ITEM_ID	NUMBER(22) not null,
       CREATION_DATE	DATE,
       DISABLE_BY	VARCHAR2(20),
       DISABLE_DATE	DATE,
       LAST_UPDATED_BY	VARCHAR2(20),
       LAST_UPDATE_DATE	DATE,
       IS_DELETED VARCHAR2(1) not null,
       primary key (INVOICE_DETAIL_ID),
       CONSTRAINT Invoice_InvoiceDetail_FK FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE(INVOICE_ID),
       CONSTRAINT Item_InvoiceDetail_FK FOREIGN KEY (ITEM_ID) REFERENCES ITEM(ITEM_ID)
)