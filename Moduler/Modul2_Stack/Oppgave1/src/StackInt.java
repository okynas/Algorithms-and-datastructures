import java.util.*;

public class StackInt implements StackADT<Integer>{

    private static final int DEFAULT_CAPACITY = 100;
    private int top;
    private int[] stack;

    public StackInt() {
        this(DEFAULT_CAPACITY);
    }

    public StackInt(int initialCapacity) {
        top = 0;
        stack = new int[initialCapacity];
    }

    @Override
    public void push(Integer element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack : Can not pop");
        }
        top--;
        Integer result = stack[top];
        stack[top] = 0;

        return result;
    }

    @Override
    public Integer peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack");
        }
        return stack[top-1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public String toString() {
        String output = "";
        for (int a: stack) {
            output += String.format("%s, ", a);
        }
        return output;
    }
}
