# 7.6: Øvingsoppgaver

### Oppgaver
- [x] Oppgave 1
- [x] Oppgave 2
  - [x] Oppgave a
  - [x] Oppgave b
  - [x] Oppgave c
  - [x] Oppgave d
- [ ] Oppgave 3
- [x] Oppgave 4
- [x] Oppgave 5
- [x] Oppgave 6
- [x] Oppgave 7
## Oppgave 1
Skriv en rekursiv versjon av binærsøk (Lenker til en ekstern side.).

## Oppgave 2
I et ternært søk deler vi (det gjenværende segmentet av) arrayen opp i tre (omtrent) like store deler i hvert steg. Algoritmen finner ut i hvilken av de tre delene det søkte elementet ligger (evt. finner vi elementet i et av de to "delepunktene") og søker videre i bare denne delen.

- Programmer en iterativ versjon av ternært søk i en array med heltall.
- Programmer en rekursiv versjon av ternært søk i en array med heltall.
- Lag et testprogram (Lenker til en ekstern side.) som sammenligner effektiviteten av ternært søk og binærsøk, for store verdier av n.
- Ternært søk er ikke mer effektivt enn binærsøk, selv om den ternære algoritmen "kvitter seg med" 2/3 av de gjenværende elementene i hvert steg. Hvorfor?


### SVAR
#### 2D
Ternært søk er ikke mer effektivt enn binærsøk, selv om den ternære algoritmen "kvitter seg med" 2/3 av de gjenværende elementene i hvert steg. Hvorfor?

Det er ingenting å tjene på tærtiært iforhold til binærsøk.
Det er ekstra arbeid og testing som må gjøres for hver oppdeling gjør at total arbeidsmenge blir den samme
selv om antall rekursive kall er mindre for ternært søk.


## Oppgave 3
For å øke forståelsen for sorteringsalgoritmene, skal følgende array "sorteres for hånd" med ulike algoritmer:

    { 8, 1, 4, 1, 5, 9, 2, 6, 5 }

Vis hvordan arrayen forandres etter hvert "hovedsteg" (du bestemmer selv hva "hovedsteg" skal bety) i følgende algoritmer:

- [x] Innstikksortering
- [x] Shell sort med "gaps" 5, 3 og 1
- [ ] Flettesortering / Mergesort
- [ ] Quicksort, med elementet i midten som partisjoneringselement

## Oppgave 4
Anta at alle elementene i en array av lengde n er like. Hva er da kjøretiden til følgende sorteringsalgoritmer:

- Innstikksortering = O(n)
- Shell sort = O(n log n)
- Flettesortering = O(n log n) uansett hvordan verdiene i vektoren/arrayen er.
- Quicksort = O(n^2) fordi ene delmengden alltid blir tom når elementene er like.

## Oppgave 5
Anta at alle elementene i en array av lengde n allerede er sortert. Hva er da kjøretiden til følgende sorteringsalgoritmer:

- Innstikksortering = O(n)
- Shell sort = O(n log n)
- Flettesortering = O(n log n)
- Quicksort =>
  1. første element = O(n^2)
  2. n/2 element = O(n log n)

## Oppgave 6
Anta at alle elementene i en array av lengde n allerede er sortert, men i omvendt rekkefølge. Hva er da kjøretiden til følgende sorteringsalgoritmer:

- Innstikksortering = O(n^2), indre løkka må nå kjøres
- Shell sort = O(n log n)
- Flettesortering = O(n log n)
- Quicksort => 
  1. første element = O(n^2)
  2. n/2 element = O(n log n)

## Oppgave 7
Standard flettesortering brukes lite til sortering av arrayer, fordi det kreves en ekstra hjelpearray til å flette sammen de to sorterte arraybitene. Derimot er flettesortering glimrende til å sortere lenkede lister, fordi flettingen kan gjøres ved bare å manipulere neste-pekerne i listen uten at det trengs noe ekstra lagerplass.

Skriv en metode som flettesorterer en enkel lenket liste der nodene bare inneholder et heltall og en peker/referanse til neste node i listen, etter følgende algoritme:

1. Del listen i to omtrent like store deler.
2. Flette-sorter første halvdel.
3. Flette-sorter andre halvdel.
.4 Flett de to halvdelene sammen til en lenket liste.

Oppdelingen av listen i to like store deler er en O(n) operasjon, som kan gjøres enkelt slik:

1. Sett to referanser, p1 og p2, til å referere starten av listen.
2. Så lenge p1 != null:
- Flytt p1 "to hakk" fremover i listen.
- 2.2 Flytt p2 "et hakk" fremover i listen,
3. p2 er nå en node omtrent midt i listen.
   Skriv en egen metode som gjør denne oppdelingen og returnerer to lenkede lister som svarer til hver sin halvpart av den opprinnelige.

Selve flettingen består bare i å sette inn noder fra den ene sorterte del-listen på riktig plass i den andre, på en tilsvarende måte som fletting av to vektorer. Skriv en egen metode for flettingen også.

Argumentér for at flettesortering av en lenket liste er O(n logn).
