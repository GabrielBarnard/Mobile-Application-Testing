/*
 * Created by Gabriel Barnard
 * Created on the 29th of January 2026
 */


package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	@Test //@Test declares the start of a test
	void taskNormalValues() { //This tests the task constructor with normal (Expected) values
		Task task = new Task("ID1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a new task object
		
		assertTrue(task.getTaskID().equals("ID1")); //These asserTrue statements check if the values chosen above were stored in the task object correctly
		assertTrue(task.getName().equals("Feed Dog"));
		assertTrue(task.getDescription().equals("Feed dog dog food and turmeric powder"));
	}
	
	@Test 
	void taskIdOver10Characters() { //This tests if an exception is thrown when taskID is over 10 characters in length
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("Identity Document Number 1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a task object with a task ID over 10 characters in length
		});
		
		//I can't add a test that manually sets the taskID to something else, since the taskID is final - the code will not compile.
	}
	
	@Test 
	void taskIdNull() { //This tests if an exception is thrown when taskID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task(null, "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a task object with a null Task ID
		});
		
		//I can't add a test that manually sets the taskID to null. The task ID is final, so the code will not compile if I attempt to change it.
	}
	
	@Test 
	void NameOver20Characters() { //This tests if an exception is thrown when Name is over 20 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed a burmese dog some tasty dog food and some turmeric powder", "Feed dog dog food and turmeric powder"); //Creates a task object with an overly long Name
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a task object with normal (expected) values
			task.setName("Feed a burmese dog some tasty dog food and some turmeric powder"); //Modifies the Name to be over 20 characters in length
		});
	}
	
	@Test 
	void NameNull() { //Checks if an exception is thrown the Name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", null, "Feed dog dog food and turmeric powder"); //Creates a task object with a null Name
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for a exception
			Task task = new Task("ID1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a normal task object
			task.setName(null); //Sets the Name to null
		});
	}
	
	@Test
	void DescriptionOver50Characters() { //Checks if an exception is thrown the Description is over 50 characters in length
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed DOG", "Feed a burmese dog some tasty dog food and turmeric powder. Afterwards, consider taking it for a walk so that it can enjoy the sunshine. Also, give it a bath."); //Creates a task object with an overly long description 
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a regular task object
			task.setDescription("Feed a burmese dog some tasty dog food and turmeric powder. Afterwards, consider taking it for a walk so that it can enjoy the sunshine. Also, give it a bath."); //Sets the tasks description to an overly long description
		});
	}
	
	@Test 
	void DescriptionNull() { //Checks if an exception is thrown when Description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed Dog", null); //Creates a task object where the Description is null
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> { //Looks for an exception
			Task task = new Task("ID1", "Feed Dog", "Feed dog dog food and turmeric powder"); //Creates a regular task object
			task.setDescription(null); //Sets the description to null
		});
	}
	
	//I can't add tests to check if the variables in Task are required, because the variables are all used as constructor parameters. Therefore, if I try to make an object without them, the code will not compile.
}
