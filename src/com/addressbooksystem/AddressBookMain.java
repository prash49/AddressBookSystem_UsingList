package com.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    private static AddressBook addressBook = new AddressBook("addressBook");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter 0 to quit the AddressBook system ");
            System.out.println("Enter 1 to add New contacts");
            System.out.println("enter 2 to  display contacts");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("exiting from Address book");
                    quit = true;
                    break;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    addressBook.printContacts();
                    break;
            }
        }
    }

    private static void addNewContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first Name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter city:");
        String city = scanner.nextLine();
        System.out.println("Enter state:");
        String state = scanner.nextLine();
        System.out.println("Enter zip:");
        int zip = scanner.nextInt();
        System.out.println("Enter phoneNumber:");
        long phoneNumber = scanner.nextLong();
        ContactBook newContact = ContactBook.createContact(firstName, lastName, address, city, state, zip, phoneNumber);
        if (addressBook.addNewContact(newContact)) {
            System.out.println("New contact added Successfully..");
        } else {
            System.out.println("cannot add" + firstName + " already on contactBook list");
        }
    }
}