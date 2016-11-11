package com.activeeon.contact;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Clement Caron on 09/11/2016.
 */
public class Contact {
    @NotNull
    @Size(min=2, max=20)
    private String phoneNumber;

    @NotNull
    private String name;

    @NotNull
    private String address;

    public Contact() { }

    public Contact(String phoneNumber, String name, String address) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{ " + this.phoneNumber + " | " + this.name + " | " + this.getAddress() + " }";
    }
}
