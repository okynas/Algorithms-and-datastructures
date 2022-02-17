import java.util.Random;

public class TilfeldigPermutasjon {
    /**
     * Programmer en metode som fyller en array av lengde n med en tilfeldig permutasjon av heltallene fra 1 til n.
     * Alle permutasjoner skal være like sannsynlige, og random-funksjonen i Java skal kalles nøyaktig n - 1 ganger.
     * En slik funksjon kan f.eks. brukes til å "stokke kortene" i spillprogrammer.
     */

    private static Random r = new Random();

    public static void main(String[] args) {
        // testprogram
        int[] p = new int[9];
        System.out.println("Permutasjon fra tallene 1 til 9");
        for (int i = 0; i <= 9; i++) {
            stokk(p);
            for(int j = 0; j < 9; j++) {
                System.out.print(p[j] + " ");
            }
            System.out.println("");

        }

    }

    public static void stokk(int[] p) {

        int i, tilf, temp, n = p.length;

        // fyller en array med lengde n med tallene 1,2,3,4,...
        for (i = 0; i < n; i++) {
            p[i] = i + 1;
        }

        // stokker og bytter om:
        for (i = 0; i < n - 1; i++) {
            // finner tilfeldig tall
            tilf = (i+1) + r.nextInt(n-i-1);

            // swapper / bytter om.
            temp = p[i];
            p[i] = p[tilf];
            p[tilf] = temp;
        }


    }
}
