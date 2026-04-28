package todolist;

import java.time.LocalDate;

public class RecurringTask extends Task {

    

    public RecurringTask(String title, String description, LocalDate dueDate) {
		super(title, description, dueDate);
		
	}

	@Override
    public void setRecurrencePattern(String pattern) {
        this.recurrencePattern = pattern;
    }

    @Override
    public String getRecurrencePattern() {
        return recurrencePattern;
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
