package com.app.infi.corp.model;

import java.util.Date;

/**
 * Created by adyro on 20-02-2017.
 */

public class ChatMessage {

    private String  contactName;
    private String contactNumber;
    private String messageText;
    private String messageUser;
    private long messageTime;

    public ChatMessage(String contactName, String contactNumber, String messageText, String messageUser) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageTime = new Date().getTime();
    }

    public ChatMessage() {
    }

    public String getContactName() {
        return contactName;
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

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
