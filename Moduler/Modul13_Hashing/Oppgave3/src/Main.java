import java.util.Arrays;

public class Main {

    public static int hash_a(int nøkkel, int hashLengde) {
        return  nøkkel % hashLengde;
    }

    static int hash_b(int nøkkel, int hashLengde) {
        int sum = 0, tall = nøkkel;

        while (tall != 0) {
            sum += tall % 10;
            tall /= 10;
        }

        return sum % hashLengde;
    }

    public static void main(String[] args) {
        int hashLengde[] = {11, 13};
        int nøkkel[] = {10, 100, 32, 45, 58, 126, 3, 29, 200, 400, 0};

        System.out.println();

        // Deloppgave a

        for (int hL : hashLengde) {
            int[] brukt = new int[hL];
            Arrays.fill(brukt, 0);

            System.out.print("hL=" + hL + "  ");

            for (int k : nøkkel) {
                int h = hash_a(k, hL);
                brukt[h]++;
                System.out.printf("%4d:%-2d ", k, h);

            }

            int antKollisjoner = 0;
            for (int j = 0; j < hL; j++) {
                if (brukt[j] > 0) {
                    antKollisjoner += (brukt[j] - 1);
                }
            }
            System.out.println("\n" + antKollisjoner + " kollisjoner\n");
        }

        // Deloppgave b og c

        for (int hL : hashLengde) {
            int[] brukt = new int[hL];
            Arrays.fill(brukt, 0);

            System.out.print("hL=" + hL + "  ");

            for (int k : nøkkel) {
                int h = hash_b(k, hL);
                brukt[h]++;
                System.out.printf("%4d:%-2d ", k, h);

            }

            int antKollisjoner = 0;
            for (int j = 0; j < hL; j++) {
                if (brukt[j] > 0) {
                    antKollisjoner += (brukt[j] - 1);
                }
            }
            System.out.println("\n" + antKollisjoner + " kollisjoner\n");
        }
    }


}
