/*
 * Created by Gabriel Barnard
 * Created on the 29th of January 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.TaskService;

class TaskServiceTest {

	@Test //@Test declares the start of a test
	void addTask() { //Tests whether the addTask method works correctly
		TaskService taskService = new TaskService(); //Creates a new TaskService object taskService
		taskService.addTask("ID1"); //Adds a task with ID1
		
		assertTrue(taskService.tasks.get("ID1").getTaskID().equals("ID1")); //These assertTrue's check if the task was properly created by checking if each of its variables are the same as the ones declared in addTask and in the taskID
		assertTrue(taskService.tasks.get("ID1").getName().equals("Default Name"));
		assertTrue(taskService.tasks.get("ID1").getDescription().equals("Default Description"));
	}
	
	@Test
	void addMultipleTasks() { //Tests if the addTask method work correctly when adding multiple tasks
		TaskService taskService = new TaskService(); //Creates new TaskService object
		taskService.addTask("ID1"); //Adds tasks ID1 and ID2
		taskService.addTask("ID2");
		
		assertTrue(taskService.tasks.get("ID1").getTaskID().equals("ID1")); //These assertTrue's check if the ID1 values are correct
		assertTrue(taskService.tasks.get("ID1").getName().equals("Default Name"));
		assertTrue(taskService.tasks.get("ID1").getDescription().equals("Default Description"));
		
		assertTrue(taskService.tasks.get("ID2").getTaskID().equals("ID2")); //These assertTrue's check if the ID2 values are correct
		assertTrue(taskService.tasks.get("ID2").getName().equals("Default Name"));
		assertTrue(taskService.tasks.get("ID2").getDescription().equals("Default Description"));
		
	}
	
	@Test 
	void addDuplicateTask() { //Tests if the addTask method throws an exception when trying to add 2 tasks with the same ID
		TaskService taskService = new TaskService(); //Creates new TaskService object
		taskService.addTask("ID1"); //Adds task with task ID ID1
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			taskService.addTask("ID1"); //Tries to add task with task ID ID1 again
		});
	}
	
	@Test
	void retrieveTask() { //This test checks if a task is retrievable by setting the Name and Description in one task to the name and description of a previous task by referencing that task via the tasks HashMap
		TaskService taskService = new TaskService(); //Creates new TaskService object
		taskService.addTask("ID1"); //Creates task with taskID ID1
		taskService.updateTask("ID1", "Updated Name", "Updated Description"); //Updates the Name and Description of the task with task ID1
		
		taskService.addTask("ID2");
		taskService.updateTask("ID2", taskService.tasks.get("ID1").getName(), taskService.tasks.get("ID1").getDescription()); //Creates a new task with TaskID ID2, with the Name and Description taken from ID1
		
		assertTrue(taskService.tasks.get("ID2").getTaskID().equals("ID2")); //Checks if taskID ID2 retained the taskID ID2 and if the Name and Description were set to that of ID1
		assertTrue(taskService.tasks.get("ID2").getName().equals("Updated Name"));
		assertTrue(taskService.tasks.get("ID2").getDescription().equals("Updated Description"));
	}	
	
	@Test
	void deleteTask() { //Tests if the deleteTask function works properly by checking if deleting a task does not throw an exception and by checking an exception is thrown when trying to delete a task twice
		TaskService taskService = new TaskService(); //Creates new TaskService object
		taskService.addTask("ID1"); //Adds a task 
		
		Assertions.assertDoesNotThrow(() -> { //Checks if an exception is NOT thrown
			taskService.deleteTask("ID1"); //Deletes the task
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			taskService.deleteTask("ID1"); //Tries to delete the task again. If the task was properly deleted last time, an exception will be thrown
		});
	}
	
	@Test
	void updateTask() { //This test checks if the updateTask method works properly 
		TaskService taskService = new TaskService(); //Creates new TaskService object
		taskService.addTask("ID1"); //Adds a task 
		
		taskService.updateTask("ID1", "Feed dog", "Feed dog dog food and turmeric powder"); //Updates the task with a new Name and Description
		
		assertTrue(taskService.tasks.get("ID1").getTaskID().equals("ID1")); //These assertTrue's check if the task's parameters were changed
		assertTrue(taskService.tasks.get("ID1").getName().equals("Feed dog"));
		assertTrue(taskService.tasks.get("ID1").getDescription().equals("Feed dog dog food and turmeric powder"));
	}
	
	@Test
	void updateNonExistingTask() { //Tests if an exception is thrown when trying to update a task that does not exist
		TaskService taskService = new TaskService(); //Creates a new TaskService object
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			taskService.updateTask("ID1", "Feed dog", "Feed dog dog food and turmeric powder"); //Tries to update a task (that does not exist)
		});
	}
}
