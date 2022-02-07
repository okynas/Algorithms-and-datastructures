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
}
