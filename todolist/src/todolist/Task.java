package todolist;
import java.time.LocalDate;

//split methods as follows
/*
 * simpletask
 * prioritytask
 * recurringtask
 */
public abstract class Task {
	
	protected String title;
    protected String description;
    protected boolean completed;
    protected LocalDate dueDate;
	protected int priority;
	protected String recurrencePattern;

	public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // the core of the class, will mark tasks as complete, still WIP kinda
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
