package todolist;

import java.util.Scanner;

//didn't know about this but need it for the localDate for the "tasks"
import java.time.LocalDate;

public class UI {

    private TaskManager manager;

    public UI(TaskManager manager) {
        this.manager = manager;
    }

    public void ui() {
        Scanner scnr = new Scanner(System.in);

        int choice = 0;

        while (choice != 10) {
        	
       //printing the 10 choices for the user interface	
        	System.out.println("Choose one option");
        	System.out.println("1. Add Task" );
        	System.out.println("2. View All Tasks");
        	System.out.println("3. Complete Task");
        	System.out.println("4. Remove Task");
        	System.out.println("5. Undo Last Action");
        	System.out.println("6. Load todays Task");
        	System.out.println("7. View Task Queue");
        	System.out.println("8. Process Next Task");
        	System.out.println("9. Filter Tasks");
        	System.out.println("10. Exit");
        	
            choice = scnr.nextInt();

        	        	
        switch (choice) {
        
        case 1:
        	
        }








        }
    }

    
}
