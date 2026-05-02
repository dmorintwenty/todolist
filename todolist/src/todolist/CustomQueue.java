package todolist;

/**
 * Custom implementation of a Queue
 * Follows FIFO (First In First Out order)
 * Used to manage today's recurring tasks
 * @param <T>
 */
public class CustomQueue<T> {

    private CustomArrayList<T> elements;

    /**
     * create empty queue
     */
    public CustomQueue() {
        elements = new CustomArrayList<>();
    }

    /**
     * add item to the back of the queue
     */
    public void enqueue(T item) {
        elements.add(item);
    }

    /**
     * remove and return item from the front of the queue
     */
    public T dequeue() {
        // check before removing so we dont crash
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.remove(0);
    }

    /**
     * return front item without removing it
     */
    public T peek() {
        return elements.get(0); 
    }

    /**
     * return true if queue has no elements
     */
    public boolean isEmpty() {
        return elements.size() == 0;
    }
}