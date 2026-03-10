/*
 * Created by Gabriel Barnard
 * Created on the 29th of January 2026
 */

package main;

import java.util.HashMap; //Imports the HashMap package

public class TaskService {
	public HashMap<String, Task> tasks = new HashMap(); //Creates a HashMap called tasks that takes a String (For the taskID) and a Task (for the Task object)
	
	//Method for adding a new task
	public void addTask(String taskID) {
		if (tasks.containsKey(taskID)) { //Searches the tasks HashMap to see if it contains the task ID selected in the parameter
			throw new IllegalArgumentException("To add a task, its taskID must be unique"); //Throws an exception
		}
		Task task = new Task(taskID, "Default Name", "Default Description"); //Creates a new task object, with the user's selected taskID and some default values for Name and Description
		tasks.put(taskID, task); //Puts the newly created task into the HashMap as a value, with the taskID as the key
	}
	
	//Method for deleting a task 
	public void deleteTask(String taskID) {
		if (!tasks.containsKey(taskID)) { //Checks if the tasks HashMap does not contain the taskID
			throw new IllegalArgumentException("To delete a task, you must use a valid task ID"); //Throws an exception
		}
		tasks.remove(taskID); //Removes the task from the HashMap by accessing it with its key (taskID)
	}
	
	//Method for updating a task
	public void updateTask(String taskID, String Name, String Description) {
		if (!tasks.containsKey(taskID)) { //Checks if the tasks HashMap does not contain the taskID
			throw new IllegalArgumentException("To update a task, you must use a valid task ID"); //Throws an exception
		}
		Task task = tasks.get(taskID); //Gets the task object from the HashMap by using the taskID. Any changes made to this task object will also affect the one in the HashMap
		
		task.setName(Name); //Sets the task's Name to the name set in the parameter
		task.setDescription(Description); //Sets the task's Description to the Description set in the parameter
	}
}
