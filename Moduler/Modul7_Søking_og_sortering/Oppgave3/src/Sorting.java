public class Sorting {
    public static void InsertionSort(int[] A) {
        int n = A.length;
        int key;

        print(A);

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
            print(A);
        }
    }

    public static void ShellSort(int[] A) {
        int n = A.length;
        int gap = (int) n/2;

        print(A);

        while (gap > 0) {

            for (int i = 0; i < n; i++) {
                int j = i;
                int temp = A[i];
                while (j >= gap && A[j-gap] > temp) {
                    A[j] = A[j-gap];
                    j = j-gap;
                }
                A[j] = temp;
            }
            if (gap == 2) {
                gap = 1;
            } else {
                gap *= 0.5;
            }
            print(A);
        }
    }

    public static void mergeSort(int[] A, int min, int max) {
        if (min == max) {
            return;
        }
        int[] temp;
        int index1, left, right;
        int size = max - min + 1;
        int mid = (min + max) / 2;

        temp = new int[size];

        mergeSort(A, min, mid);
        mergeSort(A, mid + 1, max);

        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = A[min + index1];
        }

        left = 0;
        right = mid - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= mid - min) {
                    if (temp[left] > temp[right]) {
                        A[index1 + min] = temp[right++];
                    }
                    else {
                        A[index1 + min] = temp[left++];
                    }
                } else {
                    A[index1 + min] = temp[right++];
                }
            } else {
                A[index1 + min] = temp[left++];
            }
        }
    }

    public static void QuickSort(int[]A, int min, int max) {

        int indexOfPartition;
        if (max - min > 0) {
            indexOfPartition = Partition(A, min, max);

            QuickSort(A, min, indexOfPartition - 1);
            QuickSort(A, indexOfPartition + 1, max);
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

    public static void print(int[] A) {
        int n = A.length;
        // skriver ut arrayen:
        for (int j = 0; j < n; j++) {
            System.out.print(A[j] + " ");
        }
        System.out.println("\n");
    }
}
