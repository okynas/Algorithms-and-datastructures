public class Springerproblemet {

    /**
     * Definerer variabler som skal bli brukt igjennom hele koden
     */
    public static int n;
    public static int[][] sjakkBrettet;
    public static int[][] trekk;
    public static int[][] utskrift;

    public static final int LEDIG = 0, BRUKT = 1;
    public static final int[] X = {2, 2, 1, -1, -2, -2, -1, 1};
    public static final int[] Y = {-1, 1, -2, -2, -1, 1, 2, 2};

    public static final int ANTALL_TREKK_FOR_EN_LOPER = 8;

    /**
     *
     * En konstruktuør for å opprette programmet.
     * Oppretter også variablene sjakkBrettet, trekk og utskrift
     * sjakkBrettet er selve løsninga,
     *
     * trekk er en 2d-liste som holder styr på hvilket trekk som er gjort og posisjonen til
     * x og y koordinatet til dette trekket.
     *
     *
     *
     * @param n størrelsen på brettet (n x n)
     */
    public Springerproblemet(int n) {
        this.n = n;
        sjakkBrettet = new int[n][n];
        trekk = new int[n*n][2];

        utskrift = new int[n][n];

        /**
         * initialiserer sjakkbrettet hvor alle plassene er ubrukte og ledige.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sjakkBrettet[i][j] = LEDIG;
                utskrift[i][j] = 0;
            }
        }

        /**
         * sjekker om det finnes en løsning, og starter programmet her.
         */
        if (!findPath(0,0, 1)) {
            System.out.println("No solutions found!");
        } else {
            System.out.println("Found solution!");
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
    public static boolean findPath(int i, int j, int antallTrekk) {

        /**
         * Sjekker om det er gjort MAKS trekk, og programmet avsluttes
         */
        if (antallTrekk == n*n) {
            return true;
        }

        /**
         * For hver av de 8 kombinasjonene, lag ny x og y, og sjekk om løperen kan bevege seg i den retningen.
         */
        for (int skritt = 0; skritt < ANTALL_TREKK_FOR_EN_LOPER; skritt++) {
            int nyX = i + X[skritt];
            int nyY = j + Y[skritt];

            /**
             * Sjekker om det er et lovlig trekk som gjøres.
             * Det vil si om den nye x og y er innenfor (n x n) brettet,
             * og at den nye posisjonen er ledig og ikke vært på fra før.
             */
            if ( checkAvailability(nyX, nyY, sjakkBrettet) ) {

                /**
                 * Setter gjeldene rute i sjakkbrettet til å være brukt
                 */
                sjakkBrettet[nyX][nyY] = BRUKT;

                /**
                 * Hvis finnVei med den nye x og y, og neste trekk en er sann, altså at springeren kan gå
                 * den veien vil vi sette posisjonen som brukt, og returnere true, som vil da gå ut av det
                 * gjeldende funksjonskallet ( rekursjonen ). Hvis ikke, setter vi sjakkbrettets posisjon til
                 * å bli ledig.
                 */
                if (findPath(nyX, nyY, antallTrekk + 1)) {
                    trekk[antallTrekk][0] = nyX;
                    trekk[antallTrekk][1] = nyY;

                    /**
                     * setter utskrift array til å inneholde gjeldende trekk, for å visualisere hvor
                     * springeren beveger seg.
                     */
                    utskrift[nyX][nyY] = antallTrekk;
                    return true;
                } else {
                    sjakkBrettet[nyX][nyY] = LEDIG;
                }

            }
        }

        /**
         * Hvis programmet har kommet hit, så fungerer ikke denne løsningen, og programmet må
         * derfor gå tilbake (backtracking)
         */
        return false;
    }

    /**
     * Printer ut hvilke trekk som er gjort, fra 0 til n*n.
     * Og skriver de ut i den posisjonen den skal være i.
     *
     * f.eks
     * 0 7 18 13 22
     * 17 12 21 8 19
     * 4 1 6 23 14
     * 11 16 3 20 9
     * 2 5 10 15 24
     */
    public static void printMoves() {
        System.out.println("Every step the knight has taken, visualized in the chess board!");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(utskrift[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @return en string av alle trekk som er gjennomført i løsningen
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nEach step the knight has taken: \n");
        for (int i=0; i < n*n - 1; i++) {
            s.append("(").append(trekk[i][0]).append(", ").append(trekk[i][1]).append(") -> (").append(trekk[i + 1][0]).append(", ").append(trekk[i + 1][1]).append(")\n");
        }
        return s.toString();
    }

    /**
     * Kjører programmet med n = 5, dvs størrelsen på sjakkbrettet er 5x5.
     * Printer også ut trekkene som er gjort.
     *
     * @param args
     */
    public static void main(String[] args) {
        Springerproblemet springerproblemet = new Springerproblemet(5);
        System.out.println(springerproblemet);
        printMoves();
    }
}
