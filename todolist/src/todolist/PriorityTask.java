package todolist;

import java.time.LocalDate;

public class PriorityTask extends Task implements Prioritizable {

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
		return "Priority task";
	}

	@Override
	public String getDetails() {
		return getTaskType() + ": " + title + " - Priority: " + getPriority();
	}
}
