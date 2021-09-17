package com.addressbooksystem;

import java.util.ArrayList;

public class AddressBook {
    private String myAddressBook;
    private ArrayList<ContactBook> myContacts;

    public AddressBook(String myAddressBook) {
        this.myAddressBook = myAddressBook;
        this.myContacts = new ArrayList<ContactBook>();
    }

    public boolean addNewContact(ContactBook contact) {
        if (findContact(contact.getFirstName()) > 0) {
            System.out.println("Contact is already on List");
        }
        myContacts.add(contact);
        return true;
    }

    private int findContact(String firstName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            ContactBook contact = this.myContacts.get(i);
            if (contact.getFirstName().equals(firstName)) {
                return i;
            }
        }
        return -1;
    }
    public void printContacts() {
        System.out.println("ContactBook List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." +
                    "firstName:\t" + this.myContacts.get(i).getFirstName() +
                    "\nLastName:\t" + this.myContacts.get(i).getLastName() +
                    "\n Address:\t" + this.myContacts.get(i).getAddress() +
                    "\n City:\t" + this.myContacts.get(i).getCity() +
                    "\n State:\t" + this.myContacts.get(i).getState() +
                    "\n zipCode:\t" + this.myContacts.get(i).getZip() +
                    "\n PhoneNumber:\t" + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
