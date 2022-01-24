import java.util.*;

public class Main {

    public static final int MAKS_ANTLL = 10;
    public static int ANTALL_FLY_AVVIST = 0;
    public static int ANTALL_FLY_BEHANDLET = 0;
    public static int ANTALL_FLY_LANDA = 0;
    public static int ANTALL_FLY_TATT_AV = 0;
    public static int ANTALL_FLY_KLARE_FOR_LANDING = 0;
    public static int ANTALL_FLY_KLARE_FOR_TA_AV = 0;

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
        behandleKø(landinger, avgang, antallTidsEnheter, forventetAntallAnkomst, forventetAntallAvgang);


    }

    public static void behandleKø(Queue<Fly> landing, Queue<Fly> avgang, int tidsenhet, double forventetAnkomst, double forventetAvgang) {
        int FLY_ID = 0;

        // For hver tidssteg i simuleringen
        for (int i = 1; i <= tidsenhet; i++) {

            System.out.println(i + ": ");

            // Trekk et tilfeldig antall nye fly som kommer for å lande
            int antallNyeFlyForLanding = getPoissonRandom(forventetAnkomst);

            // For hvert nytt fly som kommer for å lande
            for (int j = 0; j < antallNyeFlyForLanding; j++) {
                //int ventetid = 0;

                Fly nyttFlySomKanLande = new Fly(FLY_ID++);

                //System.out.println("    Fly " + nyttFlySomKanLande.getId() + " er klar for landing.");

                // Hvis landingskøen er full, Avvis det nye flyet (henvis til annen flyplass)
                if (landing.size() > MAKS_ANTLL) {
                    ANTALL_FLY_AVVIST++;
                }
                // ELLERS, Sett det nye flyet sist i landingskøen
                else {
                    landing.add(nyttFlySomKanLande);
                    //System.out.println("    Fly " + nyttFlySomKanLande.getId() + " landet, ventetid " + ventetid + " enheter.");
                }
            }


            // Trekk et tilfeldig antall nye fly som kommer for å ta av
            int antallNyeFlyForTaAv = getPoissonRandom(forventetAvgang);

            // For hvert nytt fly som kommer for å ta av
            for (int j = 0; j < antallNyeFlyForTaAv; j++) {
                //int ventetid = 0;

                Fly nyttFlySomKanTaAv = new Fly(FLY_ID++);

                //System.out.println("    Fly " + nyttFlySomKanTaAv.getId() + " er klar for avgang.");

                // Hvis avgangskøen er full ,Avvis det nye flyet (avgang må prøves senere)
                if (avgang.size() < MAKS_ANTLL) {
                    ANTALL_FLY_AVVIST++;
                }
                // ellers, Sett det nye flyet sist i avgangskøen
                else {
                    avgang.add(nyttFlySomKanTaAv);
                    // System.out.println("    Fly " + nyttFlySomKanTaAv.getId() + " tatt av, ventetid " + ventetid + " enheter.");
                }

            }

            //  Hvis landingskøen ikke er tom, Ta ut første fly i landingskøen og la det få lande
            if (!landing.isEmpty()) {
                Fly flySomKanLande = landing.remove();
                System.out.println("    Fly " + flySomKanLande.getId() + " landet.");
            }

            // ellers hvis avgangskøen ikke er tom, Ta ut første fly i avgangskøen og la det få ta av
            else if (!avgang.isEmpty()) {
                Fly flySomKanTaAv = avgang.remove();
                System.out.println("    Fly " + flySomKanTaAv.getId() + " tok av.");
            }

            // ellers, Flyplassen er tom for fly
            else {
                System.out.println("    Flyplassen er tom");
            }

        }

        System.out.println();
        System.out.println("Simulering ferdig etter         " + tidsenhet + " tidsenheter.");
        System.out.println("Antall fly som ble behandler    " + FLY_ID);

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
