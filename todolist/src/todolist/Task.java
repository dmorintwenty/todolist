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

    // the core of the class, could be used to change booleans
    public void markComplete() {
       
    }

    // getters
    public String getTitle() { 
    	
    	return null; }
    
    public String getDescription() { 
    	
    	return null; }
    
    public boolean isCompleted() { 
    	
    	return false; }
    
    public LocalDate getDueDate() { 
    	
    	return null; }
    

    // will allow us to create our task based on specs
    public abstract String getTaskType();
   
    public abstract String getDetails();

    
    // .tostring function
    public String toString() {
        return null;
        
    }
	
	
	//prioritytask interface methods
	public void setPriority(int priority) {
	
		
	}

	public int getPriority() {
		
		return 0;
	}

	//recurringtask interface methods
	public void setRecurrencePattern(String pattern) {
		// TODO Auto-generated method stub
		
	}

	public String getRecurrencePattern() {
		// TODO Auto-generated method stub
		return null;
	}

}
