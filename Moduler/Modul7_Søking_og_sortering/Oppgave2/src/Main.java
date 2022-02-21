import java.util.Arrays;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        final int MAX_N = 50000000;
        final int N_TEST = 100;
        int n = 4050300;

        if (n < 1 || n > MAX_N) {
            System.out.println("Too big N");
            System.exit(1);
        }

        int[] A = new int[n];
        Random r = new Random(n);
        for (int i = 0; i <n; i++) {
            A[i] = r.nextInt();
        }
        Arrays.sort(A, 0, n-1);

        // TEST PROGRAM

        int x, test;
        long n_comps = 0;
        boolean found;

        System.out.println("\n Average # of comparissons searching n=" + n + " sorted numbers " + N_TEST + " times \n");

        for (test = 0; test < N_TEST; test++) {
            x = r.nextInt();
            found = TernarySearch.Iterative(A, x);
            n_comps += TernarySearch.N_COMPS;
        }
        System.out.println("Binary:\t " + n_comps / N_TEST);

        n_comps = 0;
        for (test = 0; test < N_TEST; test++) {
            x = r.nextInt();
            found = BinarySearch.binSearch(A, x);
            n_comps += BinarySearch.N_COMPS;
        }

        System.out.println("Ternary\t " + n_comps / N_TEST);
        System.out.println("");
    }
}

