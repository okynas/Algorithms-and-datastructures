/**
 * Algoritme:
 *
 * 1. Gå gjennom hele grafen, beregn og ta vare på inngraden til alle noder.
 * 2. Legg alle noder med inngrad lik 0 i en mengde S.
 * 3. Så lenge det finnes noder igjen i S:
 *      4. Ta ut en node a fra mengden S
 *      5. Skriv ut noden a
 *      6. For hver av noden a sine naboer:
 *          7. Reduser inngraden til naboen med 1
 *          8. Hvis denne naboen nå har fått inngrad lik 0, legg den til i mengden S
 */

import java.util.LinkedList;
import java.util.Queue;

public class topSort extends enkelGraf {

    public int[] inngrad;

    public topSort(String filNavn) {
        super(filNavn);
        inngrad = new int[n];
    }

    public void findAndPrint() {

        int inngrad_verdi;
        Queue<String> S = new LinkedList<>();

        /**
         * STEG 1 - Går igjennom hele grafen. Regner så ut inngraden til alle nodene.
         * Inngraden lagres i en en-dimmensjonal array.
         */
        for (int gjeldende = 0; gjeldende < n; gjeldende++) {
            inngrad_verdi = 0;

            for (int gjeldende_nabo = 0; gjeldende_nabo < n; gjeldende_nabo++) {
                if (nabo[gjeldende_nabo][gjeldende] && gjeldende != gjeldende_nabo) {
                    inngrad_verdi++;
                }
            }
            inngrad[gjeldende] = inngrad_verdi;
        }

        /**
         * STEG 2 - Legg alle noder med inngrad lik 0 i en mengde S.
         */
        for (int i = 0; i < n; i++) {
            if (inngrad[i] == 0) {
                S.add(data[i]);
            }
        }

        /**
         * STEG 3 - Gå igjennom alle nodene i S, så lenge den har elementer.
         */
        while(!S.isEmpty()) {
            /**
             * STEG 4 - Ta ut en node a fra mengden S
             */
            String a = S.remove();

            /**
             * STEG 5 - Skriv ut noden a
             */
            System.out.print(a + " ");

            /**
             * STEG 6 - For hver av naboene til a
             */
            for (int gjeldende_node = 0; gjeldende_node < n; gjeldende_node++) {
                // System.out.print(data[gjeldende_node] + ": ");
                for (int gjeldende_nabo = 0; gjeldende_nabo < n; gjeldende_nabo++) {

                    if (nabo[gjeldende_node][gjeldende_nabo] && gjeldende_node != gjeldende_nabo) {

                        /**
                         * STEG 7 - Mink inngraden til naboene til a med 1.
                         */
                        inngrad[gjeldende_nabo]--;

                        /**
                         * STEG 8 - Hvis denne naboen nå har fått inngrad lik 0, legg den til i mengden S
                         */
                        if (inngrad[gjeldende_nabo] == 0) {
                            S.add(data[gjeldende_nabo]);
                        }

                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        topSort T = new topSort("graf_topsort_2.txt");
        T.findAndPrint();
    }
}