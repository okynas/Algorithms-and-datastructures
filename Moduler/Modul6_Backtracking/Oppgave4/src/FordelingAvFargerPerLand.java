public class FordelingAvFargerPerLand {
    private static int n = 10;
    private static boolean[][] fellesGrenser;
    private static int[] farge;
    public static void main(String[] args) {
        // starter programmet
        fargeLegg(0);
    }

    public static void fargeLegg(int land) {
        if (land == n - 1) {
            bruk_fargelegging();
        } else {
            int fargeTall;
            int nabo;
            boolean[] fargeBrukt = {false, false, false, false};

            // for hver av naboene
            for (nabo = 0; nabo < land; nabo++) {
                // sjekker om fargen til naboen er brukt
                if (fellesGrenser[land][nabo]) {
                    fargeBrukt[farge[land] - 1] = true;
                }
            }
            for (fargeTall = 1; fargeTall <= 4; fargeTall++) {
                if (!fargeBrukt[fargeTall - 1]) {
                    farge[land] = fargeTall;
                    fargeLegg(land+1);
                }
            }
        }
    }

    public static void bruk_fargelegging() {

    }
}
