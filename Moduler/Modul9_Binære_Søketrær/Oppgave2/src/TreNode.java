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
    private int sum; 		      // Brukes bare i oppgave c)
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
}
