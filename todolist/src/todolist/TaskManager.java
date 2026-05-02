package todolist;
//our core logic controller 

/**
 * Core logic controller for the todo list
 * Manages all tasks using custom data structures
 */
public class TaskManager {

    private CustomArrayList<Task> tasks;
    private CustomStack<String> undoActionStack;
    private CustomStack<Task> undoTaskStack;
    private CustomQueue<Task> queue;

    
    /**
     * returns the number of tasks stored
     * for checking if there are any tasks stored (UI Implementation)
     */
    public int getTasksSize() {
    	return tasks.size();
    }
    
    /**
     * initializes all data structures
     */    
    public TaskManager() {
    	tasks = new CustomArrayList<>();
    	undoActionStack = new CustomStack<>();
        undoTaskStack = new CustomStack<>();
        queue = new CustomQueue<>();
    	
          }

    /**
     * adds a task and tracks it for undo
     */
    public void addTask(Task task) {
        tasks.add(task);
      //need to track the action so we can undo in a stack
        undoActionStack.push("Add");
        undoTaskStack.push(task);
    }

    
    /**
     * removes a task at given index and tracks it for undo
     */
    public void removeTask(int index) {
    	
    //if statements so that we don't have crashes in case accidental index.
    	if (tasks.size() == 0) {
            System.out.println("No tasks to remove.");
            return;
    	}
    	if (index < 0 || index>= tasks.size()) {
        	System.out.println("Invalid index, go check you task list and make sure the number is right.");
        	return;
    	}
    	
    	//need to save the task as an object task before removing so we could undo if needed.
    	Task task = tasks.get(index);
    	undoActionStack.push("Remove");
        undoTaskStack.push(task);
        tasks.remove(index);
        System.out.println("Task removed.");

    }

    
    /**
     * marks a task complete at given index and tracks it for undo
     */
    public void completeTask(int index) {
        //if statements so that we don't have crashes in case accidental index.
    	if (tasks.size() == 0) {
            System.out.println("No tasks to complete.");
            return;
        }
    	if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid index.");
            return;
        }
    //once again need to save for undos.
    	Task task = tasks.get(index);
    	undoActionStack.push("Complete");
        undoTaskStack.push(task);
        task.markComplete();
        System.out.println("Task marked as complete.");
    }

    /**
     * prints all tasks with their index
     */
    public void displayAllTasks() {
        if (tasks.size() == 0) {
        	System.out.println("\n No tasks saved at the moment.");
        }
    	for(int i = 0; i < tasks.size(); i++) {
    	//clean print statement so any user can understand the index
    	System.out.println((i+1) + ". " + tasks.get(i));        }
    }

    
    /**
     * reverses the most recent add, remove, or complete action
     */
    public void undoLastAction() {
    	if (undoActionStack.isEmpty()) {
            System.out.println("You have Nothing to undo!");
            return;
    	} 
            Task task = undoTaskStack.pop();
            String action = undoActionStack.pop();
        //do the opposite to undo the action for example to undo a add you remove
        //with clean print statement so that user isn't in the dark
        if(action.equals("Add")) {
        	tasks.removeElement(task);
          System.out.println("Undo successful! Task removed.");

        }
        else if (action.equals("Remove")){
        	tasks.add(task);
          System.out.println("Undo successful! Task added back.");

        }
        else if (action.equals("Complete")) {
        	task.completed = false;
          System.out.println("Undo successful! Task marked incomplete.");

        }
            
    }
    /**
     * clears queue and loads all recurring tasks into it
     */
    public void loadTodaysTasks() {
    	//need a new queue that acts as the clear
        queue = new CustomQueue<>();
        for(int i = 0; i<tasks.size(); i++) {
        	if(tasks.get(i).getTaskType().equals("Recurring Task")) {
        		queue.enqueue(tasks.get(i));//Adds recurring type to queue
        	}
        }
        
    }
    
    /**
     * removes and displays the next task in the queue
     */
    public void processNextTask() {
    	if(queue.isEmpty()) {
    		System.out.println("No more new tasks, you have time add some more tasks today");
    	}
    	else {
    		Task task = queue.dequeue();
    		System.out.println(task + " has been removed because it is completed");
    	}
    }
    
    //These next methods we need to filter the tasks by there priority,
    //this will be status, type, Priority and then only print those ones
    
    //filtering by status
    public void filterByStatus(boolean completed) {
    	for(int i = 0; i< tasks.size(); i++) {
    		if(tasks.get(i).isCompleted() == completed) {
    			System.out.println(tasks.get(i));
    		}
    	}
    }
    // filtering by type
    public void filterByType(String type) {
    	for(int i = 0; i< tasks.size(); i++) {
    		 if (tasks.get(i).getTaskType().equals(type)) {
    	            System.out.println(tasks.get(i));
    		 }
    	}
    }
    //filtering by priority
    public void filterByPriority(int priority) {
    	for(int i = 0; i< tasks.size(); i++) {
    		if(tasks.get(i).getPriority() == priority) {
    			System.out.println(tasks.get(i));
    		}
    		
    	}

    }
    
    /**
     * displays all tasks currently in the queue
     * found great example of this online
     */
    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        CustomQueue<Task> temp = new CustomQueue<>();

        System.out.println("Task Queue");

        while (!queue.isEmpty()) {
            Task task = queue.dequeue();
            System.out.println(task);
            temp.enqueue(task);
        }

        // restore queue
        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }
        
    }
    
    /**
     * returns true if queue is empty
     */
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}
