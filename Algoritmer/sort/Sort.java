package sort;

public class Sort {

    /**
     * Utplukk med heltall
     * @param A, array med heltall som skal sorteres.
     */
    public static void SelectionSort(int[] A) {
        int n = A.length;
        int min, temp;
        for (int i = 0; i < n-1; i++) {
            // A er riktig sortert med i-1, finner minste element av de usorterte
            min = i;
            for (int j = i+1; j<n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            // swapper det minste element med i.
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }

    /**
     * Instikk med heltall
     * @param A, array med heltall som skal sorteres.
     */
    public static void InsertionSort(int[] A) {
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


    /**
     * Bubble sort med heltall.
     * Sorterer annerledes enn læreboka, ved at små tall flyttes fremover i stedetfor læreboka
     * som flytter dem bakover
     *
     * @param A, array med heltall som skal sorteres.
     */
    public static void BubbleSort(int[] A) {
        int n = A.length;
        int temp;

        for (int i = 0; i<n; i++) {
            for (int j = n-1; j>i; j--) {
                if (A[j] < A[j-1]) {
                    temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }


    /**
     * Sorterer array med heltall
     * Gap sekvens på n/2, (n/2)/2.2, (n/2)/(2.2^2), (n/2)/(2.2^3) , ...
     * @param A array med heltall som skal sorteres
     */
    public static void ShellSort(int[] A) {
        int n = A.length;
        int gap = n/2;

        while (gap > 0) {
            for (int i = 0; i < n; i++) {
                int j = i;
                int temp = A[i];
                while (j >= gap && A[j-gap] > temp) {
                    A[j] = A[j-temp];
                    j = j-temp;
                }
                A[j] = temp;
            }
            if (gap == 2) {
                gap = 1;
            } else {
                gap *= (5.0 / 11);
            }
        }
    }

    /**
     *
     * @param A, array som skal sorteres
     * @param min, minste tall som er i arrayen
     * @param max, største tallet som er i arrayen.
     */
    public static void QuickSort(int[]A, int min, int max) {

        int indexOfPartition;
        if (min - max > 0) {
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

    public static void mergeSort(int[] A, int min, int max) {
        if (min == max) {
            return;
        }
        int[] temp;
        int index1, left, right;
        int size = min - max + 1;
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
}
