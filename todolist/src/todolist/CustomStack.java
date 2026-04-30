package todolist;

public class CustomStack<T> {

    private CustomArrayList<T> elements;

    /** 
     * create empty stack 
     */
    public CustomStack() {
        elements = new CustomArrayList<>();
    }

    /** 
     * add item to top of stack 
     */
    public void push(T item) {
        elements.add(item);
    }

    /** 
     * remove and return top item 
     */
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return elements.remove(elements.size() - 1);
    }

    /** 
     * return top item without removing 
     */
    public T peek() {
        if (isEmpty()) {
        	throw new IllegalStateException("stack is empty");
        	
        	//debated between this and --> throw new RuntimeException("stack is empty");
        	//It likely doesnt even cause a runtime difference, 
        	//TODO: Compare IllegalStateException to RuntimeException throws on empty stack
        }

        return elements.get(elements.size() - 1);
    }

    /** 
     * return true if stack is empty 
     */
    public boolean isEmpty() {
        return elements.size() == 0;
    }

    /** 
     * return number of items in stack 
     */
    public int size() {
        return elements.size();
    }


    
}


