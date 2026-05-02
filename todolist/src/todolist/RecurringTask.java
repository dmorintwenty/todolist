package todolist;

import java.time.LocalDate;

/**
 * Represents a task that repeats more than once something like a weekly chore
 * Extends Task and implements Recurring
 */
public class RecurringTask extends Task implements Recurring {

    
	/**
	 * creates a new RecurringTask with a recurrence pattern
	 * @param title of the task 
	 * @param description of the task
	 * @param dueDate of the task
	 * @param pattern of the task
	 */
	public RecurringTask(String title, String description, LocalDate dueDate, String pattern) {
		super(title, description, dueDate);
		this.recurrencePattern = pattern;
		
	}

	/**
	 *sets recurrence pattern
	 */
	@Override
    public void setRecurrencePattern(String pattern) {
        this.recurrencePattern = pattern;
    }

    /**
     *returns the recurrencePattern
     */
    @Override
    public String getRecurrencePattern() {
        return recurrencePattern;
    }

	/**
	 *returns the task type of recurring task
	 */
	@Override
	public String getTaskType() {
		return "Recurring Task";
	}

	/**
	 *returns task details
	 */
	@Override
	public String getDetails() {
		return getTaskType() + ": " + title + " - Repeats: " + getRecurrencePattern();
	}
}
