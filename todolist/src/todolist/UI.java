package todolist;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * Command line interface for the todo list
 * Handles all user input and calls TaskManager methods
 */
public class UI {

    private TaskManager manager;
    private Scanner scnr;

    
    /**
     * creates a new UI with a TaskManager
     */
    public UI(TaskManager manager) {
        this.manager = manager;
        this.scnr = new Scanner(System.in);
    }

    /**
     * starts the main menu loop, runs until user exits
     */
    public void start() {
        boolean running = true;
        int choice;
        while (running) {

            printMenu();

            //needed try statement or a String or any other input would crash system
            try {
            	choice = scnr.nextInt();
            	scnr.nextLine();
            } catch (Exception e) {
            	System.out.println("Invalid input, please enter a number 1-10.");
                scnr.nextLine(); // consume newline
                continue; 
            }

            switch (choice) {

                case 1:
                    addTaskUI();
                    break;

                case 2:
                    viewAllTasksUI();
                    break;

                case 3:
                    completeTaskUI();
                    break;

                case 4:
                    removeTaskUI();
                    break;

                case 5:
                    undoLastActionUI();
                    break;

                case 6:
                    loadTodayTasksUI();
                    break;

                case 7:
                    viewQueueUI();
                    break;

                case 8:
                    processNextTaskUI();
                    break;

                case 9:
                    filterTasksUI();
                    break;

                case 10:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scnr.close();
    }

    
    /**
     * prints the main menu options
     */
    private void printMenu() {
        System.out.println("\nChoose one option");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Remove Task");
        System.out.println("5. Undo Last Action");
        System.out.println("6. Load today's Task");
        System.out.println("7. View Task Queue");
        System.out.println("8. Process Next Task");
        System.out.println("9. Filter Tasks");
        System.out.println("10. Exit");
        System.out.print("Choice: ");
    }

    /**
     * handles adding a new task, prompts for type and details
     * validates date, task type, priority range, and recurrence pattern
     */
    private void addTaskUI() {

        System.out.print("Enter title: ");
        String title = scnr.nextLine();

        System.out.print("Enter description: ");
        String desc = scnr.nextLine();

        LocalDate date = null;

        while (date == null) {
            System.out.print("Enter due date (YYYY-MM-DD): ");
            String input = scnr.nextLine();

            //needed try and catch so invalid inputs do not cause a crash
            try {
                date = LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid format. Please use YYYY-MM-DD.");
            }
        }

        String type = null;
        Task task;

        while (type == null) {

            System.out.println("Task type (simple/priority/recurring): ");
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("simple")
                    || input.equalsIgnoreCase("priority")
                    || input.equalsIgnoreCase("recurring")) {

                type = input.toLowerCase();

            } else {
                System.out.println("Invalid type. Please enter: simple, priority, or recurring.");
            }
        }
        
        if (type.equals("priority")) {
        	int priority = 0;
            
            //needed try and catch exception to prevent a crash if misinput
            while (priority < 1 || priority > 5) {
                System.out.print("Enter priority (1-5): ");
                // try so that the integer is between 1-5
                try {
                    priority = scnr.nextInt();
                    scnr.nextLine();
                    if (priority < 1 || priority > 5) {
                        System.out.println("Priority must be between 1 and 5.");
                    }
                    // catch for a non integer input so a letter doesn't crash anything
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number 1-5.");
                    scnr.nextLine();
                }
            }

            task = new PriorityTask(title, desc, date, priority);

        } 
        
        else if (type.equals("recurring")) {

        	String pattern = null;
            while (pattern == null) {
            	
            System.out.print("Enter recurrence pattern:");
            String input = scnr.nextLine();
            //needed if statement for a missinput and no crash
            if (input.equalsIgnoreCase("daily")
                    || input.equalsIgnoreCase("weekly")
                    || input.equalsIgnoreCase("monthly")
                    || input.equalsIgnoreCase("yearly")) {
            
                pattern = input.toLowerCase();
            
            }else {
                System.out.println("Invalid pattern. Please enter: daily, weekly, monthly, or yearly.");
            }
           }
        
            task = new RecurringTask(title, desc, date, pattern);
        } 
        else {

            task = new SimpleTask(title, desc, date);
        }

        manager.addTask(task);
        System.out.println("Task added.");
    }
    
    
    /**
     * displays all tasks
     *UI methods are sorted in switch case order for your convenience
     */
    private void viewAllTasksUI() {
    	manager.displayAllTasks();
        
    }
    
    /**
     * prompts for index and marks task as complete
     */
    private void completeTaskUI() {
        System.out.print("Enter task index to complete: ");
        //need the try catch like every other method because of invalid inputs lead to a crash
        try {
        	int index = scnr.nextInt();
            scnr.nextLine();
            
            //need minus one because we added to the UI print for user ease
            manager.completeTask(index - 1);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scnr.nextLine();
        }

    }
    
    /**
     * prompts for index and removes task
     */
    private void removeTaskUI() {
        System.out.print("Enter task index to remove: ");
        //need the try/catch here aswell
        try {
        	int index = scnr.nextInt();
            scnr.nextLine();
            //need minus one because we added to the UI print for user ease
            manager.removeTask(index - 1);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scnr.nextLine();
        }
    }
    
    /**
     * undoes the last action
     */
    private void undoLastActionUI() {
        manager.undoLastAction();
    }
    
    
    /**
     * loads all recurring tasks into the queue
     */
    private void loadTodayTasksUI() {
        manager.loadTodaysTasks();
        System.out.println("Today's recurring tasks loaded into queue.");
    }
    
    /**
     * displays all tasks in the queue
     */
    private void viewQueueUI() {
        manager.displayQueue();
    }
    
    /**
     * processes the next task in the queue
     * marks it as complete based on user input
     */
    private void processNextTaskUI() {
        if (manager.isQueueEmpty()) {
            System.out.println("No more new tasks, you have time add some more tasks today");
            return;
        }
        manager.processNextTask();
        System.out.print("Mark this task as complete? (yes/no): ");
        String answer = scnr.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Task marked as complete.");
        }
    }
    
    /**
     * prompts user to filter by status, type, or priority
     */
    private void filterTasksUI() {

        System.out.println("Filter by:");
        System.out.println("1. Status");
        System.out.println("2. Type");
        System.out.println("3. Priority");

        int choice = 0;
        // try/catch to avoid a missinput crash
        try {
            choice = scnr.nextInt();
            scnr.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scnr.nextLine();
            return;
        }

        switch (choice) {

            case 1:
                System.out.print("Show completed tasks? (true/false): ");
                boolean status = scnr.nextBoolean();
                scnr.nextLine();

                manager.filterByStatus(status);
                break;

            case 2:
                System.out.print("Enter task type: ");
                String type = scnr.nextLine();

                manager.filterByType(type);
                break;

            case 3:
                System.out.print("Enter priority level: ");
               
                // try/catch to avoid a missinput crash
                try {
                	int priority = scnr.nextInt();
                    scnr.nextLine();
                    manager.filterByPriority(priority);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scnr.nextLine();
                }
                break;

            default:
                System.out.println("Invalid filter option.");
        }
    }
}
        
        	