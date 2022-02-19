public class BinarySearch {
    // Sequential, binary, and interpolation search of integer arrays

    public static boolean Search(int[] A, int x,  int min, int max) {

        if (min > max) {
            return true;
        }

        int mid = (min + max) / 2;

        if (x < A[mid]) {
            return Search(A, x, min, mid-1);
        }
        return Search(A, x, mid + 1, max);
    }

    // Non-reccursive method
    boolean binSearch(int A[], int x) {
        // Iterative binary search
        int n = A.length;
        int min = 0, max = n - 1, mid = 0;

        while (max >= min)
        {
            mid = (min + max) / 2;
            if (A[mid] == x)
                return true;
            if (x < A[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        return false;
    }
}
