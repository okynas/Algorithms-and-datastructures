package Sorting;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SEQ = 100000;
    private static final int MAX_N = 100000000;

    public static void randomize(int[] A) {
        Random r = new Random();
        int n =  A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n2);
        }
    }

    public static void startTest() {
        // antall tall som skal sorteres
        int n = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Of what size should the elements be (n=?): ");

        n = in.nextInt();
        System.out.println(n);

        // hvilken metode som skal brukes
        System.out.println("Which algorithm do you want to sort?: ");
        System.out.print("1. QuickSort, 2. MergeSort, 3. RadixSort, 4. InsertionSort: ");

        int algorithm = in.nextInt();

        System.out.println(algorithm);

        // hvilken operasjon:
        System.out.println("What to you want to test:");
        System.out.print("1. Time, 2. Constant: ");

        int programToRun = in.nextInt();
        System.out.println(programToRun);
        // Utføre sortering
        if (programToRun == 1) {
            int[] numberToBeSorted = new int[n];
            long time;

            if (algorithm == 1) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                QuickSort.Sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;
                System.out.printf("Quick Sort\t: %6.3f s\n", time /1000.0);
            } else if (algorithm == 2) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                MergeSort.sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;
                System.out.printf("Merge Sort\t: %6.3f s\n", time /1000.0);
            } else if (algorithm == 3) {
                int maxDigit = (int) Math.log10(n);
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                RadixSortInt.sort(numberToBeSorted, maxDigit);
                time = System.currentTimeMillis() - time;
                System.out.printf("Radix Sort\t: %6.3f s\n", time /1000.0);
            } else if (algorithm == 4) {
                if (n <= MAX_SEQ) {
                    randomize(numberToBeSorted);
                    time = System.currentTimeMillis();
                    InsertionSort.Sort(numberToBeSorted);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Insertion Sort\t: %6.3f s\n", time /1000.0);
                } else {
                    System.out.println("Number of elements to be sorted is too, big\n The work is O(n^2)");
                    System.exit(1);
                }

            } else {
                System.out.println("Not accepted");
                System.exit(1);
            }

        }
        // Estimere konstant c
        else if (programToRun == 2) {
            int[] numberToBeSorted = new int[n];
            long time = 0;
            if (algorithm == 1) {
                // C = T/(nlog(n)).
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                QuickSort.Sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;

                System.out.printf("Quick Sort\t: %6.3f s\n t/n log(n): ", time /(n * Math.log10(n)));

            } else if (algorithm == 2) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                MergeSort.sort(numberToBeSorted, 0, 2*n);
                time = System.currentTimeMillis() - time;
                System.out.printf("Merge Sort\t: %6.3f s\n", time /1000.0);
            } else if (algorithm == 3) {
                int maxDigit = (int) Math.log10(n);
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                RadixSortInt.sort(numberToBeSorted, maxDigit);
                time = System.currentTimeMillis() - time;
                System.out.printf("Radix Sort\t: %6.3f s\n t/n", (double) (time / n) );

            } else if (algorithm == 4) {
                if (n <= MAX_SEQ) {
                    randomize(numberToBeSorted);
                    time = System.currentTimeMillis();
                    InsertionSort.Sort(numberToBeSorted);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Insertion Sort\t: %6.3f s\n", time /1000.0);
                } else {
                    System.out.println("Number of elements to be sorted is too, big\n The work is O(n^2)");
                    System.exit(1);
                }

            } else {
                System.out.println("Not accepted");
                System.exit(1);
            }
        }

        else {
            System.out.println("Invalid program");
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        do {
            startTest();
        } while(query("\n Test again?"));
    }

    static boolean query(String input) {
        String answer;
        System.out.println(input + "[Y or N]: ");
        Scanner sc = new Scanner(System.in);

        answer = sc.nextLine().toUpperCase();
        while(!answer.startsWith("Y") && !answer.startsWith("N")) {
            System.out.println("Invalid input");
            answer = sc.nextLine().toUpperCase();
        }
        return answer.startsWith("Y");
    }
}
