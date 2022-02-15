import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void randomize(int A[]) {
        Random r = new Random();
        int n =  A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n2);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 0;
        long time = 0;
        int MAX_SEQ = 100000, MAX_N = 100000000;
        Scanner in = new Scanner(System.in);
        System.out.println("What to you want to test:");
        System.out.print("1. Time, 2. Constant: ");
        int programToRun = in.nextInt();
        System.out.println(programToRun);

        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RadixSortInt radixSortInt = new RadixSortInt();
        InsertionSort insertionSort = new InsertionSort();

        if (programToRun == 1) {
            System.out.println("Of what size should the elements by (n=?): ");

            n = in.nextInt();
            System.out.println(n);

            if (n < 0 || n > MAX_N){
                System.out.println("Use 1 <= n <= " + MAX_N);
                System.exit(1);
            }

            System.out.println("Which algorithm do you want to sort?: ");
            System.out.print("1. QuickSort, 2. MergeSort, 3. RadixSort, 4. InsertionSort: ");
            int algorithm = in.nextInt();
            System.out.println(algorithm);

            int[] numberToBeSorted = new int[n];

            if (algorithm == 1) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                quickSort.Sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;
                System.out.printf("Quick Sort\t: %6.3f s\n", time/1000.0);
            } else if (algorithm == 2) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                mergeSort.sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;
                System.out.printf("Merge Sort\t: %6.3f s\n", time/1000.0);
            } else if (algorithm == 3) {
                int maxDigit = (int) Math.log10(n);
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                radixSortInt.sort(numberToBeSorted, maxDigit);
                time = System.currentTimeMillis() - time;
                System.out.printf("Radix Sort\t: %6.3f s\n", time/1000.0);
            } else if (algorithm == 4) {
                if (n <= MAX_SEQ) {
                    randomize(numberToBeSorted);
                    time = System.currentTimeMillis();
                    insertionSort.Sort(numberToBeSorted);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Insertion Sort\t: %6.3f s\n", time/1000.0);
                } else {
                    System.out.println("Number of elements to be sorted is too, big\n The work is O(n^2)");
                    System.exit(1);
                }

            } else {
                System.out.println("Not accepted");
                System.exit(1);
            }

        } else if (programToRun == 2) {

        }
        else {
            System.out.println("Input not valid!");
            System.exit(1);
        }
    }
}
