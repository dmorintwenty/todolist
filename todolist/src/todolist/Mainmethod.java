package todolist;

/**
 * Main method
 * Creates a TaskManager and UI then starts the program
 */
public class Mainmethod {

	    public static void main(String[] args) {
	        TaskManager manager = new TaskManager();
	        UI menu = new UI(manager);

	        menu.start();
	    }
}


