import java.util.*;

public class Main {

    public static final int MAKS_ANTLL = 10;
    public static int ANTALL_FLY_AVVIST = 0;
    public static int ANTALL_FLY_BEHANDLET = 0;
    public static int ANTALL_FLY_LANDA = 0;
    public static int ANTALL_FLY_TATT_AV = 0;
    public static int TOTAL_VENTETID_LANDING = 0;
    public static int TOTAL_VENTETID_AVGANG = 0;
    public static double GJENNOMSNITT_VENTETID_LANDING = 0.0;
    public static double GJENNOMSNITT_VENTETID_AVGANG = 0.0;
    public static int TOTAL_LENGDE_AV_LANDING = 0;
    public static int TOTAL_LENGDE_AV_AVGANG = 0;

    public static double GJSNITT_LENGDE_AV_LANDING = 0.0;
    public static double GJSNITT_LENGDE_AV_AVGANG = 0.0;

    public static void main(String[] args) {

        /*
        Initier begge køene til å være tomme

        For hver tidssteg i simuleringen

        Trekk et tilfeldig antall nye fly som kommer for å lande

        For hvert nytt fly som kommer for å lande
        Hvis landingskøen er full
        Avvis det nye flyet (henvis til annen flyplass)
        ellers
        Sett det nye flyet sist i landingskøen

        Trekk et tilfeldig antall nye fly som kommer for å ta av

        For hvert nytt fly som kommer for å ta av
        Hvis avgangskøen er full
        Avvis det nye flyet (avgang må prøves senere)
        ellers
        Sett det nye flyet sist i avgangskøen

        Hvis landingskøen ikke er tom
        Ta ut første fly i landingskøen og la det få lande
        ellers hvis avgangskøen ikke er tom
        Ta ut første fly i avgangskøen og la det få ta av
        ellers
        Flyplassen er tom for fly

        Skriv til slutt ut resultater som gj.snittlig ventetid etc.
        */


        System.out.println("Velkommen til Rakkestad Rullebane, tax-free butikken er dessverre stengt.");
        System.out.println();

        // Les data/parameterverdier for simuleringen fra bruker
        Scanner userInput = new Scanner(System.in);
        System.out.print("Hvor mange tidsenheter skal simuleringen gå?  :  ");
        int antallTidsEnheter = userInput.nextInt();

        System.out.print("Forventet antall ankomster pr. tidsenhet ?    :  ");
        double forventetAntallAnkomst = userInput.nextDouble();

        System.out.print("Forventet antall avganger pr. tidsenhet ?     :  ");
        double forventetAntallAvgang = userInput.nextDouble();


        // Initier begge køene til å være tomme

        Queue<Fly> avgang = new LinkedList<>();
        Queue<Fly> landinger = new LinkedList<>();

        // behandler køen og flyplassen
        behandleQueue(landinger, avgang, antallTidsEnheter, forventetAntallAnkomst, forventetAntallAvgang);

        utskrift(antallTidsEnheter, landinger, avgang, forventetAntallAnkomst, forventetAntallAvgang);

    }

    public static  void utskrift(float antallTidsEnheter, Queue<Fly> landinger, Queue<Fly> avgang, double fotventetAnkomst, double forventetAvgang) {

        GJENNOMSNITT_VENTETID_LANDING = ((double)TOTAL_VENTETID_LANDING / (double)ANTALL_FLY_LANDA);
        GJENNOMSNITT_VENTETID_AVGANG = ((double)TOTAL_VENTETID_AVGANG / (double)ANTALL_FLY_TATT_AV);

        GJSNITT_LENGDE_AV_AVGANG = ((double) TOTAL_LENGDE_AV_AVGANG / (double) antallTidsEnheter);
        GJSNITT_LENGDE_AV_LANDING = ((double) TOTAL_LENGDE_AV_LANDING / (double) antallTidsEnheter);

        System.out.println();
        System.out.println("Simulering ferdig etter         :" + antallTidsEnheter + " tidsenheter.");
        System.out.println("Forventet ankomst        :      :" + fotventetAnkomst);
        System.out.println("Forventet landing        :      :" + forventetAvgang);
        System.out.println("Antall fly som ble behandler    :" + ANTALL_FLY_BEHANDLET);
        System.out.println("Antall fly som ble avvist       :" + ANTALL_FLY_AVVIST);
        System.out.println("Antall fly som tok av           :" + ANTALL_FLY_TATT_AV);
        System.out.println("Antall fly som landet           :" + ANTALL_FLY_LANDA);
        System.out.println("Antall fly klare for å lande    :" + landinger.size());
        System.out.println("Antall fly klare for å ta av    :" + avgang.size());
        System.out.println("Total ventetid landing:         :" + TOTAL_VENTETID_LANDING);
        System.out.println("Total ventetid avgang:          :" + TOTAL_VENTETID_AVGANG);
        System.out.println("Gj.snitt ventetid landing:      :" + GJENNOMSNITT_VENTETID_LANDING);
        System.out.println("Gj.snitt ventetid avgang :      :" + GJENNOMSNITT_VENTETID_AVGANG);
        System.out.println("Gj.snitt lengde landing  :      :" + GJSNITT_LENGDE_AV_LANDING);
        System.out.println("Gj.snitt lengde avgang   :      :" + GJSNITT_LENGDE_AV_AVGANG);
    }

    public static void behandleQueue(Queue<Fly> landing, Queue<Fly> avgang, int tidsenhet, double forventetAnkomst, double forventetAvgang) {
        int FLY_ID = 0;

        // For hver tidssteg i simuleringen
        for (int i = 1; i <= tidsenhet; i++) {

            System.out.println(i + ": ");

            // Trekk et tilfeldig antall nye fly som kommer for å lande
            int antallNyeFlyForLanding = getPoissonRandom(forventetAnkomst);
            TOTAL_LENGDE_AV_LANDING += antallNyeFlyForLanding;

            // For hvert nytt fly som kommer for å lande
            for (int j = 0; j < antallNyeFlyForLanding; j++) {

                Fly nyttFlySomKanLande = new Fly(FLY_ID, i);
                ANTALL_FLY_BEHANDLET++;

                // Hvis landingskøen er full, Avvis det nye flyet (henvis til annen flyplass)
                if (landing.size() >= MAKS_ANTLL) {
                    System.out.println("    Fly " + nyttFlySomKanLande.getId() + " avvist, for mange i kø");
                    ANTALL_FLY_AVVIST++;
                }
                // ELLERS, Sett det nye flyet sist i landingskøen
                else {
                    landing.add(nyttFlySomKanLande);
                    System.out.println("    Fly " + nyttFlySomKanLande.getId() + " klar for landing");
                    ANTALL_FLY_LANDA++;
                }
                FLY_ID++;
            }


            // Trekk et tilfeldig antall nye fly som kommer for å ta av
            int antallNyeFlyForTaAv = getPoissonRandom(forventetAvgang);
            TOTAL_LENGDE_AV_AVGANG += antallNyeFlyForTaAv;

            // For hvert nytt fly som kommer for å ta av
            for (int j = 0; j < antallNyeFlyForTaAv; j++) {

                Fly nyttFlySomKanTaAv = new Fly(FLY_ID, i);

                ANTALL_FLY_BEHANDLET++;

                // Hvis avgangskøen er full ,Avvis det nye flyet (avgang må prøves senere)
                if (avgang.size() >= MAKS_ANTLL) {
                    System.out.println("    Fly " + nyttFlySomKanTaAv.getId() + " avvist, for mange i kø");
                    ANTALL_FLY_AVVIST++;
                }
                // ellers, Sett det nye flyet sist i avgangskøen
                else {
                    avgang.add(nyttFlySomKanTaAv);
                    System.out.println("    Fly " + nyttFlySomKanTaAv.getId() + " klar for avgang");
                    ANTALL_FLY_TATT_AV++;
                }

                FLY_ID++;

            }

            //  Hvis landingskøen ikke er tom, Ta ut første fly i landingskøen og la det få lande
            if (!landing.isEmpty()) {
                Fly flySomKanLande = landing.remove();

                int ventetid = i - flySomKanLande.getBehandlingsTid();
                System.out.println("    Fly " + flySomKanLande.getId() + " landet, ventetid " + ventetid);
                TOTAL_VENTETID_LANDING += ventetid;
            }

            // ellers hvis avgangskøen ikke er tom, Ta ut første fly i avgangskøen og la det få ta av
            else if (!avgang.isEmpty()) {
                Fly flySomKanTaAv = avgang.remove();
                int ventetid = i - flySomKanTaAv.getBehandlingsTid();
                System.out.println("    Fly " + flySomKanTaAv.getId() + " tok av, ventetid: " + ventetid);
                TOTAL_VENTETID_AVGANG += ventetid;
            }

            // ellers, Flyplassen er tom for fly
            else {
                System.out.println("    Flyplassen er tom");
            }
        }
    }

    private static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;

        while (p > L){
            p = p * r.nextDouble();
            k++;
        }
        return k - 1;
    }
}
