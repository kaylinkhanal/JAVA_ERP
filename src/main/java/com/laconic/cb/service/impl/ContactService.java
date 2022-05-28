package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Contact;
import com.laconic.cb.repository.IContactRepository;
import com.laconic.cb.service.IContactService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IContactService {

    private final IContactRepository contactRepository;

    public ContactService(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void saveContactPerson(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getAllContactPerson(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return contactRepository.findAll(pageable);
    }
}
