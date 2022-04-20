/* ----------------------------------------
 * Program: Task Service Classes Unit Test
 * Programmer: Jacob Sullivan
 * Date: 03/26/2022
 * Version: 1.0.0
 * ----------------------------------------
 */

package taskServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import taskService.Task;

import org.junit.jupiter.api.DisplayName;

//TaskTest class dedicated to testing of methods in Task class
class TaskTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//testTask method to test functional constructor in Task class
	@Test
	final void testTask() {
		
		//create Task object and pass it test parameters
		Task testTask = new Task("14513", "Set Up", "Set up IDE with new project to begin coding");
		
		//assert passed test params were properly stored in a new task object
		assertTrue(testTask.getTaskId().equals("14513"));
		assertTrue(testTask.getName().equals("Set Up"));
		assertTrue(testTask.getDescription().equals("Set up IDE with new project to begin coding"));
		
	}
	
	//testTaskIdTooLong method to test handling of an ID greater in length than
	//the specified requirements
	@Test
	final void testTaskIdTooLong() {
		
		//declaration of test strings
		String testId = "14502194907349017293099313";
		String testName = "Set Up";
		String testDescription = "Set up IDE with new project to begin coding";
		
		//assert an exception is thrown when Task(params) is passed these test strings
		//including an ID that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(testId, testName, testDescription);
		});
	}
	
	//testNullTaskId method to test handling of null ID parameter
	@Test
	final void testNullTaskId() {
		
		//declare id as null and assert an exception is thrown when
		//this value is passed to the task constructor
		String testId = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(testId, "Set Up", "Set up IDE with new project to begin coding");
		});
	}
	
	//testTaskIdTooLong method to test handling of a name greater in length than
	//the specified requirement
	@Test
	final void testTaskNameTooLong() {
		
		//assert an exception is thrown when Task(params) is passed these test strings
		//including a name that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("14513", "oiasndoinnasofnkasnlkdbqjwbdocionosmdklandkkwln", 
					"Set up IDE with new project to begin coding");
		});
	}
	
	//testNullTaskName method to test handling of null name parameter
	@Test
	final void testNullTaskName() {
		
		//declare name as null and assert an exception is thrown when
		//this value is passed to the task constructor
		String name = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("14513", name, "Set up IDE with new project to begin coding");
		});
	}
	
	//testTaskIdTooLong method to test handling of a description greater in length than
	//the specified requirement
	@Test
	final void testTaskDescriptionTooLong() {
		
		//assert an exception is thrown when Task(params) is passed these test strings
		//including a description that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("14513", "Set Up", "Set up IDE with new project to begin codingahoisdhiohaskndqlwkn lkndsa"
					+ "oaisdinasoidnionaindklnaksnkqwkdklwnldlefioihiodaiosjdalwkmdlknalknsklfnaklnskd");
		});
	}
	
	//testNullTaskDescription method to test handling of null description parameter
	@Test
	final void testNullTaskDescription() {
		
		//declare description as null and assert an exception is thrown when
		//this value is passed to the task constructor
		String testDescription = null;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("14513", "Set Up", testDescription);
		});
	}
	

}
