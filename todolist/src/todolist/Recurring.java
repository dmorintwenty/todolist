package todolist;

public interface Recurring {
	//TODO: Check returns in debug or console later in other parts of program to make sure the getter isn't just being useless here

	/** 
     * set recurrence pattern 
     */
    void setRecurrencePattern(String pattern);

    /** 
     * return recurrence pattern 
     */
    String getRecurrencePattern();

}
