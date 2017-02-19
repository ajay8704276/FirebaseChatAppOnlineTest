package com.app.infi.corp.model;

/**
 * Created by adyro on 19-02-2017.
 */

public class Contacts {

    private String contactName;

    public String getContactName() {
        return contactName;
    }

    public Contacts(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    private String contactNumber;

}
