import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and setters (optional)

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber, String email) {
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact '" + name + "' added successfully!");
    }

    public void viewContacts() {
        System.out.println("\n--- Contact List ---");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void editContact(String name, String newPhoneNumber, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact '" + name + "' updated successfully!");
                return;
            }
        }
        System.out.println("Contact '" + name + "' not found.");
    }

    public void deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact '" + name + "' deleted successfully!");
                return;
            }
        }
        System.out.println("Contact '" + name + "' not found.");
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add New Contact");
            System.out.println("2. View Contact List");
            System.out.println("3. Edit Existing Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String email = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, email);
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter contact name to edit: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new email address: ");
                    String newEmail = scanner.nextLine();
                    contactManager.editContact(editName, newPhoneNumber, newEmail);
                    break;
                case 4:
                    System.out.print("Enter contact name to delete: ");
                    String deleteName = scanner.nextLine();
                    contactManager.deleteContact(deleteName);
                    break;
                case 5:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
