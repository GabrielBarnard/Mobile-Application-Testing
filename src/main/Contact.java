/*
 * Created by Gabriel Barnard 
 * Completed on the 24th of January 2026
 */

package main;

public class Contact {
	//Variable declarations
	private final String contactID; //contactID shouldn't be modifiable, everything else should be. That's why I use "final"
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	//Constructor
	public Contact (String contactID, String firstName, String lastName, String Number, String Address) { //Takes all the variables declared above as parameters
		if (contactID == null || contactID.length() > 10) { //Checks if the contactID is null or greater than 10
			throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less"); //Throws an exception
		}
		if (firstName == null ||firstName.length() > 10) { //Checks if the first name is null or greater than 10
			throw new IllegalArgumentException("First name must not be null and must be 10 characters or less"); //Throws an exception
		}
		if (lastName == null || lastName.length() > 10) { //Checks if the last name is null or greater than 10
			throw new IllegalArgumentException("Last Name must not be null and must be 10 characters or less"); //Throws an exception
		}
		if (Number == null || !Number.matches("\\d{10}")) { //Checks if the number is not 10 digits using a regular expression (regex) or if it's null. This regex essentially says "digits 10"
			throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits"); //Throws an exception
		}
		if (Address == null || Address.length() > 30) { //Checks if the Address is null or greater than 30
			throw new IllegalArgumentException("Address must not be null and must be 30 characters or less"); //Throws an exception
		}

		this.contactID = contactID; //Sets the variables from the class (this.) to the variables in this constructor 
		this.firstName = firstName;
		this.lastName = lastName;
		this.Number = Number;
		this.Address = Address;
	}
	
	public String getContactID() { //This function returns contact ID
		return contactID;
	}
	
	public String getFirstName() { //This function returns first name
		return firstName;
	}
	
	public String getLastName() { //This function returns last name
		return lastName;
	}
	
	public String getNumber() { //This function returns phone number
		return Number;
	}
	
	public String getAddress() { //This feature returns address
		return Address;
	}
	
	//Note: I can't add a setContactID, since contactID is final
	
	public void setFirstName(String firstName) { //This function modifies the first name based on the input
		if (firstName == null ||firstName.length() > 10) { //Checks if the first name is null or greater than 10
			throw new IllegalArgumentException("First name must not be null and must be 10 characters or less"); //Throws an exception
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) { //This function modifies the last name based on the input
		if (lastName == null || lastName.length() > 10) { //Checks if the last name is null or greater than 10
			throw new IllegalArgumentException("Last Name must not be null and must be 10 characters or less"); //Throws an exception
		}
		this.lastName = lastName;
	}
	
	public void setNumber(String Number) { //This function modifies the phone number based on the input
		if (Number == null || !Number.matches("\\d{10}")) { //Checks if the number is not 10 digits using a regular expression (regex) or null. This regex essentially says "digits 10"
			throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits"); //Throws an exception
		}
		this.Number = Number;
	}
	
	public void setAddress(String Address) { //This function modifies the address based on the input
		if (Address == null || Address.length() > 30) { //Checks if the Address is null or greater than 30
			throw new IllegalArgumentException("Address must not be null and must be 30 characters or less"); //Throws an exception
		}
		this.Address = Address;
	}
}
