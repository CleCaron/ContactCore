package com.activeeon.contact;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

/**
 * Created by Clement Caron on 09/11/2016.
 */
public class ContactValidationTest {

    @Test
    public void phoneNumberNullTest() {
        Contact contact = new Contact(null, "name", "address");
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(1, violations.size());
        assertEquals(ContactValidator.PHONE_NUMBER_ERROR, violations.get(0));
    }

    @Test
    public void phoneNumberTooSmallTest() {
        Contact contact = new Contact("1", "name", "address");
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(1, violations.size());
        assertEquals(ContactValidator.PHONE_NUMBER_ERROR, violations.get(0));
    }

    @Test
    public void phoneNumberTooBigTest() {
        Contact contact = new Contact("1111111111111111111111111", "name", "address");
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(1, violations.size());
        assertEquals(ContactValidator.PHONE_NUMBER_ERROR, violations.get(0));
    }

    @Test
    public void nameNullTest() {
        Contact contact = new Contact("phone", null, "address");
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(1, violations.size());
        assertEquals(ContactValidator.NAME_ERROR, violations.get(0));
    }

    @Test
    public void addressNullTest() {
        Contact contact = new Contact("phone", "name", null);
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(1, violations.size());
        assertEquals(ContactValidator.ADDRESS_ERROR, violations.get(0));
    }

    @Test
    public void allNullTest() {
        Contact contact = new Contact(null, null, null);
        ContactValidator validator = new ContactValidator();

        List<String> violations = validator.validateContact(contact);

        assertEquals(3, violations.size());
    }
}
