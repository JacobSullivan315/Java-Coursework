/* ----------------------------------------
 * Program: Task Service Classes Unit Test
 * Programmer: Jacob Sullivan
 * Date: 03/26/2022
 * Version: 1.0.0
 * ----------------------------------------
 */


package taskService;

//Task class handling creation of task objects
public class Task {
	
	//declaration of used variables
	private String taskId;
	private String name;
	private String description;
	
	//constructor creating task objects to assign passed parameters as attribute values
	public Task(String taskId, String name, String description) {
		
		//if block handling requirement checks for passed value of task ID
		//can't be null or greater than 10 characters in length
		//if so, throws exception
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid Task Id");
		}
		
		//if block handling requirement checks for passed value of task name
		//can't be null or greater than 20 characters in length
		//if so, throws exception
		if (name == null || name.length() > 20 ) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		
		//if block handling requirement checks for passed value of task description
		//can't be null or greater than 50 characters in length
		//if so, throws exception
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		//assignment of verified parameters to attributes to creat a task object
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}

	//"Getter" and "Setter" methods for attributes of task objects
	//"Setters" also include validation if blocks to ensure passed parameter
	//meets the required specifications
	public String getTaskId() {
		return taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if (name.length() > 20 || name == null) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		
		if (description.length() > 50 || description == null) {
			throw new IllegalArgumentException("Invalid Description.");
		}
		
		this.description = description;
	}

	
}
