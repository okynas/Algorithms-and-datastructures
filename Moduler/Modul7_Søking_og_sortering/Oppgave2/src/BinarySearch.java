public class BinarySearch {
    public static long N_COMPS;
    // Non-reccursive method
    public static boolean binSearch(int A[], int x) {
        // Iterative binary search
        int n = A.length;
        int min = 0, max = n - 1, mid = 0;
        N_COMPS = 0;

        while (max >= min) {
            mid = (min + max) / 2;
            N_COMPS++;
            if (A[mid] == x)
                return true;
            N_COMPS++;
            if (x < A[mid])
                max = mid - 1;
            else
                min = mid + 1;
        }
        return false;
    }
}
