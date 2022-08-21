package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact Contact = new Contact("12345", "Joe", "Smith", "1234567890", "123 Street");
		assertTrue(Contact.getContactID().equals("12345"));
		assertTrue(Contact.getFirstName().equals("Joe"));
		assertTrue(Contact.getLastName().equals("Smith"));
		assertTrue(Contact.getPhone().equals("1234567890"));
		assertTrue(Contact.getAddress().equals("123 Street"));
	}

	@Test
	void testContactNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Joeeeeeeeeeeee", "Smith", "1234567890", "123 Street");
		});
	}
	
}
