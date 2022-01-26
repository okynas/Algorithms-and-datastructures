import java.util.*;

public class PostKontor
{
    int    antKasser;  // Antall Ã¥pne kasser/betjeningsluker
    int    maksBetTid; // Maksimal betjeningstid for en  kunde
    int    maksTid;    // Antall tidssteg som simuleringen skal gÃ¥
    float  P_kunde;    // Sannsynligheten for kundeankomst i hvert tidssteg

    // KonstruktÃ¸r som leser data/parametre for simuleringen
    public PostKontor(String navn) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til " + navn + " postkontor");
        System.out.print("Antall tidsteg?: ");
        maksTid = scanner.nextInt();
        System.out.print("Antall kasser?: ");
        antKasser = scanner.nextInt();
        System.out.print("Lengste betjeningstid?: ");
        maksBetTid = scanner.nextInt();
        System.out.print("Gj.snittlig antall kundeankomster per tidsenhet? (< 1.0): ");
        P_kunde = scanner.nextFloat();
    }

    // Indre klasse som lagrer ankomsttiden for en kunde
    private static class kunde {
        private int ankomst;
        public kunde(int ankomst) { this.ankomst = ankomst; }
        public int venteTid(int tid) { return tid - ankomst; }
    }

    // Indre klasse som lagrer tidspunktet nÃ¥r en kasse blir ledig
    private static class kasse {
        private int tidFerdigKunde;
        public kasse() { tidFerdigKunde = 0; }
        public void settTidFerdigKunde(int tid) { tidFerdigKunde = tid; }
        public boolean erLedig(int tid) { return tid >= tidFerdigKunde; }
    }

    // Metode som gjÃ¸r selve kÃ¸simuleringen
    public void simuler() {
        kasse[] kasser = new kasse[antKasser];
        // Variable for Ã¥ samle opp data underveis i simuleringen
        int totalBetTid   = 0; // Sum betjeningstid for alle betjente kunder
        int totalVenteTid = 0; // Sum ventetid for alle betjente kunder
        int totAntKunder  = 0; // Totalt antall kunder betjent
        int totAntledig   = 0; // Totalt antall ganger en kasse var ledig

        // Initierer trekkingen av tilfeldige tall
        Random R = new Random();

        // Lager en ny, tom KundeKÃ¸
        Queue<kunde> KundeQ = new LinkedList<>();
        ArrayQueue<kunde>[] KundeQueue = (ArrayQueue<kunde>[]) (new ArrayQueue[antKasser]);

        // Setter alle kassene til Ã¥ vÃ¦re ledige
        for (int i = 0; i < antKasser; i++) {
            kasser[i] = new kasse();
            KundeQueue[i] = new ArrayQueue<kunde>();
        }

        // Simulerer et og et tidssteg
        for (int tid = 0; tid < maksTid; tid++) {
            // Trekker tilfeldig tall. Hvis tallet er mindre enn sannsynligheten (P_kunde), settes ny kunde inn i kø
            if (R.nextDouble() < P_kunde) {
                int kortesteQueue = 0;
                int minLengde = KundeQueue[0].size();

                for (int i = 0; i < antKasser; i++) {
                    if (KundeQueue[i].size() < minLengde) {
                        minLengde = KundeQueue[i].size();
                        kortesteQueue = i;
                    }
                    KundeQueue[kortesteQueue].enqueue(new kunde(tid));
                }

            }
            // Tar ut Ã©n kunde fra kÃ¸en for hver ledige kasse
            for (int i = 0; i < antKasser; i++) {
                if (kasser[i].erLedig(tid)) {
                    if (!KundeQueue[i].isEmpty()) {
                        // Trekk en tilfelding betjeningstid
                        int betTid = R.nextInt(maksBetTid) + 1;

                        // Tar ut kunde fra kÃ¸
                        kunde k = KundeQueue[i].dequeue();
                        kasser[i].settTidFerdigKunde(tid + betTid);

                        // Samler opp data fra dette tidssteget
                        totalBetTid += betTid;
                        totalVenteTid += k.venteTid(tid);
                        totAntKunder++;
                    } else {
                        // KÃ¸en er tom og vi har en ledig kasse
                        totAntledig++;
                    }
                }
            }
        }

        // Simulering ferdig, skriv ut litt statistikk
        System.out.println("\nPostkontoret er nå stengt");
        System.out.println("Antall kunder behandlet: " + totAntKunder);

        int antallKunder = 0;
        for (int i = 0; i < antKasser; i++) {
            antallKunder += KundeQueue[i].size();
        }

        System.out.println("Antall kunder i kø: " + antallKunder);
        if (totAntKunder > 0) {
            System.out.println("Gjennomsnittlig betjeningstid: " + (float) totalBetTid / (float) totAntKunder);
            System.out.println("Gjennomsnittlig ventetid: " + (float) totalVenteTid / (float) totAntKunder);
        }
        System.out.println("Gjennomsnittlig antall ledige kasser: " + (float) totAntledig / (float) maksTid );

    }

    // Testprogram
    public static void main(String[] args)
    {
        PostKontor pk = new PostKontor("Remmen");
        pk.simuler();
    }

}