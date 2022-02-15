public class InsertionSort {
    public static void Sort(int[] A) {
        int n = A.length;
        int key;

        for (int i = 1; i<n; i++) {
            // a er sortert til og med index i-1
            key = A[i];
            int j = i;

            // setter elementene på riktig plass, blant i-1 første elementene.
            while (j >0 && A[j-1] > key) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }
}
