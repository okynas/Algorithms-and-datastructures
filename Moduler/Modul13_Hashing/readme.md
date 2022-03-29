# 13.4: Øvingsoppgaver
## Oppgave 1
Vi har en hashtabell med lengde lik 10, og bruker følgende hashfunksjon:

     hash(x) = x % 10
Dvs. at hashindeksen som beregnes ganske enkelt er det siste sifferet i helttallet x. Vis hvordan hashtabellen, som til å begynne med er tom, ser ut ved innsetting i rekkefølge av verdiene:

     4371 1323 6173 4199 4344 9679 1989

når vi løser kollisjoner med bruk av:

- Lineær probing 
- Kvadratisk probing
- Hashing med kjeding

## Oppgave 2
Lag en enkel hashfunksjon:

int hashString(String S, int hashLengde);
som regner ut indekser mellom 0 og hashLengde-1 ut i fra datanøkler som består av tekststrenger.

Lag også et testprogram som beregner både hashverdier og antall kollisjoner for disse 10 nøklene:

     PAL LAP PAM MAP PAT PET SET SAT TAT BAT
Kjør programmet ditt med hashlengder lik 

     10, 11, 13, 16, 17, 18 og 19.

## Oppgave 3
Følgende nøkkelverdier skal legges inn i en tom hashtabell:

    10 100 32 45 58 126 3 29 200 400 0
Vi skal i deloppgavene nedenfor se på effekten av å bruke forskjellige hashfunksjoner og hashlengder.

La hashfunksjonen være:

     hash(nøkkel) = nøkkel % hashlengde

Hashverdien er her bare er resten ved heltallsdivisjon av datanøkkelen med hashlengden. Finn hashverdien som beregnes for hver av de 11 nøklene ovenfor og beregn antall kollisjoner, når hashlengden er lik 13.

Finn hashverdiene og antall kollisjoner, når hashlengden er lik 13 og hashfunksjonen bruker folding etter følgende metode:

Legg sammen de enkelte sifferne i hver nøkkelverdi til et tall. F.eks. vil nøkkelverdien 126 gi summen 1 + 2 + 6 = 9.

Beregn deretter hashverdien ved å finne resten ved heltallsdivisjon av summen av sifferne med hashlengden.

Gjenta oppgave b., men med hashlengde lik 11.

## Oppgave 4
Fra ny/utsatt eksamen januar 2022: [Oppgave 5](https://it.hiof.no/algdat/oppgaver/eksamen_07-01-2022/oppgaver.pdf)

## Oppgave 5
Oppgaven er hentet fra en tidligere eksamen i alg.dat.

I et binært søketre, der dataene er 11-sifrede fødelsnummer som er ordnet/sortert på vanlig måte, er nodene av følgende klasse:

    class node {
    long foedselsnummer; // Datafelt
    node venstre;        // Peker til venstre barn
    node hoyre;          // Peker til høyre barn
    }

Du har full tilgang til alle variablene som er lagret i nodene i søketreet.

Hele søketreet skal kopieres/flyttes over i en hashtabell, det det skal brukes lineær probing for løsning av kollisjonsproblemet. Denne hashtabellen skal inneholde referanser/pekere til objekter av typen node (dette betyr at alle objektene i hashtabellen vil inneholde to referanser til barn/subtrær som ikke brukes, men det er uten betydning her). Hashindeksene skal beregnes ut i fra fødselsnummeret som er lagret i hver node i søketreet.

Arrayen som skal inneholde hashtabellen ligger globalt tilgjengelig som:

     node hashtabell[];

I utgangspunktet er alle elementene i arrayen hashtabell satt lik null.

Programmér en metode;

     void hash_soeketre(node rot, int n)

som legger alle dataene i søketreet med rot i noden rot inn i arrayen hashtabell. Parameteren n er lik antall noder i søketreet.

Vis spesielt hvordan programmet ditt beregner hashindekser og gjør innsetting (med løsing av kollisjoner ved bruk av lineær probing). Disse to operasjonene bør du skille ut som egne metoder.

Programmet skal også opprette (sette av plass til) hashtabellen før innsettingen begynner. Du kan her anta at du har tilgjengelig en metode

     int neste_primtall(int i)

som returnerer minste primtall som er større eller lik parameteren i.