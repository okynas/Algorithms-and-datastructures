package sort;

public class Sort {
    public static void SelectionSort(int[] array) {
        int n = array.length;
        int min, temp;
        for (int i = 0; i < n-1; i++) {
            min = i;
            for (int j = i+1; j<n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void InsertionSort(int[] A) {
        int n = A.length;
        int key;

        for (int i = 1; i<n; i++) {
            key = A[i];
            int j = i;
            while (j >0 && A[j-1] > key) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }
}
