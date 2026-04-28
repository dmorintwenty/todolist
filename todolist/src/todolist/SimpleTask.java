package todolist;

import java.time.LocalDate;

public class SimpleTask extends Task {

	public SimpleTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
		
	}

	
	
	@Override
	public String getTaskType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
