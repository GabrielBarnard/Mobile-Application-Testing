/*
 * Made by Gabriel Barnard
 * Made on the 3rd of February 2026
 */

package main;

import java.time.LocalDate;

public class Appointment {
	//Variable declarations
	private final String appointmentID; //appointmentID should immutable, therefore it is final. Everything else shouldn't be modifiable, therefore it isn't final.
	private LocalDate appointmentDate;
	private String Description;
	
	private LocalDate today = LocalDate.now(); //Stores the current time
	
	//Appointment Constructor
	public Appointment(String appointmentID, LocalDate appointmentDate, String Description) {
		if ((appointmentID == null) || (appointmentID.length() > 10)) { //Checks if the appointment ID is null or greater than 10 characters in length
			throw new IllegalArgumentException("AppointmentID cannot be longer than 10 characters and cannot be null"); //Throws an exception
		}
		if ((appointmentDate == null) || (appointmentDate.isBefore(today))) { //Checks if the appointment Date is null or before the current date
		 	throw new IllegalArgumentException("Appointment date cannot be null and cannot be before the current date"); //Throws an exception
		}
		if ((Description == null) || (Description.length() > 50) ) { //Checks if the description is null or greater than 50 characters long
			throw new IllegalArgumentException("Description cannot be null and cannot be greater than 50 characters"); //Throws an exception
		}
		
		this.appointmentID = appointmentID; //Sets the variables/objects of the class to the variables/objects declared here
		this.appointmentDate = appointmentDate;
		this.Description = Description;
	}
	
	//Returns appointmentID
	public String getAppointmentID() {
		return this.appointmentID; //this. is not necessary. I just think it makes things look cleaner
	}
	
	//No point adding a appointmentID setter, appointmentID is final. It cannot be changed.
	
	//Returns appointmentDate
	public LocalDate getAppointmentDate() {
		return this.appointmentDate;
	}
	
	//Changes the appointmentDate
	public void setAppointmentDate(LocalDate appointmentDate) {
		if ((appointmentDate == null) || (appointmentDate.isBefore(today))) { //Checks if the appointment Date is null or before the current date
			throw new IllegalArgumentException("Appointment date cannot be null and cannot be before the current date"); //Throws an exception
		}
		this.appointmentDate = appointmentDate;
	}
	
	//Returns the Description
	public String getDescription() {
		return this.Description;
	}

	//Changes the Description 
	public void setDescription(String Description) {
		if ((Description == null) || (Description.length() > 50) ) { //Checks if the description is null or greater than 50 characters long
			throw new IllegalArgumentException("Description cannot be null and cannot be greater than 50 characters"); //Throws an exception
		}
		this.Description = Description;
	}
}
