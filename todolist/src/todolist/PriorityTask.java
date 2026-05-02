package todolist;

import java.time.LocalDate;

/**
 * Represents a task with a priority level
 * Extends Task and implements Prioritizable for inheritence
 * Priority is set on creation and can be updated and changed
 */
public class PriorityTask extends Task implements Prioritizable {

    
    /**
     * creates a new PriorityTask with a given priority
     * @param title of task
     * @param description of the task
     * @param dueDate of the task
     * @param priority of the task
     */
    public PriorityTask(String title, String description, LocalDate dueDate, int priority) {
        super(title, description, dueDate);
        this.priority = priority;
    }

    /**
     * sets the priority level
     */
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * returns the priority level
     */
    @Override
    public int getPriority() {
        return this.priority;
    }

    /**
     * returns the task type as a string
     */
    @Override
    public String getTaskType() {
        return "Priority task";
    }

    /**
     * returns task details including priority
     */
    @Override
    public String getDetails() {
        return getTaskType() + ": " + title + " - Priority: " + getPriority();
    }
}