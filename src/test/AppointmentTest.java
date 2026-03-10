/*
 * Created by Gabriel Barnard
 * Created on the 3rd of February 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Appointment;

class AppointmentTest {

	@Test
	void normalAppointmentTest() { //This test checks if the appointment object works fine with regular values
		Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates an appointment object with regular values
		
		assertTrue(appointment.getAppointmentID().equals("ID1")); //These assertTrues check if the appointment objects values coincide with what they were actually set to earlier
		assertTrue(appointment.getAppointmentDate().equals(LocalDate.of(3026, 8, 8)));
		assertTrue(appointment.getDescription().equals("Dentist appointment on the 8th of August"));
	}
	
	@Test
	void appointmentIdOver10Characters() { //Checks if a exception is thrown when appointmentID is over 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("Identification Digit 1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates an appointment object with appointmentID over 10 characters
		});
		
		//No point adding a test that manually sets appointment ID to 10 characters - appointmentID is final, so the code won't compile.
	}
	
	@Test
	void appointmentIdNull() { //Checks if an exception is thrown when appointment ID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment(null, LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates an object with a null appointment ID
		});
		
		//No point adding a test that manually sets appointment ID to null - appointmentID is final, so the code won't
	}
	
	@Test
	void appointmentDateBeforeCurrentDate() { //Checks if an exception is thrown when the appointment date is set to something before the current date
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(2025, 8, 8), "Dentist appointment on the 8th of August"); //Creates an object with a appointment Date before the current date
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates a regular object
			appointment.setAppointmentDate(LocalDate.of(2025, 8, 8)); //Changes the object's appointment date one before the current date
		});
	}
	
	@Test
	void appointmentDateNull() { //Checks if an exception is thrown when the appointment Date is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", null, "Dentist appointment on the 8th of August"); //Creates an object with a null appointment Date
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates a regular object
			appointment.setAppointmentDate(null); //Changes the object's appointment Date to null
		});
	}
	
	@Test
	void descriptionOver50Characters() { //Checks if an error is thrown when the description is over 50 characters 
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August to extract wisdom teeth that are causing me much pain"); //Creates an object with a Description over 50 characters
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates a regular object
			appointment.setDescription("Dentist appointment on the 8th of August to extract wisdom teeth that are causing me much pain"); //Sets the description of that object to one that is over 50 characters
		});
	}
	
	@Test
	void descriptionNull() { //Checks if an exception is thrown when the description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(2025, 8, 8), null); //Creates an object with the Description set to null
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Appointment appointment = new Appointment("ID1", LocalDate.of(3026, 8, 8), "Dentist appointment on the 8th of August"); //Creates a regular object
			appointment.setDescription(null); //Sets the objects description to null
		});
	}
}
