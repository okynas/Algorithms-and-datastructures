# 6.4: Øvingsoppgaver

### Oppgaver
- [x] Oppgave 1
- [ ] Oppgave 2
- [ ] Oppgave 3
- [ ] Oppgave 4
- [ ] Oppgave 5

## Oppgave 1

Skriv om programmet for å traversere en labyrint (Lenker til en ekstern side.), slik at naboruter nå oppsøkes i rekkefølgen:

    venstre, opp, høyre, ned

Kjør de to versjonene av programmet og sammenlign veiene som finnes.

Skriv om programmet for å traversere en labyrint (Lenker til en ekstern side.), slik at programmet i stedet for å markere rutene på veien gjennom labyrinten med en stjerne ('*'), setter inn et tegn som viser i hvilken retning vi går videre fra hver rute. De fire tegnene som skal brukes er:

    >   høyre
    v   ned
    <   venstre
    ^   opp

Her er et eksempel (Lenker til en ekstern side.) for en 30x30 labyrint.

Skriv om programmet for å traversere en labyrint (Lenker til en ekstern side.), slik at programmet i stedet for å skrive ut hele labyrinten, skriver ut alle stegene (dvs. alle rutene som vi er innom) på veien fra rute (0,0) til (n-1,n-1) (på samme måte som for oblig. 2, springerproblemet).

## Oppgave 2

Denne oppgaven er litt "tricky":

Programmer en metode som fyller en array av lengde n med en tilfeldig permutasjon av heltallene fra 1 til n. Alle permutasjoner skal være like sannsynlige, og random-funksjonen i Java skal kalles nøyaktig n - 1 ganger. En slik funksjon kan f.eks. brukes til å "stokke kortene" i spillprogrammer.
## Oppgave 3

I dronningproblemet (Lenker til en ekstern side.) er det slik at vi alltid kan lage syv nye løsninger ut i fra en bestemt løsning, ved å:

    Rotére brettet 90, 180 og 270 grader.

    Speile løsningen om hhv. vertikal og horisontal midtlinje på brettet.

    Speile løsningen om hver av de to hoveddiagonalene på brettet.

Det kan hende at noen av disse roterte/speilede løningene er like hverandre eller "originalen".

Anta at en permutasjon P av tallene 1,2,..., n representerer en løsning av dronningproblemet for et n x n sjakkbrett. Vi ønsker å fylle syv arrayer P1, P2,... P7 med permutasjoner som tilsvarer de syv speilingene og rotasjonene som er nevnt ovenfor. Hvis vi setter

    N = n + 1,

kan de syv arrayene defineres slik:

P1((P(i))    = i
P2(N - P(i)) = N - i
P3(N - i)    = P(i)
P4(i)        = N - P(i)
P5(N - P(i)) = i
P6(N - i)    = N - P(i)
P7(P(i))     = N - i

Programmer en versjon av løsningen på dronningproblemet (Lenker til en ekstern side.) som bare skriver ut én av de åtte løsningene som er speilinger/rotasjoner av hverandre. En løsning skal mao. ikke skrives ut hvis en speiling/rotasjon av den er skrevet ut tidligere. For n=8 finnes det 12 slike 'unike' løsninger.

## Oppgave 4

Vi skal fargelegge landene på et kart, slik at land som har felles grense ikke får samme farge. Det ble for ca. 100 år siden bevist at dette alltid kan gjøres med bare fire farger. Vi har n land som er nummerert fra 0 til n - 1. Hvilke land som har felles grense er angitt i en globalt tilgjengelig boolsk tabell:

boolean felles[][]

felles[i][j] er true hvis og bare hvis landene med nummer i og j har felles grense. Det skal finnes en lovlig fargelegging, som skal lagres i en array int farge[] av lengde n. Fargene er nummerert fra 1 til 4. Lag først en rekursiv funksjon som genererer alle mulige fargelegginger, og legg så inn en avskjæring slik at bare lovlige fargelegginger blir genererert. Klarer du å pønske ut en lur måte å gjøre avskjæring på?

## Oppgave 5

n leketøy skal fordeles på n barn, og hvert av barna setter opp en ønskeliste med et antall leker de gjerne vil ha. Skriv et program som, om mulig, finner en fordeling av lekene slik at alle barna får et leketøy de vil ha. Bestem selv hvordan du vil representere ønskelisten og den øvrige datastrukturen som trengs for å løse problemet.