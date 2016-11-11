package com.activeeon.contact;

import java.util.List;

/**
 * Created by Clement Caron on 09/11/2016.
 */
public interface ContactInterface {
    public boolean createContact(Contact contact);
    public boolean updateContact(Contact contact);
    public boolean deleteContact(Contact contact);
    public List<Contact> getAllContacts();
    public List<Contact> getContactsByName(String name);
    public List<Contact> getContactsBySubName(String subName);
    public Contact getContactByPhoneNumber(String phoneNumber);
}