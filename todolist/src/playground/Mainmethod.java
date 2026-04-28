package playground;

import todolist.TaskManager;
import todolist.UI;

/**
 * Main method
 */
public class Mainmethod {

	    public static void main(String[] args) {
	        TaskManager manager = new TaskManager();
	        UI menu = new UI(manager);

	        menu.start();
	    }
}


