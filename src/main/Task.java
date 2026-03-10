/*
 * Created by Gabriel Barnard
 * Created on the 29th of January 2026
 */

package main;

public class Task {
	//Variable Declarations
	private final String taskID; //TaskID is final to make it non-mutable. Name and Description aren't final because they are meant to be mutable.
	private String Name;
	private String Description;
	
	
	//Constructor
	public Task (String taskID, String Name, String Description) {
		if (taskID == null || taskID.length() > 10) { //Checks if task ID is null or greater than 10 characters in length
			throw new IllegalArgumentException("Task ID must not be null or greater than 10 characters in length."); //Throws an exception
		}
		if (Name == null || Name.length() > 20) { //Checks if Name is null or greater than 20 characters in length
			throw new IllegalArgumentException("Name must not be null or greater than 20 chraracters."); //Throws an exception
		}
		if (Description == null || Description.length() > 50) { //Checks if Description is null or greater than 50 characters in length
			throw new IllegalArgumentException("Description must not be null or greater than 50 characters in length."); //Throws an exception
		}
		
		this.taskID = taskID; //Sets the class variables (this.) to the parameter values set in the constructor
		this.Name = Name;
		this.Description = Description;
	}
	
	//Task ID getter
	public String getTaskID() {
		return this.taskID; //Returns the object's taskID. this. isn't necessary here, I just think it makes it clearer
	}
	
	//No point adding a setTaskID method. TaskID is final and will not compile.
	
	//Name getter
	public String getName() {
		return this.Name;
	}
	
	//Name setter
	public void setName(String Name) {
		if (Name == null || Name.length() > 20) { //Checks if Name is null or greater than 20 characters in length
			throw new IllegalArgumentException("Name must not be null or greater than 20 chraracters."); //Throws an exception
		}
		this.Name = Name; //Sets the object's Name variable to the Name that was set as a parameter in this method
	}
	
	//Description getter
	public String getDescription() {
		return this.Description;
	}
	
	//DEscription setter
	public void setDescription(String Description) {
		if (Description == null || Description.length() > 50) { //Checks if Description is null or greater than 50 characters in length
			throw new IllegalArgumentException("Description must not be null or greater than 50 characters in length."); //Throws an exception
		}
		this.Description = Description;
	}
}
