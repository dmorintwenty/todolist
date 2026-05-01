package todolist;
//our core logic controller 

// this will definitely be needed later as we build task data and memory --> import todolist.data.*;

public class TaskManager {

    private CustomArrayList<Task> tasks;
    private CustomStack<String> undoActionStack;
    private CustomStack<Task> undoTaskStack;
    private CustomQueue<Task> queue;

    
    // data structures we will need
    public TaskManager() {
    	tasks = new CustomArrayList<>(); // holds all tasks
    	undoActionStack = new CustomStack<>(); // tracks actions for undo
        undoTaskStack = new CustomStack<>(); // tracks tasks for undo
        queue = new CustomQueue<>(); // holds the tasks
    	
          }

    public void addTask(Task task) {
        tasks.add(task);
      //need to track the action so we can undo in a stack
        undoActionStack.push("Add");
        undoTaskStack.push(task);
    }

    public void removeTask(int index) {
    	//need to save the task as an object task before removing so we could undo if needed.
    	Task task = tasks.get(index);
    	undoActionStack.push("Remove");
        undoTaskStack.push(task);
        tasks.remove(index);
    }

    public void completeTask(int index) {
    	Task task = tasks.get(index);
    	undoActionStack.push("Complete");
        undoTaskStack.push(task);
        task.markComplete();

    }

    public void displayAllTasks() {
        for(int i = 0; i < tasks.size(); i++) {
        System.out.println("Tasks " + tasks.get(i));
        }
    }

    public void undoLastAction() {
    	if (undoActionStack.isEmpty()) {
            System.out.println("You have Nothing to undo!");
            return;
    	}
            Task task = undoTaskStack.pop();
            String action = undoActionStack.pop();
        //do the opposite to undo the action for example to undo a add you remove
        if(action.equals("Add")) {
        	tasks.removeElement(task);
        }
        else if (action.equals("Remove")){
        	tasks.add(task);
        }
        else if (action.equals("Complete")) {
        	task.completed = false;
        }
            
    }

    public void loadTodaysTasks() {
    	//need a new queue that acts as the clear
        queue = new CustomQueue<>();
        for(int i = 0; i<tasks.size(); i++) {
        	if(tasks.get(i).getTaskType().equals("Recurring Task")) {
        		queue.enqueue(tasks.get(i));//Adds recurring type to queue
        	}
        }
        
    }

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
}
