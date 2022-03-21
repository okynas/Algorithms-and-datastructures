import java.io.*;
import java.util.Scanner;

// Hashing av tekststrenger med kjeding i lenket liste
// Bruker Javas innebygde hashfunksjon for strenger
//
// Enkel og begrenset implementasjon:
//
// - Ingen rehashing ved full tabell/lange lister
// - Tilbyr bare innsetting og sÃ¸king
//
public class HashChained {


    // Hashlengde
    private int hashLengde;

    // Hashtabell, pekere til lister
    private HashNode hashTabell[];

    // Antall elementer lagret i tabellen
    private int n;

    // Antall kollisjoner ved innsetting
    private int antKollisjoner;

    // KonstruktÃ¸r
    // Sjekker ikke for fornuftig verdi av hashlengden
    //
    public HashChained(int lengde) {
        hashLengde = lengde;
        hashTabell = new HashNode[lengde];
        n = 0;
        antKollisjoner = 0;
    }

    // Returnerer load factor
    public float loadFactor() {
        return ((float) n)/hashLengde;
    }

    // Returnerer antall data i tabellen
    public int antData() {
        return n;
    }

    // Returnerer antall kollisjoner ved innsetting
    public int antKollisjoner() {
        return antKollisjoner;
    }

    // Hashfunksjon
    int hash(String S) {
        int h = Math.abs(S.hashCode());
        return h % hashLengde;
    }

    // Innsetting av tekststreng med kjeding
    //
    void insert(String S) {
        // Beregner hashverdien
        int h = hash(S);

        // Ã˜ker antall elementer som er lagret
        n++;

        // Sjekker om kollisjon
        if (hashTabell[h] != null)
            antKollisjoner++;

        // Setter inn ny node fÃ¸rst i listen
        hashTabell[h] = new HashNode(S, hashTabell[h]);
    }

    // SÃ¸king etter tekststreng i hashtabell med kjeding
    // Returnerer true hvis strengen er lagret, false ellers
    //
    public boolean search(String S) {
        // Finner listen som S skal ligge i
        HashNode hN = hashTabell[hash(S)];

        // Leter gjennom listen
        while (hN != null) {
            // Har vi funnet tekststrengen?
            if (hN.data.compareTo(S) == 0)
                return true;
            // PrÃ¸ver neste
            hN = hN.neste;
        }
        // Finner ikke strengen, har kommet til slutten av listen
        return false;
    }


    /**
     * Implementering av fjerning av et element (teksstreng) i hashing med kjeding.
     * @param S, Streng som skal fjernes.
     */
    public boolean remove(String S) {
        HashNode denne = hashTabell[hash(S)];

        if (denne != null) {

            /**
             * hvis første element i hashtabellen skal fjernes,
             * DVS. denne (Node på indeks i hashtabellen, hvor en ny hash med samme string).
             *
             * Kan ikke bruke forrige.neste fordi vi fjerner første element, setter derfor kun
             * verdien i hashtabellen til å være denne sin neste.
             *
             */
            if (denne.data.compareTo(S) == 0) {
                hashTabell[hash(S)] = denne.neste;
                return true;
            }

            /**
             * flytter ett hakk fremover i hashtabellen.
             */
            HashNode forrige = denne;
            denne = denne.neste;

            /**
             * Så lenge denne (verdien i hashtabellen) ikke er null.
             */
            while (denne != null) {
                /**
                 * Sjekker om dennes verdi er det samme som String-inputen.
                 */
                if (denne.data.compareTo(S) == 0) {
                    forrige.neste = denne.neste;
                    return true;
                }

                forrige = denne;
                denne = denne.neste;
            }
        }

        // finner ikke strengern.
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
            if (argv.length != 1) {
                throw new IOException("Feil: Hashlengde mÃ¥ angis");
            }
            hashLengde = Integer.parseInt(argv[0]);
            if (hashLengde < 1 ) {
                throw new IOException("Feil: Hashlengde mÃ¥ vÃ¦re stÃ¸rre enn 0");
            }
        }
        catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        // Lager ny hashTabell
        HashChained hC = new HashChained(hashLengde);

        // Leser input og hasher alle linjer
        hC.insert("VW GOLF");
        hC.insert("VW POLO");
        hC.insert("VW TIGUAN");

        hC.remove("VW POLO");

        // Skriver ut hashlengde, antall data lest, antall kollisjoner
        // og load factor
        System.out.println("\n");
        System.out.println("Hashlengde  : " + hashLengde);
        System.out.println("Elementer   : " + hC.antData());
        System.out.printf( "Load factor : %5.3f\n",  hC.loadFactor());
        System.out.println("Kollisjoner : " + hC.antKollisjoner());

        // Et par enkle sÃ¸k
        String S = "Volkswagen Karmann Ghia";
        if (hC.search(S)) {
            System.out.println("\"" + S + "\"" + " finnes i hashtabellen");
        }
        S = "Il Tempo Gigante";
        if (!hC.search(S)) {
            System.out.println("\"" + S + "\"" + " finnes ikke i hashtabellen");
        }

    }
}

