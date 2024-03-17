# -*- coding: utf-8 -*-
"""Task3Prodigy.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1S-k4CsC8uhymhhx9D9yA7iPdhXfpITNd
"""

class Contact:
    def __init__(self, name, phone_number, email):
        self.name = name
        self.phone_number = phone_number
        self.email = email

class ContactManager:
    def __init__(self):
        self.contacts = []  # Initialize an empty list to store contacts

    def add_contact(self, name, phone_number, email):
        # Create a new Contact object and add it to the list
        new_contact = Contact(name, phone_number, email)
        self.contacts.append(new_contact)
        print(f"Contact '{name}' added successfully!")

    def view_contacts(self):
        print("\n--- Contact List ---")
        for contact in self.contacts:
            print(f"Name: {contact.name}, Phone: {contact.phone_number}, Email: {contact.email}")

    def edit_contact(self, name, new_phone_number, new_email):
        for contact in self.contacts:
            if contact.name == name:
                contact.phone_number = new_phone_number
                contact.email = new_email
                print(f"Contact '{name}' updated successfully!")
                return
        print(f"Contact '{name}' not found.")

    def delete_contact(self, name):
        for contact in self.contacts:
            if contact.name == name:
                self.contacts.remove(contact)
                print(f"Contact '{name}' deleted successfully!")
                return
        print(f"Contact '{name}' not found.")

if __name__ == "__main__":
    contact_manager = ContactManager()

    while True:
        print("\n--- Contact Management System ---")
        print("1. Add New Contact")
        print("2. View Contact List")
        print("3. Edit Existing Contact")
        print("4. Delete Contact")
        print("5. Exit")

        choice = input("Enter your choice (1-5): ")

        if choice == "1":
            name = input("Enter contact name: ")
            phone_number = input("Enter phone number: ")
            email = input("Enter email address: ")
            contact_manager.add_contact(name, phone_number, email)
        elif choice == "2":
            contact_manager.view_contacts()
        elif choice == "3":
            name = input("Enter contact name to edit: ")
            new_phone_number = input("Enter new phone number: ")
            new_email = input("Enter new email address: ")
            contact_manager.edit_contact(name, new_phone_number, new_email)
        elif choice == "4":
            name = input("Enter contact name to delete: ")
            contact_manager.delete_contact(name)
        elif choice == "5":
            print("Exiting Contact Management System. Goodbye!")
            break
        else:
            print("Invalid choice. Please select a valid option.")