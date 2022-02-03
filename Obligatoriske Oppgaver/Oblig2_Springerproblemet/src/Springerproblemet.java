public class Springerproblemet {

    /**
     * Definerer variabler som skal bli brukt igjennom hele koden
     */
    public static int n;
    public static int[][] sjakkBrettet;
    public static int antallTrekk;

    public static final int LEDIG = 0, BRUKT = 1;
    public static final int[] X = {2, 2, 1, -1, -2, -2, -1, 1};
    public static final int[] Y = {-1, 1, -2, -2, -1, 1, 2, 2};

    public static final int ANTALL_TREKK_FOR_EN_LOPER = 8;

    /**
     *
     * En konstruktuør for å opprette programmet.
     *
     * @param n størrelsen på brettet (n x n)
     */
    public Springerproblemet(int n) {
        this.n = n;
        sjakkBrettet = new int[n][n];

        /**
         * initialiserer sjakkbrettet hvor alle plassene er ubrukte og ledige.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sjakkBrettet[i][j] = LEDIG;
            }
        }
    }

    /**
     *
     * @param x nye posisjon for x
     * @param y nye poisjon for y
     * @param board sjakkbrettet hvor springen skal bevege seg
     * @return true hvis x og y er innenfor grensa (n x n), og x og y ikke er brukt fra før.
     */
    private static boolean checkAvailability(int x, int y, int[][] board) {
        return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == LEDIG;
    }

    /**
     *
     * @param i - kolonner
     * @param j - rader
     * @return true hvis den finner en vei slik at springeren kan nå alle rutene i sjakkbrettet på n x n.
     */
    public static boolean finnVei(int i, int j) {

        /**
         * Sjekker om det er gjort MAKS trekk, og programmet avsluttes
         */
        if (antallTrekk == n*n) {
            return true;
        }

        /**
         * Setter gjeldene rute i sjakkbrettet til å være brukt
         * øker antall trekk.
         */
        sjakkBrettet[i][j] = BRUKT;
        antallTrekk++;

        /**
         * For hver av de 8 kombinasjonene, lag ny x og y, og sjekk om løperen kan bevege seg i den retningen.
         */
        for (int skritt = 0; skritt < ANTALL_TREKK_FOR_EN_LOPER; skritt++) {
            int nyX = i + X[skritt];
            int nyY = i + Y[skritt];

            /**
             * Sjekker om det er et lovlig trekk som gjøres.
             * Det vil si om den nye x og y er innenfor (n x n) brettet,
             * og at den nye posisjonen er ledig og ikke vært på fra før.
             */
            if ( checkAvailability(nyX, nyY, sjakkBrettet) ) {

                /**
                 * Hvis finnVei med den nye x og y en er sann, altså at springeren kan gå den veien
                 * vil vi sette posisjonen som brukt, og returnere true, som vil da gå ut av det
                 * gjeldende funksjonskallet ( rekursjonen ).
                 */
                if (finnVei(nyX, nyY)) {
                    sjakkBrettet[i][j] = BRUKT;
                    return true;
                }

            }
        }

        /**
         * Hvis programmet har kommet hit, så fungerer ikke denne løsningen, og programmet må derfor gå tilbake (backtracking)
         * dette gjøres i form av å sette den gjeldende posisjonen til ledig igjen.
         */

        sjakkBrettet[i][j] = LEDIG;


        return false;
    }

    @Override
    public String toString() {
        String out = "";
        return super.toString();
    }

    public static void main(String[] args) {
        Springerproblemet springerproblemet = new Springerproblemet(5);
        System.out.println(finnVei(0,0));

    }
}
