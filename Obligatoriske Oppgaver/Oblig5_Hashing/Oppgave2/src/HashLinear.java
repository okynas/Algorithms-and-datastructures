import java.io.*;
import java.util.Scanner;

// Hashing av tekststrenger med lineÃ¦r probing
// Bruker Javas innebygde hashfunksjon for strenger
//
// Enkel og begrenset implementasjon:
//
// - Ingen rehashing ved full tabell
// - Tilbyr bare innsetting og sÃ¸king
//
public class HashLinear {
    // Hashlengde
    private int hashLengde;

    // Hashtabell
    private String hashTabell[];

    // Antall elementer lagret i tabellen
    private int n;

    // Antall probes ved innsetting
    private int antProbes;

    // KonstruktÃ¸r
    // Sjekker ikke for fornuftig verdi av hashlengden
    //
    public HashLinear(int lengde) {
        hashLengde = lengde;
        hashTabell = new String[lengde];
        n = 0;
        antProbes = 0;
    }

    // Returnerer load factor
    public float loadFactor() {
        return ((float) n)/hashLengde;
    }

    // Returnerer antall data i tabellen
    public int antData() {
        return n;
    }

    // Returnerer antall probes ved innsetting
    public int antProbes() {
        return antProbes;
    }

    // Hashfunksjon
    int hash(String S) {
        int h = Math.abs(S.hashCode());
        return h % hashLengde;
    }

    // Innsetting av tekststreng med lineÃ¦r probing
    // Avbryter med feilmelding hvis ledig plass ikke finnes
    //
    void insert(String valueToInsert)  {
        // Beregner hashverdien
        int hashIndex = hash(valueToInsert);
        int hashExistingValue;
        String existingValue;
        int distanceBtwOriginalPlaceAndInsertionValue = 0;
        int distanceBtwOriginalPlaceAndExisting;
        int nextHashIndex = hashIndex;

        /**
         * HVIS en indeks, neste, i hashtabellen er i bruk:
         */
        while (hashTabell[nextHashIndex] != null) {
            // Ny probe
            antProbes++;

            /**
             * existingValue = dataelementet som allerede ligger på indeksplasseringa.
             *
             * hasher existingValue, for å finne indeksen existingValue opprinnelig skal ligge på,
             * og regner avstand mellom gjeldende indeks og hashen.
             *
             * valueToInsert = elementet som skal settes inn.
             */
            existingValue = hashTabell[nextHashIndex];
            hashExistingValue = hash(existingValue);
            distanceBtwOriginalPlaceAndExisting = nextHashIndex - hashExistingValue;

            /**
             * Velger å flytte dataelementet "ett hakk til høyre" (last come, first serve) hvis valueToInsert har flyttet
             * seg lengre vekk fra original hashindeks enn existingValue
             *
             * Hvis ikke, dataelementet som ligger på posisjon existingValue skal ikke flyttes, setter valueToInsert inn på neste
             * ledige posisjon.
             */
            if (distanceBtwOriginalPlaceAndExisting < 0) {
                distanceBtwOriginalPlaceAndExisting = nextHashIndex + (hashLengde - hashExistingValue);
            }

            if (distanceBtwOriginalPlaceAndExisting < distanceBtwOriginalPlaceAndInsertionValue) {
                hashTabell[nextHashIndex] = valueToInsert;
                valueToInsert = existingValue;
                distanceBtwOriginalPlaceAndInsertionValue = distanceBtwOriginalPlaceAndExisting;
            }

            // Denne indeksen er opptatt, prÃ¸ver neste
            nextHashIndex++;

            // Wrap-around
            if (nextHashIndex >= hashLengde) {
                nextHashIndex = 0;
            }

            // Hvis vi er kommet tilbake til opprinnelig hashverdi, er
            // tabellen full og vi gir opp (her ville man normalt
            // doblet lengden pÃ¥ hashtabellen og gjort en rehashing)
            if (nextHashIndex == hashIndex) {
                System.err.println("\n Hashtabell full, avbryter");
                System.exit(0);
            }
        }

        // Lagrer tekststrengen pÃ¥ funnet indeks
        hashTabell[nextHashIndex] = valueToInsert;

        // Ã˜ker antall elementer som er lagret
        n++;
    }

    // SÃ¸king etter tekststreng med lineÃ¦r probing
    // Returnerer true hvis strengen er lagret, false ellers
    //
    boolean search(String S) {
        // Beregner hashverdien
        int h = hash(S);

        // LineÃ¦r probing
        int neste = h;

        while (hashTabell[neste] != null) {
            // Har vi funnet tekststrengen?
            if (hashTabell[neste].compareTo(S) == 0)
                return true;

            // PrÃ¸ver neste mulige
            neste++;

            // Wrap-around
            if (neste >= hashLengde)
                neste = 0;

            // Hvis vi er kommet tilbake til opprinnelig hashverdi,
            // finnes ikke strengen i tabellen
            if (neste == h)
                return false;
        }

        // Finner ikke strengen, har kommet til en probe som er null
        return false;
    }

    // Enkelt testprogram:
    //
    // * Hashlengde gis som input pÃ¥ kommandolinjen
    //
    // * Leser tekststrenger linje for linje fra standard input
    //   og lagrer dem i hashtabellen
    //
    // * Skriver ut litt statistikk etter innsetting
    //
    // * Tester om sÃ¸k fungerer for et par konstante verdier
    //
    public static void main(String argv[]) {
        // Hashlengde leses fra kommandolinjen
        int hashLengde = 0;
        Scanner input = new Scanner(System.in);
        try {
            if (argv.length != 1)
                throw new IOException("Feil: Hashlengde mÃ¥ angis");
            hashLengde = Integer.parseInt(argv[0]);
            if (hashLengde < 1 )
                throw new IOException("Feil: Hashlengde mÃ¥ vÃ¦re stÃ¸rre enn 0");
        }
        catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        // Lager ny hashTabell
        HashLinear hL = new HashLinear(hashLengde);

        /**
         * ENDRE DENNE HVIS DU SKAL KJØRE PÅ LINUX / MAC.
         *
         * vvvvvv
         */
        // Leser input og hasher alle linjer
        /*while (input.hasNext()) {
            hL.insert(input.nextLine());
        }*/

        hL.insert("VW GOLF");
        hL.insert("VW POLO");
        hL.insert("VW TIGUAN");
        /**
         * ^^^^
         * ENDRE DENNE
         */

        // Skriver ut hashlengde, antall data lest, antall kollisjoner
        // og load factor
        System.out.println("Hashlengde  : " + hashLengde);
        System.out.println("Elementer   : " + hL.antData());
        System.out.printf( "Load factor : %5.3f\n",  hL.loadFactor());
        System.out.println("Probes      : " + hL.antProbes());

        // Et par enkle sÃ¸k
        String S = "Volkswagen Karmann Ghia";
        if (hL.search(S))
            System.out.println("\"" + S + "\"" + " finnes i hashtabellen");
        S = "Il Tempo Gigante";
        if (!hL.search(S)) {
            System.out.println("\"" + S + "\"" + " finnes ikke i hashtabellen");
        }
    }
}

