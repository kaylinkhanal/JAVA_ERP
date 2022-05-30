package com.laconic.cb.service;

import com.laconic.cb.model.Contact;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IContactService {
    Contact saveContactPerson(Contact contact);

    Page<Contact> getAllContactPerson(int pageNo);
    void softDeleteContact(Long contactId);
    Contact updateContactPerson(Contact contact);

    Optional<Contact> findById(Long contactId);
}
