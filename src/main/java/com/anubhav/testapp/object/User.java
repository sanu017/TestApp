package com.anubhav.testapp.object;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anubhav on 4/16/2014.
 */
public class User {

    private int internalId;

    private String name;

    private Set<Book> issuedBooks = new HashSet<Book>();

    public User(){}

    public User(int internalId, String name, Set<Book> issuedBooks){
        this.internalId = internalId;
        this.name = name;
        this.issuedBooks = issuedBooks;
    }

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(Set<Book> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }
}
