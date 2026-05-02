package todolist;

/**
 * Interface for tasks that repeat on a schedule
 * Implemented by RecurringTask
 */

public interface Recurring {

	/** 
     * set recurrence pattern 
     */
    void setRecurrencePattern(String pattern);

    /** 
     * return recurrence pattern 
     */
    String getRecurrencePattern();

}
