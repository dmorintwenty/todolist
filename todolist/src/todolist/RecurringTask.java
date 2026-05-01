package todolist;

import java.time.LocalDate;

public class RecurringTask extends Task implements Recurring {

    

    public RecurringTask(String title, String description, LocalDate dueDate, String pattern) {
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
		return "Recurring Task";
	}

	@Override
	public String getDetails() {
		return getTaskType() + ": " + title + " - Repeats: " + getRecurrencePattern();
	}
}
