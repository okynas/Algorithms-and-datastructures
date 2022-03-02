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

    /**
     * Skriv en metode for å søke i et flerveis søketre av orden 3
     *
     * Metoden skal returnere true hvis verdien x finnes i søketreet med rot i parameteren
     * rot, og false ellers. Metoden kan enten være rekursiv eller iterativ, og skal helst
     * være så effektiv som mulig.
     *
     * @param rot roten i noden, hvor det skal sjekkes fra
     * @param x, verdien som skal søkes eller letes etter
     * @return boolean verdi utifra om funnet eller ikke.
     */
    public boolean finnes(treNode rot, int x) {
        if (rot == null) {
            return false;
        }

        if (x < rot.v1) {
            return finnes(rot.venstre, x);
        }

        if (rot.v1 == x) {
            return true;
        }

        if (rot.antallVerdier == 2) {
            if (x > rot.v2) {
                return finnes(rot.hoyre, x);
            } else if (x == rot.v2) {
                return true;
            }
        }

        return finnes(rot.midt, x);
        
    }
}
