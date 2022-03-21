# Oppgave 5
Oppgaven er hentet fra en tidligere eksamen i alg.dat.

I et binært søketre, der dataene er 11-sifrede fødelsnummer som er ordnet/sortert på vanlig måte, er nodene av følgende klasse:

    class node
    {
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