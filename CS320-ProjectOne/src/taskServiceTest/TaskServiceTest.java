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
import taskService.TaskService;

//TaskServiceTest class dedicated to testing methods in TaskService class
class TaskServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	//after each test, empty the array list to start fresh for next test
	@AfterEach
	void tearDown() throws Exception {
		TaskService.taskList.removeAll(TaskService.taskList);
	}

	//testAddTask method to test creation and storage of tasks in the array list
	@Test
	final void testAddTask() {
		
		//create TaskService object and use to pass test strings to addTask method
		TaskService test = new TaskService();
		test.addTask("151413", "Task One", "The First Task");
		
		//Assertions to successful creation of task object and successful addition to the array list
		assertTrue(!(TaskService.taskList.isEmpty()));
		assertEquals(TaskService.taskList.get(0).getTaskId(), "151413");
		assertEquals(TaskService.taskList.get(0).getName(), "Task One");
		assertEquals(TaskService.taskList.get(0).getDescription(), "The First Task");
		
	}
	
	//testAddMultipleTasks method to test creation and storage of multiple tasks in the array list
	@Test
	final void testAddMultipleTasks() {
		
		//create new TaskService object and use to pass test strings to addTask, creating
		//3 test task objects and adding them to the array list
		TaskService test = new TaskService();
		test.addTask("151413", "Task One", "The First Task");
		test.addTask("144516", "Task Two", "The Second Task");
		test.addTask("166879", "Task Three", "The Third Task");
		
		//assign list size to a variable for comparison test
		//assert list size is equal to amount of test objects created
		final int listSize = TaskService.taskList.size();
		assertEquals(3, listSize);
		
		//Assertions validating strings passed were assigned correctly to
		//created test objects upon creation and storage
		assertEquals(TaskService.taskList.get(0).getTaskId(), "151413");
		assertEquals(TaskService.taskList.get(1).getTaskId(), "144516");
		assertEquals(TaskService.taskList.get(2).getTaskId(), "166879");
		
		assertEquals(TaskService.taskList.get(0).getName(), "Task One");
		assertEquals(TaskService.taskList.get(1).getName(), "Task Two");
		assertEquals(TaskService.taskList.get(2).getName(), "Task Three");
		
		assertEquals(TaskService.taskList.get(0).getDescription(), "The First Task");
		assertEquals(TaskService.taskList.get(1).getDescription(), "The Second Task");
		assertEquals(TaskService.taskList.get(2).getDescription(), "The Third Task");
	}
	
	//duplicateIdTest to ensure passing a duplicate ID throws an exception 
	@Test
	final void duplicateIdTest() {
		
		//create new TaskService object and use to pass strings to addTask
		TaskService test = new TaskService();
		test.addTask("151413", "Task One", "The First Task");
		
		//Assert exception thrown if same ID is passed again
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			test.addTask("151413", "Task Two", "The Second Task");
		});
		
	}
	
	//tastDeleteTask method to test removal of task objects from the array list
	@Test
	final void testDeleteTask() {
		
		//create new TaskService object and use to pass strings to addTask
		//Dev Note: created string to avoid error message, can be reworked
		TaskService test = new TaskService();
		String taskId = "151413";
		
		test.addTask(taskId, "Task One", "The First Task");
		
		//assert the list is not empty 
		assertTrue(!(TaskService.taskList.isEmpty()));
		
		//if array list is not empty, pass the test ID to deleteTask method
		if(!(TaskService.taskList.isEmpty())) {
			test.deleteTask(taskId);
			
		}
		
		//assert the list is now empty
		assertTrue(TaskService.taskList.isEmpty());
	}
	
	//testUpdateName method to test updating of specific task objects name attribute
	@Test
	final void testUpdateName() {
		
		//create new TaskService object and use to pass strings to addTask
		TaskService test = new TaskService();
		test.addTask("151413", "Task One", "The First Task");
		
		//pass created test tasks id and new name to updateName method
		test.updateName("151413", "Task Two");
		
		//assert task's name is now equal to the passed replacement name
		assertEquals(TaskService.taskList.get(0).getName(), "Task Two");
	}
	
	//testUpdateDescription method to test updating of task's description
	@Test
	final void testUpdateDescription() {
		
		//create new TaskService object and use to pass strings to addTask
		TaskService test = new TaskService();
		test.addTask("151413", "Task One", "The First Task");
		
		//pass created test tasks ID and new description to updateDescription method
		test.updateDescription("151413", "A new description");
		
		//assert test tasks description is now the passed updated description
		assertEquals(TaskService.taskList.get(0).getDescription(), "A new description");
	}

}
