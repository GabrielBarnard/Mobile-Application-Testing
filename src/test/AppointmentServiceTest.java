/*
 * Created by Gabriel Barnard
 * Created on the 3rd of February 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

class AppointmentServiceTest {

	@Test
	void addAppointmentNormal() { //tests whether the addAppointment function works with normal values
		AppointmentService appointmentService = new AppointmentService(); //Creates new appointmentService object
		appointmentService.addAppointment("ID1", 3065, 12, 12, "Go visit friend"); //Adds appointment with regular values
		
		assertTrue(appointmentService.appointments.get("ID1").getAppointmentID().equals("ID1")); //These asserttrue's check if the object's variables coincide with those specified above
		assertTrue(appointmentService.appointments.get("ID1").getAppointmentDate().equals(LocalDate.of(3065, 12, 12)));
		assertTrue(appointmentService.appointments.get("ID1").getDescription().equals("Go visit friend"));
	}
	
	@Test
	void addDuplicateAppointment() { //Tests whether the addAppointment function throws an exception when trying to add duplicate appointments
		AppointmentService appointmentService = new AppointmentService(); //Creates object
		appointmentService.addAppointment("ID1", 3065, 12, 12, "Go visit friend"); //Creates appointment with ID1
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			appointmentService.addAppointment("ID1", 9999, 1, 1, "Description"); //Attempts to create a second object with ID1
		});
	}
	
	@Test
	void addMultipleAppointments() { //Tests whether addAppointment function works when adding multiple appointments
		AppointmentService appointmentService = new AppointmentService(); //Creates object
		appointmentService.addAppointment("ID1", 3065, 12, 12, "Go visit friend"); //Adds appointments
		appointmentService.addAppointment("ID2", 4065, 6, 1, "Go visit mother");
		appointmentService.addAppointment("ID3", 30465, 9, 2, "Go visit grandfather");
		
		assertTrue(appointmentService.appointments.get("ID1").getAppointmentID().equals("ID1")); //AssertTrue's check if appointment's variables coincide with parameters declared above
		assertTrue(appointmentService.appointments.get("ID1").getAppointmentDate().equals(LocalDate.of(3065, 12, 12)));
		assertTrue(appointmentService.appointments.get("ID1").getDescription().equals("Go visit friend"));
		
		assertTrue(appointmentService.appointments.get("ID2").getAppointmentID().equals("ID2"));
		assertTrue(appointmentService.appointments.get("ID2").getAppointmentDate().equals(LocalDate.of(4065, 6, 1)));
		assertTrue(appointmentService.appointments.get("ID2").getDescription().equals("Go visit mother"));
		
		assertTrue(appointmentService.appointments.get("ID3").getAppointmentID().equals("ID3"));
		assertTrue(appointmentService.appointments.get("ID3").getAppointmentDate().equals(LocalDate.of(30465, 9, 2)));
		assertTrue(appointmentService.appointments.get("ID3").getDescription().equals("Go visit grandfather"));
	}
	
	@Test
	void deleteAppointmentNormal() { //Tests whether delete appointment does not throw an exception when deleting an appointment and whether it works correctly with normal values
		AppointmentService appointmentService = new AppointmentService(); //Creates object
		appointmentService.addAppointment("ID2", 4065, 6, 1, "Go visit mother"); //Adds appointment
		
		Assertions.assertDoesNotThrow(() -> { //Checks if an exception is NOT thrown
			appointmentService.deleteAppointment("ID2");  //Deletes the appointment
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			appointmentService.deleteAppointment("ID2"); //Attempts to delete the appointment a second time. If deleting the appointment the first time worked, an exception will be thrown.
		});
	}
	
	@Test
	void deleteMultipleAppointments() { //Tests whether deleting multiple appointments works fine
		AppointmentService appointmentService = new AppointmentService(); //Creates object
		appointmentService.addAppointment("ID1", 3065, 12, 12, "Go visit friend"); //Adds appointments
		appointmentService.addAppointment("ID2", 4065, 6, 1, "Go visit mother");
		appointmentService.addAppointment("ID3", 30465, 9, 2, "Go visit grandfather");
		
		Assertions.assertDoesNotThrow(() -> { //Checks if an exception is not thrown 
			appointmentService.deleteAppointment("ID1"); //Deletes an appointment
		});
		
		Assertions.assertDoesNotThrow(() -> { //Checks if an exception is not thrown 
			appointmentService.deleteAppointment("ID2"); //Deletes an appointment
		});
		
		Assertions.assertDoesNotThrow(() -> { //Checks if an exception is not thrown 
			appointmentService.deleteAppointment("ID3"); //Deletes an appointment
		});
	}
	
	@Test
	void deleteNonExistingAppointments() { //Checks if an exception is thrown when deleting a appointment that does not exist
		AppointmentService appointmentService = new AppointmentService(); //Creates object
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Checks if an exception is thrown
			appointmentService.deleteAppointment("Appointment"); //Attempts to delete an appointment with a invalid appointmentID
		});
	}
}
