/* ----------------------------------------
 * Program: Task Service Classes Unit Test
 * Programmer: Jacob Sullivan
 * Date: 03/26/2022
 * Version: 1.0.0
 * ----------------------------------------
 */

package taskService;

import java.util.List;
import java.util.ArrayList;

//Task service class handling operations done on/using task objects
public class TaskService {
	
	//create array list to hold task objects
	public static List<Task> taskList = new ArrayList<Task>();
	
	/* addTask method to create and add task objects to the array list
	 * @param String taskId - task unique ID
	 * @param String name - task name
	 * @param String description - task description
	 */
	public void addTask(String taskId, String name, String description) {
		
		//if array list is not empty, check to see if passed ID already
		//exists in the list. If so, throw an exception. This prevents
		//use of duplicate task id's, per the requirement they must be unique
		if (!(taskList.isEmpty())) {
			for (Task t:taskList) {
				if (t.getTaskId().equals(taskId)) {
					throw new IllegalArgumentException("Duplicate ID");
				}
			}
		}
		
		//create new task passing parameters to task constructor
		//add new task object to array list
		Task task = new Task(taskId, name, description);
		taskList.add(task);
		
	}
	
	/* deleteTask method to handle deletion of task objects from the array list
	 * @param String taskId - task unique ID
	 */
	public void deleteTask(String taskId) {
		
		//for block iterating through the array list to find the matching passed task id
		//if found, remove that object from the array list
		for (int i = 0; i < taskList.size(); i++) {
			Task t = taskList.get(i);
			if (t.getTaskId().equals(taskId)) {
				taskList.remove(i);
			}
		}
	}
	
	/* updateName method to handle updating name of an existing task
	 * @param String taskId - task unique ID
	 * @param String newName - new name to replace associated task's existing name
	 */
	public void updateName(String taskId, String newName) {
		
		//for block iterates through the array list to find the task with the
		//matching ID passed to the method. If found, newName is passed to name setter
		for (Task t:taskList) {
			if (t.getTaskId().equals(taskId)) {
				t.setName(newName);
			}
		}
	}
	
	/* updateName method to handle updating name of an existing task
	 * @param String taskId - task unique ID
	 * @param String newDescription - new name to replace associated task's existing description
	 */
	public void updateDescription(String taskId, String newDescription) {
		
		//for block iterates through the array list to find the task with the
		//matching ID passed to the method. If found, newDescription is passed to description setter
		for (Task t:taskList) {
			if (t.getTaskId().equals(taskId)) {
				t.setDescription(newDescription);
			}
		}
	}

}
