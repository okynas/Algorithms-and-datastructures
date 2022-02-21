import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class TernarySearch {

    public static long N_COMPS;

    public static boolean Iterative(int[] A, int x) {
        int n = A.length;

        int min = 0;
        int max = n-1;

        N_COMPS = 0;

        while (n > 2) {
            int one_third = min + n/3;
            int two_thirds = one_third + n/3;

            N_COMPS +=2;
            if (A[one_third] == x && A[two_thirds] == x) {
                return true;
            }

            N_COMPS++;
            if ( x < A[one_third]) {
                // element x ligger mellom index 1/3 og 2/3
                max = one_third - 1;
            } else if (x > A[two_thirds]){
                // element x ligger mellom index 2/3 og n-1
                N_COMPS++;
                min = two_thirds + 1;
            } else {
                min = one_third + 1;
                max = two_thirds - 1;
            }
            n = max - min + 1;
        }

        if (n == 1) {
            N_COMPS++;
            return (A[min] == x);
        }
        if (n == 2) {
            N_COMPS +=2;
            return (A[min] == x || A[max] == x);
        }
        return false;

    }

    public static boolean Recursive(int[] A, int x, int min, int max) {
        int n = A.length;

        if (n > 2) {

            int one_third = min + n / 3;
            int two_thirds = one_third + n / 3;

            if (A[one_third] == x && A[two_thirds] == x) {
                return true;
            }

            if (x < A[one_third]) {
                Recursive(A, x, min, one_third - 1);
            } else if (x > A[two_thirds]) {
                Recursive(A, x, two_thirds + 1, max);
            } else {
                Recursive(A, x, one_third + 1, two_thirds - 1);
            }

        }

        return false;


    }
}
