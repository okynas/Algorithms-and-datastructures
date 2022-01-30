package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UnOrderedListInt implements UnOrderedList<Integer>{

    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;
    protected int rear;
    protected int[] list;
    protected int modCount;

    public UnOrderedListInt() {
        this(DEFAULT_CAPACITY);
    }

    public UnOrderedListInt(int listSize) {
        rear = 0;
        list = new int[listSize];
        Arrays.fill(list, NOT_FOUND);
        modCount = 0;
    }

    private void expandCapacity() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    @Override
    public Integer removeFirst() {
        int removed = list[0];
        list[0] = NOT_FOUND;
        // kan byttes ut med :
        /*
        if (rear - 1 >= 0) {
            System.arraycopy(list, 1, list, 0, rear - 1);
        }
        */
        for (int i = 1; i < rear; i++) {
            list[i-1] = list[i];
        }
        rear--;
        modCount--;
        list[rear] = NOT_FOUND;
        return removed;
    }

    @Override
    public Integer removeLast() {
        int removed = list[rear-1];
        list[rear-1] = NOT_FOUND;
        rear--;
        modCount--;
        return removed;
    }

    @Override
    public Integer remove(Integer element) {
        return null;
    }

    @Override
    public Integer first() {
        return list[0];
    }

    @Override
    public Integer last() {
        return list[rear - 1];
    }

    @Override
    public boolean contains(Integer target) {
        return (find(target) != NOT_FOUND);
    }

    private int find(int target) {
        int scan = 0;
        int result = NOT_FOUND;
        if (!isEmpty()) {
            while (result == NOT_FOUND && scan < rear) {
                if (target == list[scan]) {
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
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void addToFront(Integer element) {

        if (size() == list.length) {
            expandCapacity();
        }

        for (int i = rear; i > 0; i--) {
            list[i] = list[i-1];
        }

        list[0] = element;
        rear++;
        modCount++;

    }

    @Override
    public void addToRear(Integer element) {
        if (size() == list.length) {
            expandCapacity();
        }

        list[rear++] = element;
    }

    @Override
    public void addAfter(Integer element, Integer target) {

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int j : list) {
            out.append(j).append(", ");
        }
        out.append("]");
        return out.toString();
    }
    /**
     * ArrayListIterator iterator over the elements of an ArrayList.
     */
    private class ArrayListIterator implements Iterator<Integer> {
        int iteratorModCount;
        int current;

        /**
         * Sets up this iterator using the specified modCount.
         *
         * @param modCount the current modification count for the ArrayList
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
         * @throws  ConcurrentModificationException if the collection has changed
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
         * @throws  NoSuchElementException if an element not found exception occurs
         * @throws  ConcurrentModificationException if the collection has changed
         */
        public Integer next() throws Error {
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
