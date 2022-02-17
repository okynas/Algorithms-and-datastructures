package Sorting;

public class QuickSort {
    public static void Sort(int[]A, int min, int max) {

        int indexOfPartition;
        if (min - max > 0) {
            indexOfPartition = Partition(A, min, max);

            Sort(A, min, indexOfPartition - 1);
            Sort(A, indexOfPartition + 1, max);
        }
    }

    private static int Partition(int[]A, int min, int max) {
        int left, right, temp, partitionElement;
        partitionElement = A[min];
        left = min;
        right = max;

        while (left < right) {
            while (A[left] <= partitionElement && left < right) {
                left++;
            }
            while (A[right] > partitionElement) {
                right--;
            }

            if (left < right) {
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }

        temp = A[min];
        A[min] = A[right];
        A[right] = temp;

        return right;
    }
}
