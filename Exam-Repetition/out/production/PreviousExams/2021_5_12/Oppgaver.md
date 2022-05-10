## Oppgave 1

5 2 4 9 6 1 4 3

### a)
Vis hvordan tabellen ser ut etter første iterasjon av den ytre løkken i innstikksortering.

### b)
Vis hvordan tabellen ser ut etter første iterasjon av den ytre løkken i utplukksortering.

### c)
Vis hvordan tabellen ser ut etter første iterasjon av den ytre løkken i bubble sort.

### d)
Tabellen skal sorteres med Shell sort, med gap-sekvens 4, 2, 1. Vis hvordan tabellen ser ut
etter første runde av Shell sort, med gap lik 4.

### e)
Tabellen skal sorteres med quicksort, med det første elementet i alle delarrayer som
partisjoneringselement (pivotelement). Vis hvordan tabellen ser ut etter den første
partisjoneringen i quicksort.

### f)
Vis hvordan tabellen ser ut etter det første av de to hovedstegene i en in-house heapsort, når
hele tabellen er gjort om til en max-heap.

Et anagram er et ord som er blitt satt sammen ved å stokke rundt på bokstavene i et annet ord eller
uttrykk. Eksempler:
jus – sju
gitar – artig
melk – klem
rådhus – husråd
sykebil – libyske
reparasjon – japanroser

Du skal lage en Java-metode som sjekker om en tekststreng kan være et anagram som er satt
sammen av bokstavene i en annen tekststreng. Til å hjelpe deg med dette kan du bruke følgende
metode som sorterer innholdet i en tekststreng alfabetisk:

String sortString(String inputString){
char tempArray[] = inputString.toCharArray();
 Arrays.sort(tempArray);
 return new String(tempArray);
}

### g)

Programmér metoden:
boolean erAnagram(String S1, String S2)
som returnerer true hvis strengen S2 er et anagram laget av tegnene i strengen S1, dvs. at
tegnene i S2 er en permutasjon av tegnene i S1.
Vi kan anta at begge de to strengene bare består av små (lower-case) bokstaver. Lag
metoden så kort og kompakt som mulig, gjerne med bare én kodelinje.

## Løsning:

### a)
5 2 4 9 6 1 4 3 -> 2 5 4 9 6 1 4 3

### b)
5 2 4 9 6 1 4 3 -> 1 2 4 9 6 5 4 3

### c)
5 2 4 9 6 1 4 3 -> 1 5 2 4 9 6 4 3

### d)
5 2 4 9 6 1 4 3 -> 5 1 4 3 6 2 4 9

### e)
5 2 4 9 6 1 4 3 ->1 2 4 3 4 5 6 9

### f)
5 2 4 9 6 1 4 3 -> 9 6 4 3 5 1 4 2

### g)

```java
/*
* Hjelpefunksjon
*/
String sortString(String inputString) {
char tempArray[] = inputString.toCharArray();
 Arrays.sort(tempArray);
 return new String(tempArray);
}

/**
* Et anagram er et ord som er blitt satt sammen ved å stokke rundt
* på bokstavene i et annet ord eller uttrykk.
*
* eks: jus-sju, rådhus-husråd, gitar-artig, sykebil-libyske, melk-klem, reparasjon-japanroser
*
* @return true hvis strengen S2 er et anagram laget av tegnene i strengen S1, dvs. at
* @param s1 string
* @param s2, string, er en permutasjon av tegnene i S1.
*/
public boolean erAnagram(String S1, String S2) {
  String S1Sortert = sortString(S1);
  String S2Sortert = sortString(S2);

  for (int i = 0; i < S1Sortert.length(); i++) {
    if (S1Sortert[i] != S2Sortert[i]) {
      return false;
    }
  }

  return true;

}

// kan også progges slik:
public boolean erAnagram(String S1, String S2) {
  return sortString(S1).compareTo(sortString(S2)) == 0;
}
```


## Oppgave 2

### a) og b)
```java
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

```

### c)
Anta at det er m noder i en liste med fornavn. Hva er arbeidsmengden, uttrykt med O notasjon, til metoden settInnFornavn fra deloppgave a)? Begrunn svaret ditt.

### d)
Anta nå at det er n trenoder i det binære søketreet, der n er et stort tall. Anta også at ingen av
de lenkede listene har flere enn m listenoder, og at m er et svært lite tall i forhold til n.
Det betyr at du kan betrakte antall fornavn som maksimalt brukes for et etternavn (m), som
en liten konstant i forhold til det totale antallet etternavn (n) i hele treet.
Hva er da arbeidsmengden til metoden settInnPersonnavn fra deloppgave b)? Begrunn
svaret ditt.


## Løsning:
### c)
settinnfornavn har en while løkke, som kan gå verste fall m ganger. Det er fordi den m å igjennom hele liste (det er liste oppgitt i oppgaven). Hvis den går igjennom alle nodene uten å finne verdien, vil notasjonen være O(m)

### d)

While løkke som går log m ganger (binært derfor log_2(n) ). Hvis balansert. hvis ikke er det n ganger (degenerert til lenket liste.).
Innsetting av etternavn er derfor O(log n).
Innsetting i lenkede liste med fornavn, etter man har funnet etternavn er O(1), fordi maks antall noder i lista er konstant.

totalt: O(log n) + O(1) = O(log n)

## Oppgave 3: Hashing med lineær probing 

int hash(int value) { 
  return value % h; 
}

h = 13

13 14 15 3 1 21 9 8 25 12

0:
1:
2:
3:
4:
5:
6:
7:
8:
9:
10:
11:
12:

Ved vanlig lineær probing: ser den slik ut:
0: 13
1: 14
2: 15
3: 3
4: 1
5: 12
6:
7:
8: 21
9: 9
10: 8
11:
12: 25

### a) LCFS

0: 25
1: 13
2: 1 
3: 14
4: 15
5: 3
6:
7:
8: 8
9: 21
10: 9
11:
12: 12

### b) RH


0: 12 
1: 13 
2: 1  
3: 14
4: 15
5: 3
6:
7:
8: 21 
9: 8
10: 9
11:
12: 25 

### c) og d)

```java
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
```

### e)
Hvis load factor = 0.5, vil arbeidsmengden være O(n). Dette er fordi for-løkken går igjenno like mange ganger som er ca 2n. Dist metoden kalles O(1) gang for hvert gjennomløp.

### f)
Minste verdien vil være Robin hood. Det er fordi denne prøver en vei hvor den sjekker korteste avstand mellom to indekser, og sammenligner disse for hver gang helt til et element kan settes inn.

## Oppgave 4 - Grafer (25%)
Data:
A:0 B:1 C:2 D:3 E:4

### a)

5
0 a  2  1 3  2 1
1 b  4  0 3  2 7  3 5  4 1
2 c  3  0 1  1 7  3 2
3 d  3  1 5  2 2  4 7
4 e  2  1 1  3 7

### b)

  A B C D E
A 0 3 1 * *
B 3 0 7 5 1
C 1 7 0 2 *
D * 5 2 0 7
E * 1 * 7 0

### c)
DFS fra E, alltid skje i i alfabetisk stigende rekkefølge.

E B A C D

### d)
BFS fra E, alltid skje i i alfabetisk stigende rekkefølge.

E B D A C

### e)

  A B C D E
A 0 3 1 3 4
B 3 0 4 5 1
C 1 4 0 2 5
D 3 5 2 0 6
E 4 1 5 6 0

### f)

| Steg | A | B | C | D | E | Funnet |
|------|---|---|---|---|---|--------|
| 0    | * | * | * | * | 0 |        |
| 1    | * | 1 | * | 7 | 0 | E      |
| 2    | 4 | 1 | 8 | 6 | 0 | EB     |
| 3    | 4 | 1 | 5 | 6 | 0 | EBA    |
| 4    | 4 | 1 | 5 | 6 | 0 | EBAC   |
| 5    | 4 | 1 | 5 | 6 | 0 | EBACD  |
