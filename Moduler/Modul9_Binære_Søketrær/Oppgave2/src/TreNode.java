
/**
 * Oppgave 2
 * Dette er en tidligere eksamensoppgave.
 *
 * I denne oppgaven skal du programmere noen metoder som opererer på binære søketrær. Dataene som lagres i hver node i treet er et heltall og en enkelt bokstav. Nodene har som vanlig referanser til venstre og høyre barn. I tillegg har hver node en referanse til foreldernoden (forgjengeren) i treet. Disse referansene til foreldernoder skal kun brukes i oppgave d). Nodene har også en heltallsvariabel sum som bare skal brukes i oppgave c).
 *
 * Følgende klasse skal brukes til å lagre hver node i søketreet:
 *
 *    class tre_node
 *    {
 *       public tre_node() ...   // Konstruktør, skal ikke programmeres
 *       int verdi;              // Heltallsverdi som lagres i hver node
 *       char bokstav;	      // Bokstav/tegn som lagres i hver node
 *       int sum; 		      // Brukes bare i oppgave c)
 *       tre_node v, h;	      // Venstre og høyre barn
 *       tre_node forelder;      // Brukes bare i oppgave d)
 *    }
 *
 * Hvis venstre og/eller høyre subtre til en node er tomt, vil referansene v og/eller h i noden være lik null. Vi krever ikke at søketreet skal være balansert.
 *
 * Nodene i søketreet ligger ordnet/sortert på variabelen verdi i hver node, slik at alle heltallsverdier i en nodes venstre subtre er mindre eller lik verdien i noden selv (hvis venstre subtre ikke er tomt), mens alle verdier i nodens høyre subtre er større enn verdien i noden (hvis høyre subtre ikke er tomt). Det kan altså finnes flere forekomster av samme verdi i treet. Hele søketreet kan representeres med en referanse til roten i treet.
 *
 * I programkoden du skriver kan du anta at du har tilgang (f.eks. friendly access) til alle variable inne i klasseobjektene som skal brukes.
 */

public class TreNode {

    public int verdi;              // Heltallsverdi som lagres i hver node
    public char bokstav;	      // Bokstav/tegn som lagres i hver node
    public int sum; 		      // Brukes bare i oppgave c)
    public TreNode v, h;	      // Venstre og høyre barn
    public TreNode forelder;      // Brukes bare i oppgave d)

    // Konstruktør, skal ikke programmeres
    public TreNode() {

    }


    /**
     * Parameteren rot refererer her til roten i et søketre. Metoden skal skrive ut verdien av variabelen bokstav for
     * alle de nodene i treet som har en heltallsverdi (variabelen verdi) lik verdien av parameteren x.
     * For noder som ikke har verdi lik x, skal det ikke gjøres noen utskrift. Metoden du lager skal helst være så
     * effektiv som mulig, men du kan selv velge om du vil lage den rekursiv eller iterativ.
     *
     * @param rot, rot-noden i søketreet som sendes med.
     * @param x, et heltall x som er lik verdien som skal søkes etter.
     */
    public void skriv_bokstav(TreNode rot, int x) {

        if (rot != null) {
            if (x > rot.verdi) {
                skriv_bokstav(rot.v, x);
            } else {
                if (x == rot.verdi) {
                    System.out.println(rot.bokstav);
                }
                skriv_bokstav(rot.h, x);
            }
        }
    }

    /**
     * Hver av nodene i søketreet har, i tillegg til variabelen verdi som inneholder nodens nøkkelverdi, også en heltallsvariabel sum.
     * I denne oppgaven antar vi at variabelen sum i utgangspunktet er satt lik 0 (null) i alle noder. Lag en metode:
     *
     *  void sett_sum(tre_node rot)
     *
     *  som, for hver node i søketreet, setter variabelen sum lik summen av alle (nøkkel)verdiene i nodens subtrær
     *  pluss verdien (av variabelen verdi) i noden selv.
     *
     *  Parameteren rot er her til roten i søketreet. Metoden sett_sum skal være rekursiv.
     *
     * @param rot, roten i søketreet.
     */
    public void sett_sum(TreNode rot) {
        if (rot != null) {
            sett_sum(rot.v);
            sett_sum(rot.h);

            rot.sum = rot.verdi;
            if (rot.v != null) {
                rot.sum += rot.v.sum;
            }

            if (rot.h != null) {
                rot.sum += rot.h.sum;
            }
        }
    }

    /**
     * I denne oppgaven skal du lage en metode:
     *
     * 	void sett_forelder(tre_node rot)
     *
     * som, for hver node i søketreet, setter variabelen forelder til å referere til nodens forgjenger
     * (foreldernode) i treet. Du kan anta at forelder i utgangspunktet har en vilkårlig (ikke bestemt)
     * verdi i hver node. Roten i treet (representert ved parameteren rot), skal få forelder satt lik null.
     *
     * @param rot, roten i søketreet.
     */
    public void sett_forelder(TreNode rot) {
        if (rot != null) {
            sett_forelder(rot.v);
            sett_forelder(rot.h);

            if (rot.v != null) {
                rot.v.forelder = rot;
            }

            if (rot.h != null) {
                rot.h.forelder = rot;
            }

            rot.forelder = null;
        }
    }
}
