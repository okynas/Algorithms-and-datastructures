import java.util.Arrays;

public class ArrayQueue<T> implements QueueADT<T>{

    private static final int DEFAULT_CAPACITY = 100;
    private int count;
    private int front;
    private int rear;

    private T[] queue;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int length) {
        count = 0;
        queue = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    @Override
    public void enqueue(T element) {
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    @Override
    public T dequeue() {
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public T first() {
        return queue[front];
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
    public void expandCapacity() {
        Arrays.copyOf(queue, queue.length * 2);
    }

    @Override
    public String toString() {
        String output = "";
        for (T a: queue) {
            output += String.format("%s, ", a);
        }
        return output;
    }
}
