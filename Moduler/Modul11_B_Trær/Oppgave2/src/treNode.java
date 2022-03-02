public class treNode {
    int antallVerdier; // Antall verdier i noden, enten 1 eller 2
    int v1, v2;        // Verdiene, v1 < v2 hvis antallVerdier == 2
    treNode venstre, midt, hoyre; // Pekere til barn
    int hoyde; // Høyden av subtreet noden er rot i, til deloppgave c)

    /**
     * Skriv en metode som går gjennom et helt søketre av orden 3 og skriver ut verdiene i
     * hver node, i sortert rekkefølge:
     *
     * Parameteren rot er en peker/referanse til roten i treet som skal skrives ut. Metoden
     * skal være rekursiv. Utskriften skal skrives til skjerm/konsoll, på én linje med
     * mellomrom mellom hver verdi.
     *
     * @param rot, som programmet begynner på, og fra denne nodene skal skrives ut sortert.
     */
    public void skrivSortert(treNode rot) {

        if (rot == null) {
            return;
        }

        skrivSortert(rot.venstre);

        System.out.println(rot.v1 + " ");
        skrivSortert(rot.midt);

        if (rot.antallVerdier == 2) {
            System.out.println(rot.v2 + " ");
            skrivSortert(rot.hoyre);
        }

    }
}
