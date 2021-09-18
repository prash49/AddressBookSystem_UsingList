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

    public boolean updateContact(ContactBook oldContact, ContactBook newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getFirstName() + " was not found in the list");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getFirstName() + ", was replaced with " + newContact.getFirstName());
        return true;
    }

    private int findContact(ContactBook contact) {
        return this.myContacts.indexOf(contact);
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

    public String queryContact(ContactBook contact) {
        if (findContact(contact) >= 0) {
            return contact.getFirstName();
        }
        return null;
    }

    public ContactBook queryContact(String searchName) {
        int position = findContact(searchName);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("ContactBook List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." +
                    "firstName:" + this.myContacts.get(i).getFirstName() +
                    "\tLastName: " + this.myContacts.get(i).getLastName() +
                    "\n Address: " + this.myContacts.get(i).getAddress() +
                    "\t City: " + this.myContacts.get(i).getCity() +
                    "\t State: " + this.myContacts.get(i).getState() +
                    "\t zipCode: " + this.myContacts.get(i).getZip() +
                    "\n PhoneNumber: " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean removeContact(ContactBook contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getFirstName() + " was not found in the list");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getFirstName() + ", was removed from the list");
        return true;
    }
}
