package com.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook("addressBook");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("Enter 6 to print actions");
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
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                case 5:
                    addMultipleContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Enter right choice");
            }
        }
    }

    private static void addMultipleContact() {
        System.out.println("Enter Number of Contacts to Add into Contact Book");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            addNewContact();
            System.out.println(i + 1 + " Contact added Successfully.. ");
        }
    }

    private static void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter existing contact firstName:");
        String searchName = scanner.nextLine();
        ContactBook existingContactRecord = addressBook.queryContact(searchName);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        if (addressBook.removeContact(existingContactRecord)) {
            System.out.println(searchName + " is deleted successfully");
        } else {
            System.out.println("Error in deleting the contact");
        }
    }


    public static void printActions() {
        System.out.println(" 0 -> Quit the AddressBook system ");
        System.out.println(" 1 -> Add New contacts");
        System.out.println(" 2 -> View contacts");
        System.out.println(" 3 -> Edit  contact");
        System.out.println(" 4 ->  Delete contact");
        System.out.println(" 5 -> Add Multiple Contact");
        System.out.println(" 6 -> Print actions");
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

    private static void updateContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter existing contact firstName:");
        String name = scanner.nextLine();
        ContactBook existingContactRecord = addressBook.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        System.out.println("Enter new first Name:");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter new last Name:");
        String newLastName = scanner.nextLine();
        System.out.println("Enter  new address:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter new city:");
        String newCity = scanner.nextLine();
        System.out.println("Enter new state:");
        String newState = scanner.nextLine();
        System.out.println("Enter  new zip:");
        int newZip = scanner.nextInt();
        System.out.println("Enter  newphone Number:");
        long newPhoneNumber = scanner.nextLong();
        ContactBook newContact = ContactBook.createContact(newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber);
        if (addressBook.updateContact(existingContactRecord, newContact)) {
            System.out.println("successfully updated the Contact");
        } else {
            System.out.println("Not updated");
        }
    }
}