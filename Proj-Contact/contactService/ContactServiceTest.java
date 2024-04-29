package contactService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact1 = new Contact("1234567890", "Dunder", "Mifflin", "9876543210", "1725 Slough Ave");
        contact2 = new Contact("0987654321", "Pam", "Beesly", "1234567890", "Scranton Business Park");
    }

    @Test
    public void testAddContact() {
        contactService.addContact(contact1);
        assertEquals(contact1, contactService.getContact(contact1.getContactId()));
    }

    @Test
    public void testAddContactWithDuplicateId() {
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact1));
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(contact1);
        contactService.deleteContact(contact1.getContactId());
        assertThrows(IllegalArgumentException.class, () -> contactService.getContact(contact1.getContactId()));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("nonexistent"));
    }

    @Test
    public void testUpdateContact() {
        contactService.addContact(contact1);
        contactService.updateContact(contact1.getContactId(), "firstname", "Michael");
        assertEquals("Michael", contactService.getContact(contact1.getContactId()).getFirstName());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("nonexistent", "firstname", "Michael"));
    }

    @Test
    public void testUpdateContactInvalidField() {
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact(contact1.getContactId(), "invalidfield", "value"));
    }
}
