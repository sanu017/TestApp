package com.anubhav.testapp.object;

import java.util.Date;

/**
 * Created by Anubhav on 4/16/2014.
 */
public class Book {

    private int internalId;

    private String isdn;

    private String title;

    private String author;

    private Date issuedOn;

    public Book(){}

    public Book(int internalId,  String isdn, String title, String author, Date issuedOn){
        this.internalId = internalId;
        this.isdn = isdn;
        this.title = title;
        this.author = author;
        this.issuedOn = issuedOn;
    }

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }
}
