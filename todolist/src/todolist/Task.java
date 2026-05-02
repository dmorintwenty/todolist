package todolist;
import java.time.LocalDate;

/**
 * Abstract base class for all task types
 * SimpleTask, PriorityTask, and RecurringTask all extend this class
 */
public abstract class Task {
	
	protected String title;
    protected String description;
    protected boolean completed;
    protected LocalDate dueDate;
	protected int priority;
	protected String recurrencePattern;

	 /**
     * creates a new Task
     * @param title the task title
     * @param description the task description
     * @param dueDate the due date
     */
	public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // the core of the class, will mark tasks as complete
    public void markComplete() {
      completed = true; 
    }

    // getters
    public String getTitle() { 
    	
    	return title; }
    
    public String getDescription() { 
    	
    	return description; }
    
    public boolean isCompleted() { 
    	
    	return completed; }
    
    public LocalDate getDueDate() { 
    	
    	return dueDate; }
    

    // will allow us to create our task based on specs
    public abstract String getTaskType();
   
    public abstract String getDetails();

    
    // .tostring function
    public String toString() {
    	return title + " on " + dueDate + " - Completed: " + completed;
    	}
	

	//prioritytask interface methods
	public void setPriority(int priority) {
	
		
	}

	public int getPriority() {
		
		return 0;
	}

	//recurringtask interface methods
	public void setRecurrencePattern(String pattern) {
		
	}

	public String getRecurrencePattern() {
		return null;
	}
	
}
