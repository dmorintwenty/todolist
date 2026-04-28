package todolist;

import java.time.LocalDate;

public class PriorityTask extends Task {

	public PriorityTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
		
	}

	@Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return this.priority;
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
