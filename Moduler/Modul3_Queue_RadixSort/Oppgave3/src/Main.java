import java.util.Arrays;
import java.util.Random;

public class Main {
    /*
    - Opprett en array B av lengde m fylt med nuller
    - Gå gjennom A én gang, tell opp antall ganger hver av verdiene 0, 1, 2, 3, ..., m - 1
        forekommer, lagre antall ganger en verdi x forekommer i B(x)
    - Gå gjennom B én gang og fyll opp A med B(0) 0'er, B(1) 1'ere, B(2) 2'ere, ..., B(m - 1) verdier lik m - 1
     */

    public static void CountingSort(int[] A, int maksVerdi) {
        // Opprett en array B av lengde m fylt med nuller
        int B[] = new int[maksVerdi];
        Arrays.fill(B, 0);

        // Gå gjennom A én gang, tell opp antall ganger hver av verdiene 0, 1, 2, 3, ..., m - 1
        // forekommer, lagre antall ganger en verdi x forekommer i B(x)
        int n = A.length;
        for (int i = 0; i < n; i++) {
            B[A[i]]++;
        }

        // Gå gjennom B én gang og fyll opp A med B(0) 0'er, B(1) 1'ere, B(2) 2'ere, ..., B(m - 1) verdier lik m - 1
        int index = 0;
        for (int verdi = 0; verdi < B.length; verdi++) {
            for (int i = 0; i < B[verdi]; i++) {
                A[index++] = verdi;
            }
        }
    }

    private static void print(int array[]) {

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("] \n");

    }

    private static void fillUpArrayWithRandomValues(int[] array, int maksVerdi) {
        Random R = new Random();
        // lager en array med random tall, mellom 0 og maksverdi.
        for (int i = 0; i < array.length; i++) {
            array[i] = R.nextInt(maksVerdi);
        }
    }

    public static void main(String[] args) {
        // Skal sortere en array A med n ikke-negative heltall
        // Vet at alle tallene i A er mindre enn et tall m
        int n = 5;
        int maksVerdi = 10;
        int[] A = new int[n];

        fillUpArrayWithRandomValues(A, maksVerdi);
        CountingSort(A, maksVerdi);
        print(A);

    }
}
