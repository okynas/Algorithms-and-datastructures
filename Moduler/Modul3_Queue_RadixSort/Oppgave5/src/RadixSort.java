import java.util.*;
import java.util.stream.IntStream;

public class RadixSort {

    private static final int MAKS_LENGDE = 10;
    private static final int ANTALL_TALL = 10;
    private static final int MAKS_ANTALL_TALL_PR_ORD = 4;


    public void sort(int a[], int maksSiffer) {

        int ti_i_m = 1; // lagrer 10^n;
        int n = a.length;

        int[] count = new int[MAKS_LENGDE];

        // helper array.
        int[] b = new int[n];

        // for lengden av maks siffer, 0001, 0041, 0255, 0541, 1567, 5214, ....
        for (int m = 0; m < maksSiffer; m++) {

            // fyller opp array count med 0'ere.
            for (int i = 0; i < MAKS_LENGDE; i++) {
                count[i] = 0;
            }

            // for tallene 0 til og med 9, setter count på gjeldende siffer til å øke med 1.
            for (int i = 0; i < n; i++) {
                int siffer = (a[i] / ti_i_m) % MAKS_LENGDE;
                count[siffer]++;
            }

            int start = 0;
            for (int i = 0; i < MAKS_LENGDE; i++) {
                int temp = count[i];
                count[i] = start;
                start += temp;
            }

            // flytter verdi fra a til b
            for (int i = 0; i < n; i++) {
                int siffer = (a[i] / ti_i_m) % MAKS_LENGDE;
                b[count[siffer]] = a[i];
                count[siffer]++;
            }

            // kopierer b tilbake til a
            for (int i = 0; i < n; i++) {
                a[i] = b[i];
            }
            ti_i_m *= MAKS_LENGDE;
        }
    }

    public static int[] fillArrayWithRandomNumbers(int[] a, int maksLengdePerOrd, int antallOrd) {
        // Beregner maks.verdi for tallene som skal sorteres
        Random R = new Random();
        int ti_i_m = (int) java.lang.Math.pow(MAKS_LENGDE, maksLengdePerOrd);

        // Fyller array med tilfeldige tall mellom 0 og 10^m - 1
        for (int i = 0; i < antallOrd; i++) {
            a[i] = R.nextInt(ti_i_m);
        }
        return a;
    }

    public static void print(int[] a) {
        // Skriver ut sortert array formatert i kolonner
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // lager array med random tall.
        //int[] a = new int[ANTALL_TALL];
        // fillArrayWithRandomNumbers(a, MAKS_ANTALL_TALL_PR_ORD, ANTALL_TALL);

        int[] a = {1, 5124, 4124, 6342, 7731, 2145, 142, 646, 2146, 145}; //new int[ANTALL_TALL];


        // Sorterer
        RadixSort rS = new RadixSort();
        rS.sort(a, MAKS_ANTALL_TALL_PR_ORD);

        print(a);

    }
}
