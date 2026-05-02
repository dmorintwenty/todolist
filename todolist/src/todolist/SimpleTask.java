package todolist;

import java.time.LocalDate;

/**
 * Represents a basic task with no extra fields
 * Extends Task
 */

public class SimpleTask extends Task {

	/**
	 * creates a new simple task
	 * @param title of the task
	 * @param description of the task
	 * @param dueDate of the task
	 */
	public SimpleTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
		
	}

	
	
	/**
	 *returns the simple task type
	 */
	@Override
	public String getTaskType() {
		return "Simple Task";
	}

	/**
     * returns task details
     */
	@Override
	public String getDetails() {
		return getTaskType() + ": " + title;
	}

}
