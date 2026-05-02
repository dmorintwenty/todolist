package todolist;
import java.util.*;



/**
 * Not using Javas built in ArrayList we create ours here
 * Implementation of methods ArrayList come standard like add, remove, get, set, size. 
 * @param <T>
 */
class CustomArrayList<T> implements Iterable<T> {

    private T[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    /** 
     * create empty list with default capacity 
     */
    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /** 
     * double internal array capacity 
     */
    private void doubleCapacity() {
        int newSize = elements.length * 2;
        //double the size when no more room
        elements = Arrays.copyOf(elements, newSize);
    }

    /** 
     * add element to end of list 
     */
    public boolean add(T element) {
        if (size == elements.length) {
            doubleCapacity();
           //calling the extra space if needed here
        }
        elements[size++] = element;
        return true;
    }

    /** 
     * remove element at index and shift elements left 
     */
    public T remove(int index) {
        checkIndex(index);

        T removed = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;

        return removed;
    }

    /** 
     * return element at given index 
     */
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /** 
     * replace element at index and return old value 
     */
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    /** 
     * return current number of elements 
     */
    public int size() {
        return size;
    }

    /** 
     * return true if list has no elements 
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 
     * check if index is within bounds 
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "index " + index + " size " + size
            );
        }
    }

    /** 
     * return string representation of list 
     */
    @Override
    public String toString() {
        if (size == 0) return "[]";

        String s = "[";
        for (int i = 0; i < size; i++) {
            s += elements[i];
            if (i < size - 1) s += ", ";
        }
        s += "]";
        return s;
    }

    /** 
     * return index of element or -1 if not found 
     */
    private int indexOf(T element) {
    	//seperate for null statement as we dont want exception
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    /** 
     * return true if list contains element 
     */
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    /** 
     * remove first occurrence of element 
     */
    public boolean removeElement(T element) {
        int index = indexOf(element);
        if (index == -1) return false;

        remove(index);
        return true;
    }

    /** 
     * return iterator over elements 
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /** 
     * iterator implementation 
     */
    private class MyIterator implements Iterator<T> {

        private int cursor = 0;

        /** 
         * return true if more elements exist 
         */
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        /** 
         * return next element in iteration 
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[cursor++];
        }
    }
}
