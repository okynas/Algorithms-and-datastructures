import List.OrderedList;
import List.UnorderedList;
import Queue.QueueInt;
import RadixSort.RadixSortInt;
import Stack.*;

import java.util.Random;

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

        /*QueueInt queue = new QueueInt(3);
        System.out.println(queue.isEmpty());
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.first());
        System.out.println(queue.size());*/

        // radix(args); // krever at man kjører "java Main 10 10" f.eks.

        UnorderedList<Integer> list = new UnorderedList(10);
        list.addToFront(5);
        list.addToRear(4);
        list.addToRear(7);
        list.addToFront(5);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        System.out.println(list.removeFirst());
        System.out.println(list.toString());
        list.addToRear(2);
        System.out.println(list.toString());
        list.addAfter(7, 5);
        System.out.println(list.toString());

        System.out.println("----");

        OrderedList<Integer> ol = new OrderedList<>(10);
        ol.add(3);
        ol.add(2);
        System.out.println(ol);

        System.out.println(ol.contains(2));
    }

    public static void radix(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int ti_i_m = (int) java.lang.Math.pow(10, m);
        int a[] = new int[n];
        Random R = new Random();

        // fyller array med tilfeldige verdier:
        for (int i = 0; i < n; i++) {
            a[i] = R.nextInt(ti_i_m);
        }

        // sortere
        RadixSortInt rs = new RadixSortInt();
        rs.sort(a, m);

        // skriver ut sortert array formatert i kolonner
        int linjeBredde = 80;
        int tall_pr_linje = linjeBredde/(m+1);
        for (int i = 0; i < n; i++) {
            String format = "%" + m + "d ";
            System.out.printf(format, a[i]);
            if ( ((i+1) % tall_pr_linje == 0) || (i == n - 1) ) {
                System.out.println();
            }

        }
    }
}
