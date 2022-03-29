package HeapAndHeapSort;

import java.io.*;
import java.util.*;

public class heapSort
{
    void sort(int A[])
    {
        // In-place heapsort of integer array

        int n = A.length;

        // Transform array into a maxheap
        for (int i = 1; i < n; i++)
            siftUp(A, i);

        // Remove largest element from heap n-1 times
        // and place it at the back of the heap
        int tmp;
        for (int i = n-1; i > 0; i--)
        {
            tmp = A[i];
            A[i] = A[0];
            A[0] = tmp;
            // Restore heap after swapping root
            siftDown(A, i-1);
        }
    }

    void siftUp(int A[], int i)
    {
        // A[0] - A[i-1] is a maxheap
        // Inserts A[i] correctly into heap by swapping it upwards

        int child = i;
        int value = A[child];
        int parent = (i-1)/2;
        boolean done = false;

        while (!done)
        {
            if (child == 0)
                done = true;
            else if (value <= A[parent])
                done = true;
            else
            {
                A[child] = A[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
        }
        A[child] = value;
    }

    void siftDown(int A[], int i)
    {
        // A[0] - A[i] is a maxheap, maybe except for root at A[0]
        // Restores heap by swapping root downwards

        int current = 0;
        int value = A[current];
        int left, right, next = 0;
        boolean done = false;

        while (!done)
        {
            left = 2*current + 1;
            right = left + 1;

            if (left > i)
                done = true;
            else
            {
                if (right > i)
                    next = left;
                else if (A[left] > A[right])
                    next = left;
                else
                    next = right;
                done = (value >= A[next]);
            }
            if (!done)
            {
                A[current] = A[next];
                current = next;
                done = (current > i);
            }
        }
        A[current] = value;
    }

    public static void main(String args[])
    {
        //Heapsorting random numbers

        int n = 30;
        int A[] = new int[n];
        Random r = new Random();

        heapSort hS = new heapSort();

        for (int i = 0; i < n; i++)
            A[i] = r.nextInt(100);

        hS.sort(A);

        for (int j = 0; j < n; j++)
            System.out.print(A[j] + " ");
        System.out.println();
    }
}
