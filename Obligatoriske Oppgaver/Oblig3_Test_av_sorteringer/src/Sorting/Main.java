package Sorting;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_SEQ = 100_000;
    private static final int MAX_N = 100_000_000;

    public static void randomize(int[] A) {
        Random r = new Random();
        int n =  A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n2);
        }
    }

    public static void startTest() {
        int n;
        long time;

        Scanner in = new Scanner(System.in);

        System.out.print("Of what size should the elements be (n=?): ");
        n = in.nextInt();

        if (n > MAX_N) {
            System.out.println("N elements is too large.");
            System.exit(1);
        }

        int[] numberToBeSorted = new int[n];

        // hvilken metode som skal brukes
        System.out.println("Which algorithm do you want to sort?: ");
        System.out.print("1. QuickSort, 2. MergeSort, 3. RadixSort, 4. InsertionSort: ");
        int algorithm = in.nextInt();

        if (algorithm < 1 || algorithm >= 5) {
            System.out.println("Algorithm not accepted");
            System.exit(1);
        }

        // hvilken operasjon:
        System.out.println("What to you want to test:");
        System.out.print("1. Time, 2. Constant: ");

        int programToRun = in.nextInt();

        if (programToRun < 1 || programToRun >= 3) {
            System.out.println("Program not accepted");
            System.exit(1);
        }

        if (algorithm == 1) {
            randomize(numberToBeSorted);
            time = System.currentTimeMillis();
            QuickSort.Sort(numberToBeSorted, 0, n-1);
            time = System.currentTimeMillis() - time;

            if (programToRun == 1) {
                System.out.printf("Quick Sort\t: %6.3f s\n", time /1000.0);
            } else if (programToRun == 2) {
                System.out.printf("Quick Sort\t: %6.9f \n c=t/n log(n): ", time /(n * Math.log(n)));
            } else {
                System.out.println("Wrong program");
            }


        } else if (algorithm == 2) {
            randomize(numberToBeSorted);
            time = System.currentTimeMillis();
            MergeSort.sort(numberToBeSorted, 0, n-1);
            time = System.currentTimeMillis() - time;

            if (programToRun == 1) {
                System.out.printf("Merge Sort\t: %6.3f s\n", time /1000.0);
            } else if (programToRun == 2) {
                System.out.printf("Merge Sort\t: %6.9f \n c=t/n log(n): ", time /(n * Math.log(n)));
            } else {
                System.out.println("Wrong program");
            }


        } else if (algorithm == 3) {
            int maxDigit = (int) Math.log10(n);
            randomize(numberToBeSorted);
            time = System.currentTimeMillis();
            RadixSortInt.sort(numberToBeSorted, maxDigit);
            time = System.currentTimeMillis() - time;

            if (programToRun == 1) {
                System.out.printf("Radix Sort\t: %6.3f s\n", time /1000.0);
            } else if (programToRun == 2) {
                System.out.printf("Radix Sort\t: %6.9f \n c=t/n", ( (float)time / n) );
            } else {
                System.out.println("Wrong program");
            }


        } else {
            // alrogithm = 4
            if (n <= MAX_SEQ) {
                randomize(numberToBeSorted);
                time = System.currentTimeMillis();
                InsertionSort.Sort(numberToBeSorted);
                time = System.currentTimeMillis() - time;

                if (programToRun == 1) {
                    System.out.printf("Insertion Sort\t: %6.3f s\n", time /1000.0);
                } else if (programToRun == 2) {
                    System.out.printf("Insertion Sort\t: %6.9f \n c=t/n^2",  ( (float)time / (n*n) ) );
                } else {
                    System.out.println("Wrong program");
                }
            } else {
                System.out.println("Number of elements to be sorted is too, big\n The work is O(n^2)");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        do {
            startTest();
        } while(query("\n Test again?"));
    }

    static boolean query(String str) {
        String answer;
        System.out.println(str + "[Y or N]: ");
        Scanner sc = new Scanner(System.in);

        answer = sc.nextLine().toUpperCase();
        while(!answer.startsWith("Y") && !answer.startsWith("N")) {
            System.out.println("Invalid input");
            answer = sc.nextLine().toUpperCase();
        }
        return answer.startsWith("Y");
    }
}
