package com.activeeon.contact;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Clement Caron on 09/11/2016.
 */
public class ContactValidator {
    public static String PHONE_NUMBER_ERROR = "phoneNumber";
    public static String NAME_ERROR = "name";
    public static String ADDRESS_ERROR = "address";

    public List<String> validateContact(Contact contact) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        List<String> violations = new ArrayList<String>();
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(contact);

        for (ConstraintViolation<Contact> constraint : constraintViolations) {
            violations.add(constraint.getPropertyPath().toString());
        }

        return violations;
    }
}
