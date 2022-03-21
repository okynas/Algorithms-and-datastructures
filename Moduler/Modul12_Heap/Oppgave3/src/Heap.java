public class Heap {
    /**
     * Vi skal betrakte trær som er "heap-ordnede", d.v.s. at enhver node har en verdi
     * som er mindre eller lik verdien i dens eventuelle barn. Trærne behøver derimot
     * ikke oppfylle de øvrige kravene til en heap, f.eks. behøver de ikke være balanserte.
     * Et eksempel på et slikt heap-ordnet tre er dette:
     *
     * Denne metoden har som parameter en referanse til roten i et tre der begge
     * subtrærne til roten er heap-ordnede (hvis de ikke er tomme), mens verdien
     * i selve roten kan være slik at den bryter mot heap-ordningen.
     * Metoden skal bytte om på verdiene i treet slik at hele treet blir heap-ordnet.
     * Den skal ikke være rekursiv og skal helst være så effektiv som mulig.
     * Merk at metoden altså ikke skal forandre på noen av referansene i treet,
     * men bare bytte rundt på verdier som står i nodene.
     *
     * @param rot, roten til gjeldende tre
     */
    public static void reparer(Node rot) {
        Node denne, neste;
        boolean finished = false;

        denne = rot;
        finished = (denne == null);

        while (!finished) {
            // finn barnet til denne noden som har minst verdi.
            if (denne.v == null) {
                neste = denne.h;
            } else if (denne.h == null) {
                neste = denne.v;
            } else if (denne.v.verdi < denne.h.verdi) {
                neste = denne.v;
            } else {
                neste = denne.h;
            }

            // sjekker om vi er i bladnode, da vi er ferdig med koden.
            if (neste == null || denne.verdi <= neste.verdi) {
                finished = true;
            }
            else {
                int temp = denne.verdi;
                denne.verdi = neste.verdi;
                neste.verdi = temp;

                denne = neste;
            }
        }

    }

    /**
     * Metoden har som parameter en referanse til roten i et tre der nodene har helt vilkårlige
     * verdier, uten noen innbyrdes ordning. Metoden skal bytte rundt på disse verdiene slik at
     * treet blir et heap-ordnet tre med de samme verdiene. Den skal være rekursiv og skal
     * benytte metoden reparer fra oppgave a).
     *
     * @param rot, roten til gjeldende tre
     */
    public static void lag_heap_ordning(Node rot) {

        // sjekker om roten er gyldig.
        if (rot != null){
            // rekursivt kall på sin venstre node
            lag_heap_ordning(rot.v);
            // rekursivt kall på sin høyre node
            lag_heap_ordning(rot.h);

            // reparerer roten. Siden rekursivt, vil ikke denne bli kalt før helt på slutten
            // altså før siste node i treet.
            reparer(rot);
        }

    }

    /**
     * Skriv en metode som returnerer antall ganger heltallsverdien verdi forekommer i et heap-ordnet
     * tre som beskrevet ovenfor. Parameteren rot er en referanse til roten i treet. Du kan selv velge
     * om metoden skal være rekursiv eller iterativ. Legg vekt på å lage metoden så effektiv som mulig.
     *
     * @param rot, roten til gjeldende tre
     * @param verdi, verdien som skal sjekke hvor mange forekommer av denne det er.
     * @return
     */
    public static  int tell(Node rot, int verdi) {

        int tempCount = 0;

        if (rot != null && rot.verdi == verdi) {
            tempCount++;
        }

        return tempCount + tell(rot.v, verdi) + tell(rot.h, verdi);
    }
}
