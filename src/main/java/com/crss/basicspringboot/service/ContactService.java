package com.crss.basicspringboot.service;

import java.util.List;
import com.crss.basicspringboot.model.Contact;

public interface ContactService {
    Contact getContactById(String id);
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact);
    void deleteContact(String id);
    List<Contact> getContacts();
}
