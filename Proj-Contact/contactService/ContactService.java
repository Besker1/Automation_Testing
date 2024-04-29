package contactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String field, String value) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        Contact contact = contacts.get(contactId);
        switch (field.toLowerCase()) {
            case "firstname":
                contact.setFirstName(value);
                break;
            case "lastname":
                contact.setLastName(value);
                break;
            case "phone":
                contact.setPhone(value);
                break;
            case "address":
                contact.setAddress(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field.");
        }
    }

    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact does not exist.");
        }
        return contacts.get(contactId);
    }
}