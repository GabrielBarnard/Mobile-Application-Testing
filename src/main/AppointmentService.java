/*
 * Created by Gabriel Barnard
 * Created on the 3rd of February 2026
 */

package main;

import java.time.LocalDate;
import java.util.HashMap;

public class AppointmentService {
	public HashMap<String, Appointment> appointments = new HashMap<String, Appointment>(); //Creates HashMap called appointments. With a String (for appointmentID) as the key and Appointment (appointment object) as the value
	
	//Method to add an appointment
	public void addAppointment(String appointmentID, int Year, int Month, int Day, String Description) {
		if (appointments.containsKey(appointmentID)) { //Checks if the appointments HashMap contains the appointment ID
			throw new IllegalArgumentException("To add an appointment, you must use a new appointment ID"); //Throws an exception
		}
		
		Appointment appointment = new Appointment(appointmentID, LocalDate.of(Year, Month, Day), Description); //Creates a new appointment object whose variables are set to those set in the parameters
		appointments.put(appointmentID, appointment); //Puts the appointment as a value into the appointments hashmap with the appointmentID as the key
	}
	
	//Method to delete an appointment
	public void deleteAppointment(String appointmentID) {
		if (!appointments.containsKey(appointmentID)) { //Checks if the appointments HashMap does not contain the appointment ID
			throw new IllegalArgumentException("To delete an appointment you must use a valid appointment ID"); //Throws an exception
		}
		
		appointments.remove(appointmentID); //Removes the appointment from the hashmap by using the appointment ID
	}
}
