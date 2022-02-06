package sort;

public class Sort {
    public static void selectionSort(int[] array) {
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
}
