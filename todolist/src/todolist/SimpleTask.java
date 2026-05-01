package todolist;

import java.time.LocalDate;

public class SimpleTask extends Task {

	public SimpleTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
		
	}

	
	
	@Override
	public String getTaskType() {
		return "Simple Task";
	}

	@Override
	public String getDetails() {
		return getTaskType() + ": " + title;
	}

}
