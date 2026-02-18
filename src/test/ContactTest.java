/*
 * Created by Gabriel Barnard
 * Completed on the 24th of January 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	@Test //Declares the start of a test
	void contactTest() { //This test checks if all variables in Contact.java work with "proper" values
		Contact contact = new Contact("ID1", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		assertTrue(contact.getContactID().equals("ID1")); //All the following assertTrue statement checks if the  parameter is actually associated with the value declared above
		assertTrue(contact.getFirstName().equals("Muhammad"));
		assertTrue(contact.getLastName().equals("Ali"));
		assertTrue(contact.getNumber().equals("1942333333"));
		assertTrue(contact.getAddress().equals("Scottsdale, Arizona, US"));
	}
	
	@Test
	void contactIDTooLong() { //This test checks if an exception is thrown when the contactID is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID22222222222222222222222222222222", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		//I can't perform a test in which I assign a really long contactID here, the program won't compile, since i've set contactID as final.
	}
	
	@Test
	void contactIDNull() { //This test checks if an exception is thrown when the contactID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact(null, "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		//I can't perform a test in which I assign a null contactID, the program won't compile since i've set contactID as final
	}
	
	@Test
	void firstNameIDTooLong() { //This test checks if an exception is thrown when the first name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID3", "MuhammadTheLongName", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID3", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setFirstName("LongLongLongLongFirstName");
		});
	}
	
	@Test
	void firstNameNull() { //This test checks if an exception is thrown when the first name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID3", null, "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID3", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setFirstName(null);
		});
	}
	
	@Test
	void lastNameTooLong() { //This test checks if an exception is thrown when the last name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID4", "Muhammad", "AliTHELONGNAMEEEEEEEEEEEEEEEEEEE", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID4", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setLastName("LONGNAMELONGNAME");
		});
	}
	
	@Test
	void lastNameNull() { //This test checks if an exception is thrown when the last name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID4", "Muhammad", null, "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID4", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setLastName(null);
		});
	}
	
	@Test
	void NumberTooLong() { //This test checks if an exception is thrown when the Number is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "194233333333333333333333333333333333333333", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setNumber("99999999999999999999999999999");
		});
	}
	
	@Test
	void NumberNull() { //This test checks if an exception is thrown when the Number is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", null, "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setNumber(null);
		});
	}
	
	@Test
	void NumberTooShort() { //This test checks if an exception is thrown when the Number is too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "555", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setNumber("555");
		});
	}
	
	@Test
	void NonDigitOnlyNumber() { //This test checks if an exception is thrown when the phone number isn't made solely of numbers
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "Butterfly0", "Scottsdale, Arizona, US"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID5", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setNumber("Butterfly0");
		});
	}
	

	@Test
	void AddressTooLong() { //This test checks if an exception is thrown when the Address is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID6", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, USAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID6", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setAddress("LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOONG");
		});
	}
	
	@Test
	void AddressNull() { //This test checks if an exception is thrown when the Address is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID6", "Muhammad", "Ali", "1942333333", null); //Creates a new contact object
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an error is thrown
			Contact contact = new Contact("ID6", "Muhammad", "Ali", "1942333333", "Scottsdale, Arizona, US"); //Creates a new contact object
			contact.setAddress(null);
		});
	}
	
	
}
