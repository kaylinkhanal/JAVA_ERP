package com.laconic.cb.service;

import com.laconic.cb.model.Contact;
import org.springframework.data.domain.Page;

public interface IContactService {
    void saveContactPerson(Contact contact);

    Page<Contact> getAllContactPerson(int pageNo);
}
