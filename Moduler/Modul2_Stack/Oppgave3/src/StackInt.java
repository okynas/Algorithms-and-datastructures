
/* Enkel implementasjon av stack med heltallsarray, uten feilsjekking... */

import java.util.Arrays;

public class StackInt implements StackADT<Integer>{

    private final static int MIN_LENGTH = 100;
    private int top;
    private int stack[];

    public StackInt(int length) {
        if (length < MIN_LENGTH) {
            length = MIN_LENGTH;
        }
        top = 0;
        stack = new int[length];
    }

    @Override
    public void push(Integer element) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public Integer pop() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--;
        return(stack[top]);
    }

    @Override
    public Integer peek() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack is empty");
        }
        return(stack[top-1]);
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void expandCapacity() {
        Arrays.copyOf(stack, stack.length*2);
    }
}