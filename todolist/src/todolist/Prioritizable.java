package todolist;

public interface Prioritizable {
	//TODO: Check returns in debug or console later in other parts of program to make sure the getter isn't just being useless here

	/**
	 * @param priority
	 */
	void setPriority(int priority);
		
	/**
	 * returns priority value
	 */
	int getPriority();

}
