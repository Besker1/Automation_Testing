package contactService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {
    
    @Test
    public void testContactConstructorValidData() {
        Contact contact = new Contact("1234567890", "Dunder", "Mifflin", "9876543210", "1725 Slough Ave");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Dunder", contact.getFirstName());
        assertEquals("Mifflin", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("1725 Slough Ave", contact.getAddress());
    }
    
    @Test
    public void testContactConstructorInvalidData() {
    	 assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Dunder", "Mifflin", "1234567890", "1725 Slough Avenue, Scranton, PA 18505"));
         assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Dunder", "Mifflin", "1234567890", "1725 Slough Avenue, Scranton, PA 18505"));
         assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Dunder123456", "Mifflin", "1234567890", "1725 Slough Avenue, Scranton, PA 18505"));
         assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Dunder", "Mifflin123456", "1234567890", "1725 Slough Avenue, Scranton, PA 18505"));
         assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Dunder", "Mifflin", "123", "1725 Slough Avenue, Scranton, PA 18505"));
         assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Dunder", "Mifflin", "1234567890", "1725 Slough Avenue, Scranton, PA 185051234567890123456789012345678901"));
   
    }

    @Test
    public void testSettersAndGetters() {
        Contact contact = new Contact("1234567890", "Dunder", "Mifflin", "9876543210", "1725 Slough Ave");

        contact.setFirstName("Michael");
        assertEquals("Michael", contact.getFirstName());

        contact.setLastName("Scott");
        assertEquals("Scott", contact.getLastName());

        contact.setPhone("0123456789");
        assertEquals("0123456789", contact.getPhone());

        contact.setAddress("Dunder Mifflin Paper Company");
        assertEquals("Dunder Mifflin Paper Company", contact.getAddress());
    }

    @Test
    public void testInvalidSetters() {
        Contact contact = new Contact("1234567890", "Dunder", "Mifflin", "9876543210", "1725 Slough Ave");

        // Invalid first name
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("DunderMifflinScott"));

        // Invalid last name
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ScottHalpert"));

        // Invalid phone number
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("98765"));

        // Invalid address
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1725 Slough Avenue, Scranton, Pennsylvania, USA"));
    }
}