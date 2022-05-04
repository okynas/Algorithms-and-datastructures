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

finnes i oppgave1.java


