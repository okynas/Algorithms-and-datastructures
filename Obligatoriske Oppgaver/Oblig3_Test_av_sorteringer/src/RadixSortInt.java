import java.util.LinkedList;
import java.util.Queue;

public class RadixSortInt {
    public static void sort(int a[], int masksSiffer) {
        /*
        1 Opprett en array Q med 10 tomme køer
        2 For k=0,1,2,...,m–1
            2.1 For i=0,1,2,...,n–1
                2.1.1 index=(A[i]/10k)%10 2.1.2 Q[ index ].enqueue( A[ i ] )
            2.2 i = 0
            2.3 For j=0,1,2,...,9
                2.3.1 While !Q[ j ].isEmpty( )
                2.3.1.1 A[ i ] = Q[ j ].dequeue( ) 2.3.1.2 i=i+1
        */

        int ti_i_m = 1; // lagrer 10^n;
        int n = a.length;

        Queue<Integer>[] Q = (Queue<Integer>[]) new Queue[10];

        for (int i = 0; i < 10; i++) {
            Q[i] = new LinkedList<>();
        }

        // sorterer på et og et siffer., høyre mot venstre.
        for (int m = 0; m < masksSiffer; m++) {
            for (int i = 0; i < n; i++) {
                int siffer = (a[i] / ti_i_m) % 10;
                Q[siffer].add(a[i]);
            }

            // tømmer køene, og legger tall fortløpende på a.

            int j = 0;
            for (int i = 0; i < 10; i++) {
                while (!Q[i].isEmpty()) {
                    a[j++] = Q[i].remove();
                }
            }
            ti_i_m *= 10;
        }
    }
}
