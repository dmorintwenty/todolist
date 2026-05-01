package todolist;

public class CustomQueue<T> {

	
	private CustomArrayList<T> elements;

	public CustomQueue() {
	    elements = new CustomArrayList<>();
	}
	
	
    public void enqueue(T item) {
        elements.add(item);
    }

    //for removing item on the top or index 0
    public T dequeue() {
    	if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
    		}
    	else {
        return elements.remove(0);
    	}
    }

    //just to see element
    public T peek() {
        return elements.get(0);
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }
}
