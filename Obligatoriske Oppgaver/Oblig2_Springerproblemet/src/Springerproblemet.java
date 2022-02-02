public class Springerproblemet {

    /**
     * Definerer variabler som skal bli brukt igjennom hele koden
     */
    public static final int LEDIG = 0, BRUKT = 1;

    public static int n;
    public static int[][] sjakkBrettet;

    /**
     *
     * En konstruktuør for å opprette programmet.
     *
     * @param n størrelsen på brettet (n x n)
     */
    public Springerproblemet(int n) {
        this.n = n;
        sjakkBrettet = new int[n][n];

        // initialiserer sjakkbrettet hvor alle plassene er ubrukte og ledige.
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
        return false;
    }

    public static void main(String[] args) {
        Springerproblemet springerproblemet = new Springerproblemet(5);
        finnVei(0,0);

    }
}
