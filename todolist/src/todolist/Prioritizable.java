package todolist;

/**
 * Interface for tasks that have a priority level
 * Implemented by PriorityTask
 */

public interface Prioritizable {

	/**
	 * @param priority
	 */
	void setPriority(int priority);
		
	/**
	 * returns priority value
	 */
	int getPriority();

}
