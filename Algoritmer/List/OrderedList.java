package List;

public class OrderedList<T> extends ArrayList<T> implements OrderedListADT<T>{

    public OrderedList() {
    }

    public OrderedList(int listSize) {
        super(listSize);
    }

    @Override
    public void add(T element) {
        if (!(element instanceof Comparable)) {
            throw new Error("Is not comparable!");
        }

        Comparable<T> comparable = (Comparable<T>)element;

        if (size() == list.length) {
            expandCapacity();
        }

        int scan = 0;
        while (scan < rear && comparable.compareTo(list[scan]) > 0) {
            scan++;
        }

        if (rear - scan >= 0) {
            // src, srcPosition, destionation, destionationPos, length
            System.arraycopy(list, scan, list, scan + 1, rear - scan);
        }

        list[scan] = element;

        // increase rear, modCount
        rear++;
        modCount++;
    }
}
