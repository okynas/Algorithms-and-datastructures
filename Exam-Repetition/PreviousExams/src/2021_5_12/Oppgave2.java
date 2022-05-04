public class PersonnavnRegister{

// Node i de usorterte listene med fornavn
  class ListeNode {
    String fornavn; // Fornavnet
    int antall; // Antall personer med dette navnet
    ListeNode neste; // Neste node i listen
    // Konstruktør for ListeNode
    public ListeNode(String f){
      fornavn = f;
      antall = 1;
      neste = null;
    }
  }
// Node i søketreet med etternavn
  class TreNode {
    String etternavn; // Søketreet er sortert på etternavn
    ListeNode første; // Starten på listen med fornavn
    TreNode venstre; // Peker til venstre barn i treet
    TreNode høyre; // Peker til høyre barn i treet
    // Konstruktør for TreNode
    public TreNode(String f, String e){
      etternavn = e;
      venstre = høyre = null;
      første = new ListeNode(f);
    }
    /*
    * Metoden skal sette inn fornavnet
    * gitt i parameteren f korrekt i den usorterte listen med fornavn som ligger i søketrenoden.
    * Hvis fornavnet finnes fra før i listen skal det ikke settes inn en ny node, men antallet
    * forekomster av dette fornavnet skal i stedet økes med 1.
    */
    void settInnFornavn(String f){
      ListeNode denne = første;
      boolean ferdig = false;

      while (!ferdig) {
        int res = denne.compareTo(denne.fornavn);
        if (res == 0) {
          denne.antall++;
          ferdig = true;
        } else if (denne.neste == null) {
          denne.neste = new ListeNode(f);
          ferdig = true;
        } else {
          denne = denne.neste;
        }
      }

    }

  }

  TreNode rot = null; // Roten i hele søketreet

  /**
  * Metoden skal sette inn personnavnet gitt i
  * parameterene f og e korrekt i det binære søketreet. Hvis etternavnet e finnes fra før i
  * søketreet, skal det ikke settes inn en ny trenode, men fornavnet gitt i parameteren f skal
  * registreres i listen med fornavn som ligger i trenoden med etternavn lik e.
  * Metoden settInnPersonnavn skal ikke være rekursiv og så effektiv som mulig. Den skal
  * bruke metoden settInnFornavn fra deloppgave a). Innsettingen av etternavn skal gjøres
  * på sam
  *
  * @param f, fornavn som skal sjekkes
  * @param e, etternavn som skal sjekeks
  */
  void settInnPersonnavn(String f, String e) {
    if (root == null) {
      root = new TreNode(f, e);
      return;
    }

    TreNode denne = root;
    boolean finished = false;

    whille(!finished) {
      int res = e.compareTo(denne.etternavn);

      if (res == 0) {
        denne.settInnFornavn(f);
        return true;
      } else if (res < 0) {
          if (denne.venstre == null) {
            denne.venstre = new TreNode(f,e);
            finished = true;
          } else {
            denne = denne.venstre;
          }
      } else if (res > 0) {
          if (denne.høyre == null) {
            denne.høyre = new TreNode(f, e);
            finished = true;
          } else {
            denne = denne.høyre;
          }
      }
    }
  }
}
