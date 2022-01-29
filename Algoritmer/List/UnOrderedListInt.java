package List;

import java.util.Arrays;
import java.util.Iterator;

public class UnOrderedListInt implements UnOrderedList<Integer>{

    private static final int DEFAULT_CAPACITY = 100;
    private int count;

    private int[] list;

    public UnOrderedListInt() {
        this(DEFAULT_CAPACITY);
    }

    public UnOrderedListInt(int listSize) {
        count = 0;
        list = new int[listSize];
    }

    @Override
    public Integer removeFirst() {
        return null;
    }

    @Override
    public Integer removeLast() {
        return null;
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
        return list[count - 1];
    }

    @Override
    public boolean contains(Integer target) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void addToFront(Integer element) {

    }

    @Override
    public void addToRear(Integer element) {
        list[count++] = element;
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
}
