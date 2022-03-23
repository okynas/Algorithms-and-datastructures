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

    /**
     * Skriv en metode som sjekker om et flerveis søketre av orden 3 også er et B-tre:
     *
     * Metoden skal returnere true hvis hele treet med rot i parameteren rot tilfredsstiller
     * kravet som stilles til et B-tre om at:
     *
     * 1. Alle bladnodene i et B-tre skal ligge på samme nivå.
     * 2. I alle indre noder i B-treet skal antall barn være nøyaktig én mer enn antall verdier.
     *
     * Metoden erBtre skal være rekursiv. Variabelen hoyde som ligger i hver node, kan
     * brukes i besvarelsen av denne deloppgaven.
     *
     * @param rot, roten som skal sjekkes om den er B-Tre.
     * @return bolsk verdi, utifra om den er B-Tre eller ikke.
     */
    public boolean erBtre(treNode rot) {

        if (rot == null) {
            return true;
        }

        // 1. Alle bladnodene i treet ligger på samme nivå
        if (rot.antallVerdier == 1 && rot.venstre == null && rot.midt == null) {
            rot.hoyde = 0;
            return true;
        }

        if (rot.antallVerdier == 2 && rot.venstre == null && rot.midt == null && rot.hoyre == null) {
            rot.hoyde = 0;
            return true;
        }

        // ikke et bladnode, men mangler ett av barna?
        if (rot.antallVerdier == 1 && (rot.venstre == null || rot.midt == null)) {
            return false;
        }

        if (rot.antallVerdier == 2 && (rot.venstre == null || rot.midt == null || rot.hoyre == null )) {
            return false;
        }

        // 2. i alle indre noder i B-Treet skal antall barn være nøyaktig 1 mer enn antall verdier
        if (!erBtre(rot.venstre) || !erBtre(rot.midt) || !erBtre(rot.hoyre)) {
            return false;
        }

        // alle suntrær er B-Trær. Sjekk om treet i denne roten er et B-Tre.
        if (rot.antallVerdier == 1 && rot.venstre == rot.midt) {
            rot.hoyde = rot.venstre.hoyde + 1;
            return true;
        }

        if (rot.antallVerdier == 2 && rot.venstre.hoyde == rot.midt.hoyde && rot.midt.hoyde == rot.hoyre.hoyde) {
            rot.hoyde = rot.venstre.hoyde + 1;
            return true;
        }
        return false;
    }
}
