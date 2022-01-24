import Queue.QueueInt;
import Stack.*;

public class Main {
    public static void main(String[] args) throws Exception{
        /*StackInt stack = new StackInt(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println("Peak: ");
        System.out.println(stack.peek());

        stack.pop();
        System.out.println("---");
        System.out.println(stack);

        System.out.println("---");
        System.out.println("Peak: ");
        System.out.println(stack.peek());*/

        QueueInt queue = new QueueInt(3);
        System.out.println(queue.isEmpty());
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.first());
        System.out.println(queue.size());
    }
}
