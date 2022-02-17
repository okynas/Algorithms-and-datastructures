import java.util.Random;

public class FordelingLeker {
    private static int n = 0;               // antall barn
    private static boolean ferdig = false;  // alle fordelinger er gjort
    private static int[] p;                 // permutasjon
    private static boolean[] brukt;         // merker av utdelte leketøy.
    private static int[] antallOnsker;      // antall ønsker hvert barn har
    private static int[][] onske;           // onskelistene for hvert barn.

    public static void DelUtGaver(int barn) {
        if (barn == n) {
            ferdig = true;
        } else {
            // prøver å gi et barn en av ønskene den har
            for (int i = 0; i < antallOnsker[barn]; i++) {
                if (!brukt[onske[barn][i]]) {
                    p[barn] = onske[barn][i];
                    brukt[onske[barn][i]] = true;

                    DelUtGaver(barn + 1);

                    if (ferdig) {
                        return;
                    }
                    brukt[onske[barn][i]] = false;
                }
            }
        }

    }

    public static void test() {
        // Lager et testprogram.

        n = 10;
        p = new int[n];
        antallOnsker = new int[n];
        onske = new int[n][n];
        ferdig = false;
        brukt = new boolean[n];

        for (int i = 0; i < n; i++) {
            brukt[i] = false;
        }

        // alle barna ønsker seg 3 leker
        for (int barn = 0; barn < n; barn++) {
            antallOnsker[barn] = 3;
        }

        Random r = new Random();
        boolean ulikeOnsker;
        for (int barn = 0; barn < n; barn++) {
            do {
                // trekk tilfeldig ønske til barn
                for (int i = 0; i < antallOnsker[barn] - 1; i++) {
                    onske[barn][i] = r.nextInt(n);
                }
                // sikrer at alle ønsker til barn er ulike
                ulikeOnsker = true;
                for (int i = 0; i < antallOnsker[barn] - 1; i++) {
                    for (int j = i + 1; j < antallOnsker[barn]; j++) {
                        if (onske[barn][i] == onske[barn][j]) {
                            ulikeOnsker = false;
                        }
                    }
                }
            } while (!ulikeOnsker);
        }

        // skriv ut ønskeliste:
        for (int barn = 0; barn < n; barn++) {
            System.out.print("Barn" + barn + " ønsker seg leketøy: ");
            for (int j = 0; j < antallOnsker[barn]; j++) {
                System.out.print(onske[barn][j] + " ");
            }
            System.out.println();
        }

        DelUtGaver(0);

        if (ferdig) {
            System.out.println("\n Fordeling: ");
            for(int barn = 0; barn < n; barn++) {
                System.out.println("Barn" + barn + ": får utdelt lektetøy: " + p[barn]);
            }
        } else {
            System.out.println("\n Klarer ikke oppfylle alle ønskene");
        }

    }

    public static void main(String[] args) {
        test();
    }
}
