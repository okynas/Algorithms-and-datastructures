public class Main {
    // TEST ORD: PAL LAP PAM MAP PAT PET SET SAT TAT BAT
    // Hashlengde:  10, 11, 13, 16, 17, 18 og 19

    public static int hashString(String S, int hashLengde) {
        int h = Math.abs(S.hashCode());
        return h % hashLengde;
    }

    public static void main(String[] args) {
        int hashLengde[] = {10, 11, 13, 16, 17, 18, 19};
        String S[] = {"PAL", "LAP", "PAM", "MAP", "PAT", "PET", "SET", "SAT", "TAT", "BAT"};

        System.out.println();
        for (int i = 0; i < hashLengde.length; i++) {
            int hL = hashLengde[i];
            int brukt[] = new int[hL];
            for (int j = 0; j < S.length; j++) {
                int h = hashString(S[j], hL);
                brukt[h]++;
                System.out.printf("%s:%-2d ", S[j], h);
            }
            int antallKollisjoner = 0;
            for (int j = 0; j < hL; j++) {
                if (brukt[j] > 0) {
                    antallKollisjoner += (brukt[j] - 1);
                }
            }
            System.out.println("\n " + antallKollisjoner + " kollisjoner.\n");
        }
    }
}
