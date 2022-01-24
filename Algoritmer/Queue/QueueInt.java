package Queue;

import java.util.Arrays;

public class QueueInt implements QueueADT<Integer>{

    private static final int DEFAULT_CAPACITY = 100;
    private int count;
    private int front;
    private int rear;

    private int[] queue;

    public QueueInt() {
        this(DEFAULT_CAPACITY);
    }

    public QueueInt(int length) {
        count = 0;
        queue = new int[length];
    }

    @Override
    public void enqueue(Integer element) {
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    @Override
    public Integer dequeue() {
        int result = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public Integer first() {
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
        for (int a: queue) {
            output += String.format("%s, ", a);
        }
        return output;
    }
}
