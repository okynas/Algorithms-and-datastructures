public class HashLinear{
  private int hashLengde; // Hashlengden
  private String hashTabell[]; // Hashtabellen
  private int n; // Antall lagrede tekststrenger
  
  // Konstruktør
  public HashLinear(int lengde){
    hashLengde = lengde;
    hashTabell = new String[lengde];
    n = 0;
  }
 // Hashfunksjon
int hash(String S) {
  int h = Math.abs(S.hashCode());
  return h % hashLengde;
}
 // Innsetting av tekststreng med lineær probing
void insert(String S){
  int h = hash(S);
  int neste = h;

  while (hashTabell[neste] != null){
    neste++;
    if (neste >= hashLengde)
      neste = 0;

    if (neste == h){
      System.err.println("Hashtabell full, avbryter");
      System.exit(0);
    }
  }

  hashTabell[neste] = S;
  n++;
 }

  // Finner probingavstanden for en tekststreng i tabellen
  int distance(int i) {

    if (hashTabell[i] == null || i < 0 || i > hashlengde) {
      return 0;
    }
    int h = hash(hashTabell[i]);

    if (i>=h) {
      return i-h; // ikke wrap around
    }
    else {
      return (hashLengde - h) + 1;
    }
    
  }

 // Finner største probingavstand for alle strenger i tabellen
  int maxDistance(){
    // Skal programmeres i oppgave 4 d)
    int maxDist = 0;
    for (int i = 0; i < hashlengde; i++) {
      int dist = distance(i);
      if (dist > maxDist) {
        maxDist = dist;
      }
    }
    return maxDist;
  }
}