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
             */
            // if (nyX >= 0 && nyX <= n && ny)
        }


        return false;
    }

    public static void main(String[] args) {
        Springerproblemet springerproblemet = new Springerproblemet(5);
        finnVei(0,0);

    }
}
