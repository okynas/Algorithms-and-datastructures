import java.util.*;

/**
 * Demonstrates the use of an indexed list to solve the Josephus problem.
 *
 * @author Lewis and Chase 
 * @author Jan H.
 * @version 5.0
 */

/**
 * Continue around the circle eliminating every d'th number
 * until all but one number have been eliminated.
 */
public class Josephus_2 {
    public static void main(String[] args)
    {
        // numOfPeople: number of elements
        // gap: skip size
        int numOfPeople, gap;

        Scanner in = new Scanner(System.in);
        System.out.print("numOfPeople: ");
        numOfPeople = in.nextInt();
        in.nextLine();
        System.out.print("gap: ");
        gap = in.nextInt();
        in.nextLine();

        // Indexed list storing remaining elements during removal
        // List<Integer> L = new ArrayList<Integer>();
        ArrayQueue<Integer> q = new ArrayQueue<>();

        // Load the initial list of numbers
        for (int i = 0; i < numOfPeople; i++) {
            q.enqueue(i+1);
        }

        // Set index of first element to be removed
        // int p = f - 1;

        System.out.print("The order of removal is:");

        // Treating the list as circular, remove every d'th element
        // until only one element remains
        while (q.size() > 1) {
            for (int i = 0; i < gap-1; i++) {
                if (q.size() > 1) {
                    q.enqueue(q.dequeue());
                }
            }
            System.out.print(" " + q.dequeue());
        }

        // Print last number remaining in list
        System.out.println("\nNumber not removed: " + q.dequeue());
    }
}