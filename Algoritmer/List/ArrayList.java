package List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>{

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    protected int rear;

    protected T[] list;
    protected int modCount;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int listSize) {
        rear = 0;
        list = (T[])(new Object[listSize]);
        modCount = 0;
    }

    public void expandCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    @Override
    public T removeFirst() {

        if(isEmpty()) {
            throw new Error("Is empty");
        }

        T removed = list[0];
        rear--;
        for (int i = 0; i < rear; i++) {
            list[i] = list[i+1];
        }
        list[rear] = null;
        modCount++;
        return removed;
    }

    @Override
    public T removeLast() throws Error {

        if(isEmpty()) {
            throw new Error("is empty");
        }

        T removed;
        rear--;
        removed = list[rear];
        list[rear] = null;
        modCount++;
        return removed;
    }

    @Override
    public T remove(T element) {
        T result;
        int index = find(element);

        if (index == NOT_FOUND) {
            throw new Error("Not Found");
        }

        result = list[index];
        rear--;

        // shifts element
        for (int i = index; i < rear; i++) {
            list[i] = list[i+1];
        }

        list[rear] = null;
        modCount++;

        return result;
    }

    @Override
    public T first() {
        return list[0];
    }

    @Override
    public T last() {
        return list[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    private int find(T target) {
        int scan = 0;
        int result = NOT_FOUND;
        if (!isEmpty()) {
            while (result == NOT_FOUND && scan < rear) {
                if (target.equals(list[scan])) {
                    result = scan;
                } else {
                    scan++;
                }
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (T j : list) {
            out.append(j).append(", ");
        }
        out.append("]");
        return out.toString();
    }
    /**
     * ArrayListIterator iterator over the elements of an ArrayList.
     */
    private class ArrayListIterator implements Iterator<T> {
        int iteratorModCount;
        int current;

        /**
         * Sets up this iterator using the specified modCount.
         *
         * modCount the current modification count for the ArrayList
         */
        public ArrayListIterator()
        {
            iteratorModCount = modCount;
            current = 0;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  Error if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws Error {
            if (iteratorModCount != modCount) {
                throw new Error("Collection has changed!");
            }

            return (current < rear);
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return  the next element in the iteration
         * @throws  Error if an element not found exception occurs
         * @throws  Error if the collection has changed
         */
        public T next() throws Error {
            if (!hasNext()) {
                throw new Error("No such element!");
            }

            current++;

            return list[current - 1];
        }

        /**
         * The remove operation is not supported in this collection.
         *
         * @throws UnsupportedOperationException if the remove method is called
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

    }
}
