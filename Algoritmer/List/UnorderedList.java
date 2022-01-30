package List;

import java.lang.annotation.Target;

public class UnorderedList<T> extends ArrayList<T> implements UnOrderedListADT<T>{

    public UnorderedList() {
        super();
    }

    public UnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void addToFront(T element) {

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
    public void addToRear(T element) {
        if (size() == list.length) {
            expandCapacity();
        }

        list[rear++] = element;
    }

    @Override
    public void addAfter(T element, T target) {
        System.out.println(target);
        if (size() == list.length) {
            expandCapacity();
        }

        // find target
        int scan = 0;
        while (scan < rear && (!target.equals(list[scan]))) {
            scan++;
        }

        // add element after target
        if (scan == rear) {
            throw new Error("Unordered list, element not found!");
        }

        int next_spot = scan + 1;

        if (rear - next_spot >= 0) {
            // src, srcPosition, destionation, destionationPos, length
            System.arraycopy(list, next_spot, list, next_spot + 1, rear - next_spot);
        }

        list[next_spot] = element;

        // increase rear, modCount
        rear++;
        modCount++;

    }
}
