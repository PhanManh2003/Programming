package service;

import entity.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Management {
    
    private List<Contact> contacts;
    
    public Management() {
        contacts = new ArrayList<>();
    }

    // check phone
    public boolean phoneExists(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // 1. add contact
    public void addContact(String name, String phoneNumber) {
        if (phoneExists(phoneNumber)) {
            System.out.println("Contact already exists.");
        } else {
            contacts.add(new Contact(name, phoneNumber));
            System.out.println("Contact added successfully.");
        }
    }

    // 2. edit contact
    public void editContact(String oldPhone, String newPhone) {
        if (!phoneExists(oldPhone)) {
            System.out.println("Old phone number does not exist.");
            return;
        }
        if (phoneExists(newPhone)) {
            System.out.println("New phone number already exists.");
            return;
        }
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(oldPhone)) {
                c.setPhoneNumber(newPhone);
                System.out.println("Updated: " + c);
                return;
            }
        }
    }
    // 3. search contact

    public void searchByName(String name) {
        System.out.println("Results for \"" + name + "\":");
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase().trim())) {
                System.out.println("  " + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No contacts found.");
        }
    }

    // 4. sort contact alphabetically
    public void sortContacts() {
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
        System.out.println("Contacts sorted alphabetically.");
    }

    // display all contacts
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts.");
            return;
        }
        System.out.println("--- All Contacts ---");
        for (Contact c : contacts) {
            System.out.println("  " + c);
        }
    }
}
