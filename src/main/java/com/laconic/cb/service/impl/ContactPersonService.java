package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.ContactPerson;
import com.laconic.cb.repository.IContactPersonRepository;
import com.laconic.cb.service.IContactPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactPersonService implements IContactPersonService {

    private final IContactPersonRepository contactRepository;

    public ContactPersonService(IContactPersonRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactPerson saveContactPerson(ContactPerson contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Page<ContactPerson> getAllContactPerson(int pageNo, Long customerId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
//        return contactRepository.findAllByIsDeletedFalse(pageable);
        return contactRepository.findAllByIsDeletedFalseAndCustomer_CustomerId(pageable, customerId);
    }

    @Override
    public List<ContactPerson> getAllContactPerson() {
        return contactRepository.findAllByIsDeletedFalse();
    }

    public void softDeleteContact(Long contactId) {
        contactRepository.softDeleteContact(contactId);
    }

    public ContactPerson updateContactPerson(ContactPerson contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public Optional<ContactPerson> findById(Long contactId) {
        return contactRepository.findByContactPersonIdAndIsDeletedFalse(contactId);
    }

    @Override
    public long getTotalContact() {
        return contactRepository.countByIsDeletedFalse();
    }

    @Override
    public List<ContactPerson> findContactPersonByCustomerId(Long customerId) {
        return contactRepository.findByCustomer_CustomerIdAndIsDeletedFalse(customerId);
    }
}
