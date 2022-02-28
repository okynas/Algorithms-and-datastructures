import List.OrderedList;
import List.UnorderedList;
import Queue.QueueInt;
import RadixSort.RadixSortInt;
import Search.Search;
import Stack.*;
import Tree.Tree;

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

        /*UnorderedList<Integer> list = new UnorderedList(10);
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

        System.out.println(ol.contains(2));*/

        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,15,19,20,25,29,31,38,44,48,55,59,61,66,72,78,90,99,104};

        /*boolean s = Search.interpolationSearch(array, 44);
        System.out.println(s);*/

        Tree BinaryTree = new Tree(null);

        for(int i = 0; i < array.length; i++) {
            BinaryTree.Insert(array[i]);
        }

    }


}
