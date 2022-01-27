import java.util.*;

public class RadixSortering {
    private static final int maksLength = 26;

    public static void sortCharacters(String a[], int maksTegn) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            a[i] = a[i].toLowerCase();
        }

        Queue<String>[] Q = (Queue<String>[]) new Queue[maksLength];

        for (int i = 0; i < maksLength; i++) {
            Q[i] = new LinkedList<>();
        }

        // sorterer på et og et siffer., høyre mot venstre.
        for (int m = maksTegn; m > 0; m--) {
            for (int i = 0; i < n; i++) {
                int index;
                if (a[i].length() < m) {
                    index = 0;
                } else {
                    index = a[i].charAt(m-1) - 'a';
                }
                Q[index].add(a[i]);
            }

            // tømmer køene, og legger tall fortløpende på a.
            int j = 0;
            for (int i = 0; i < maksLength; i++) {
                while (!Q[i].isEmpty()) {
                    a[j++] = (String) Q[i].remove();
                }
            }
        }
    }

    public static void main(String[] args) {
    // Leser antall tall og antall siffer fra kommandolinja
        int antallSomSkalSorteres = 24; // Integer.parseInt(args[0]);
        int strPaaElementet = 9; // Integer.parseInt(args[1]);

        String S[] = {"Arne", "Reidar", "Ottar", "Harry", "Cashmere",
                "Cat", "Peder", "Bjarne", "Christian", "Robert",
                "Garth", "Rick", "Levon", "Richard", "Robbie",
                "Ronnie", "Bob", "Frank", "Zappa", "Aaron",
                "Bjartmar", "Adolf", "Hermann", "Vidkun"};

        // Sorterer
        RadixSortering rS = new RadixSortering();
        sortCharacters(S, strPaaElementet);

        // skriver ut alle i riktig rekkefølge.
        for (int i = 0; i < antallSomSkalSorteres; i++) {
            System.out.println(S[i]);
        }
    }
}
