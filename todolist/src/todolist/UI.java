package todolist;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * 
 */
public class UI {

    private TaskManager manager;
    private Scanner scnr;

    public UI(TaskManager manager) {
        this.manager = manager;
        this.scnr = new Scanner(System.in);
    }

    //program entry, yay!!
    public void start() {
        boolean running = true;

        while (running) {

            printMenu();

            int choice = scnr.nextInt();
            scnr.nextLine(); // consume newline

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

    //menu

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

    // UI methods

    private void addTaskUI() {

        System.out.print("Enter title: ");
        String title = scnr.nextLine();

        System.out.print("Enter description: ");
        String desc = scnr.nextLine();

        LocalDate date = null;
        
        //anti-crash date input implementation
        while (date == null) {
            System.out.print("Enter due date (YYYY-MM-DD): ");
            String input = scnr.nextLine();
            
            //hoping the catch prevents crash in multiple cases, try and break it
            try {
                date = LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid format. Please use YYYY-MM-DD (example: 2026-11-18)");
            }

        System.out.println("Task type (simple/priority/recurring): ");
        String type = scnr.nextLine();

        Task task;

        if (type.equalsIgnoreCase("priority")) {
            System.out.print("Enter priority (1-5): ");
            int priority = scnr.nextInt();
            scnr.nextLine();

            task = new PriorityTask(title, desc, date, priority);

        } else if (type.equalsIgnoreCase("recurring")) {
            System.out.print("Enter recurrence pattern: ");
            String pattern = scnr.nextLine();

            task = new RecurringTask(title, desc, date, pattern);

        } else {
            task = new SimpleTask(title, desc, date);
        }

        manager.addTask(task);
        System.out.println("Task added.");
    }
    }
    
    //UI methods are sorted in switch case order for your convenience
    
    /**
     * 
     */
    private void viewAllTasksUI() {
    	manager.displayAllTasks();
        
    }
    
    /**
     * 
     */
    private void completeTaskUI() {
        System.out.print("Enter task index to complete: ");
        int index = scnr.nextInt();
        scnr.nextLine();

        manager.completeTask(index);
        System.out.println("Task marked as complete.");
    }
    
    private void removeTaskUI() {
        System.out.print("Enter task index to remove: ");
        int index = scnr.nextInt();
        scnr.nextLine();

        manager.removeTask(index);
        System.out.println("Task removed.");
    }
    
    private void undoLastActionUI() {
        manager.undoLastAction();
    }
    
    private void loadTodayTasksUI() {
        manager.loadTodaysTasks();
        System.out.println("Today's recurring tasks loaded into queue.");
    }
    
    private void viewQueueUI() {
        manager.displayQueue();
    }
    
    private void processNextTaskUI() {
        manager.processNextTask();
    }
    
    
    private void filterTasksUI() {

        System.out.println("Filter by:");
        System.out.println("1. Status");
        System.out.println("2. Type");
        System.out.println("3. Priority");

        int choice = scnr.nextInt();
        scnr.nextLine();

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
                int priority = scnr.nextInt();
                scnr.nextLine();

                manager.filterByPriority(priority);
                break;

            default:
                System.out.println("Invalid filter option.");
        }
    }
}
        
        	