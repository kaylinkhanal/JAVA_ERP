package com.laconic.cb.service;

import com.laconic.cb.model.ContactPerson;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IContactPersonService {
    ContactPerson saveContactPerson(ContactPerson contact);

    Page<ContactPerson> getAllContactPerson(int pageNo);
    List<ContactPerson> getAllContactPerson();
    void softDeleteContact(Long contactId);
    ContactPerson updateContactPerson(ContactPerson contact);

    Optional<ContactPerson> findById(Long contactId);

    long getTotalContact();
}
