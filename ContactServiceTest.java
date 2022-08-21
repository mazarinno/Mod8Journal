package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {

	@Test
	void testAddExistingContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("123", "Joe", "Smith", "1234567890", "123 Street");
        // contact can be created since does not exist yet 
        assertTrue(contactService.addContact(contact, contact.getContactID()));

        contact = new Contact("123", "John", "Doe", "1231231231", "ABC Drive");
        
        // now contact cannot be added because ID is not unique 
        assertFalse(contactService.addContact(contact, contact.getContactID()));
	}
	
	@Test
	void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Joe", "Smith", "1234567890", "123 Street");
        contactService.addContact(contact, contact.getContactID());

        assertTrue(contactService.deleteContact(contact.getContactID()));
	}

}
