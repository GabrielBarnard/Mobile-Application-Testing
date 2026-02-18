/*
 * Created by Gabriel Barnard
 * Completed on the 24th of January 2026 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactService;

class ContactServiceTest {

	@Test //Declares the start of a test
	void addContactsTest() { //This test checks if ContactService.java is able to add a contact
		ContactService contactService = new ContactService(); //Creates a ContactService object
		contactService.addContact("ID1"); //Uses the add contact function to add contact with contactID "ID1"
		
		assertTrue(contactService.contacts.get("ID1").getContactID().equals("ID1")); //All the following assertTrue statements go through the contacts hashmap in contactSearch by using the contact's associated key "ID1". It then compares it the default values from ContactService.java to see if everything has been properly created
		assertTrue(contactService.contacts.get("ID1").getFirstName().equals("FirstName"));
		assertTrue(contactService.contacts.get("ID1").getLastName().equals("LastName"));
		assertTrue(contactService.contacts.get("ID1").getNumber().equals("0000000000"));
		assertTrue(contactService.contacts.get("ID1").getAddress().equals("Street, City, Country"));
	}
	
	@Test
	void removeContactTest() { //This test checks if ContactServices.java is able to remove a contact
		ContactService contactService = new ContactService(); //Creates ContactService object
		contactService.addContact("ID2"); //Adds a contact with contact ID "ID2"
		
		contactService.removeContact("ID2"); //Removes the contact
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an exception is thrown
			contactService.removeContact("ID2"); //If Java does not throw an exception here, it means that the previous removeContact did not work
		});
	}
	
	@Test
	void modifyContactTest() { //This test checks if ContactServices.java is able to modify a contact
		ContactService contactService = new ContactService(); //Creates a ContactService object
		contactService.addContact("ID3"); //Adds a contact with contactID "ID3"
		contactService.modifyContact("ID3", "Robert", "Prevost", "0668139289", "Citta del Vaticano, Vatican"); //Uses the modify contact function on the newly added contact
		assertTrue(contactService.contacts.get("ID3").getFirstName().equals("Robert")); //All the following assertTrue go into the contacts HashMap in the contactServices object and use the contact ID ("ID3) to check if each variable has actually been modified 
		assertTrue(contactService.contacts.get("ID3").getLastName().equals("Prevost"));
		assertTrue(contactService.contacts.get("ID3").getNumber().equals("0668139289"));
		assertTrue(contactService.contacts.get("ID3").getAddress().equals("Citta del Vaticano, Vatican"));
		
	}
}
