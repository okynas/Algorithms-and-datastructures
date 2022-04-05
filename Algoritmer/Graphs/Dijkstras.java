package Graphs;

public class Dijkstras extends enkelVektetGraf{
    public Dijkstras(String filNavn) {
        super(filNavn);
    }

    public void dijkstraSSSP(int S) {
        // array for å merke av noder som vi allerede har funnet korteste vei til fra S
        boolean[] funnet = new boolean[n];
        // array for å lagre hittil korteste vei til hver node fra S
        int[] avstand = new int[n];

        // initialiserer de to hjelpe arrayene
        for (int i = 0; i < n; i++) {
            avstand[i] = (i == S) ? 0 : UENDELIG;
            funnet[i] = false;
        }

        // nåværende antall som er funnet og node
        int denne = S, antall = 0;

        while (antall < n) {
            // finner minste avstand fra S som ikke er funnet enda.
            int minste = UENDELIG;

            for (int i = 0; i < n; i++) {
                if (!funnet[i] && avstand[i] < minste) {
                    denne = i;
                    minste = avstand[i];
                }
            }

            // oppdaterer avstand for alle naboer til gjenværende node som ikke er funnet.
            for (int i = 0; i < n; i++) {
                if (!funnet[i]) {
                    int l = avstand[denne] + lengde[denne][i];
                    if (l < avstand[i]) {
                        avstand[i] = l;
                    }
                }
            }

            // markerer at vi har funnet korteste avstand til nåvøærende node.
            funnet[denne] = true;
            antall++;
        }

        // skriver ut løsning
        System.out.printf("%2s ", data[S]);
        for (int i = 0; i < n; i++) {
            if (avstand[i] == UENDELIG) {
                System.out.printf(" * ", avstand[i]);
            }
            else {
                System.out.printf(" %2d ", avstand[i]);
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        String filnavn = "";
        /*try {
            if (args.length != 1) {
                throw new IOException("Mangler filnavn");
            }
            filnavn = args[0];
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }*/

        filnavn = "Graphs\\graf_17.txt";

        Dijkstras G = new Dijkstras(filnavn);
        System.out.println("Graf: ");
        G.skriv();

        System.out.println("\n Dijkstras:");
        G.skrivHeader();

        for (int S = 0; S < G.antallNoder(); S++) {
            G.dijkstraSSSP(S);
        }
    }
}
