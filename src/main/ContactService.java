/*
 * Created by Gabriel Barnard
 * Completed on the 24th of January 2026 
 */

package main;

import java.util.HashMap; //Imports HashMap library

public class ContactService {
	public HashMap<String, Contact> contacts = new HashMap<String, Contact>(); //Creates a new HashMap called "contacts" with a string as the key (for contactID), and Contact(the object) as the value (for the created contacts)
	
	public void addContact(String contactID) { //Function to add a contact
		if (contacts.containsKey(contactID)) { //Checks if the contactID already exists by checking if it is in the contacts HashMap
			throw new IllegalArgumentException("You cannot add a contact with a contact ID that's already in use"); //Throws an exception
		}
		
		Contact contact = new Contact(contactID, "FirstName", "LastName", "0000000000", "Street, City, Country"); //Creates a new contact with the ContactID and some default values, to change the values, the user can use the modifyContact function
		contacts.put(contactID, contact); //Puts the newly created contact in the HashMap, with the contact ID as the key
	}
	
	public void removeContact(String contactID) { //Function to remove a contact
		if (!contacts.containsKey(contactID)) { //Checks if the contactID does not exist
			throw new IllegalArgumentException("You cannot remove a contact with a invalid contact ID"); //Throws an exception
		}
		
		contacts.remove(contactID); //Removes the contact/contactID from the HashMap
	}
	
	public void modifyContact(String contactID, String firstName, String lastName, String Number, String Address) { //Function to modify a contact. Takes parameters for everything except contactID (Since contactID cannot be modified)
		if (!contacts.containsKey(contactID)) { //Checks if the contacts HashMap does not contain contact ID
			throw new IllegalArgumentException("You cannot modify a contact with a invalid contact ID"); //Throws an exception
		}
		
		Contact contact = contacts.get(contactID); //Creates a new contact that is connected to the contact associated with the contactID in the contact HashMap. Basically, any changes made to the "new" contact also affect the one in the HashMap
		contact.setFirstName(firstName); //Sets the contacts values to the user's selected values
		contact.setLastName(lastName);
		contact.setNumber(Number);
		contact.setAddress(Address);
	}
}
