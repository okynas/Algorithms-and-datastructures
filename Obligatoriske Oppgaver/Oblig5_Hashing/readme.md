## Oppgave 1: "Last come, first served"
I store datasett er det ofte slik at data som nylig er lagt inn er de som det søkes mest etter. Det vil da lønne seg å bruke en datastruktur som finner de nyeste elementene raskest -- en "last come, first served"-organisering av dataelementene.

Hvis vi bruker hashing med åpen adressering, kan dette løses ved å sørge for antall probes alltid er minst for de nyeste elementene i hashtabellen. For hashing med lineær probing kan følgende metode benyttes for å håndtere kollisjoner:

1. Når et nytt dataelement settes inn i tabellen, skal det alltid lagres på indeksen som beregnes av hashfunksjonen.
2. Hvis en indeks i hashtabellen er i bruk, skal elementet som allerede ligger der flyttes "et hakk til høyre" for å lage en ledig plass. 
3. Denne prosessen gjentas inntil vi ikke lenger trenger å flytte dataelementer "et hakk til høyre" (vi kommer til en ledig plass i tabellen). 

Skriv om testprogrammet for [hashing med lineær probing](https://it.hiof.no/algdat/kode/hashLinear.java), slik at det i stedet bruker denne "last come, first served"-strategien for å løse kollisjoner. Markér tydelig i besvarelsen din hvor du har gjort endringer i koden. 

## Oppgave 2: "Robin Hood"
Effektiviteten av hashing med åpen adressering blir raskt dårligere etterhvert som hashtabellen blir full. Mange kollisjoner vil kunne gi lange og tidkrevende søkeveier med et stort antall probes. For å bedre effektiviteten og gjøre åpen hashing effektiv også for høy load factor, kan det brukes ulike strategier for å unngå svært lange søkeveier.
En enkel metode, som ofte gir gode resultater, er oppkalt etter den engelske middelalderlegenden Robin Hood, en landeveisrøver som var kjent for "å stjele fra de rike og gi til de fattige" i middelalderen. I "Robin Hood"-hashing med lineær probing brukes følgende strategi for å håndtere kollisjonsproblemet:

- Hvis en indeks i hashtabellen allerede er i bruk, skal:

  - Enten dataelementet som ligger der flyttes "et hakk til høyre", slik at det blir en ledig plass til elementet som skal settes inn (som i "last come, first served"-hashing),
  - Eller dataelementet som ligger der skal ikke flyttes, og vi prøver i stedet å sette inn på neste indeks i tabellen (som i vanlig lineær probing).


- La T være dataelementet som allerede ligger i tabellen, og S være elementet som vi forsøker å sette inn. Vi velger alternativ 1 ovenfor (å flytte T til høyre) hvis S nå har flyttet seg lenger vekk fra sin opprinnelige hashindeks enn T. Hvis ikke velger vi alternativ
- Denne prosessen gjentas inntil vi ikke lenger trenger å flytte dataelementer "et hakk til høyre" (vi kommer til en ledig plass i tabellen).


"Robin Hood"-hashing vil lage kortere søkeveier ved alltid å flytte videre det av de to dataelementene som har beveget seg kortest fra "startpunktet" der vi først prøvde å sette det inn.

Skriv om testprogrammet for [hashing med lineær probing](https://it.hiof.no/algdat/kode/hashLinear.java), slik at det i stedet bruker "Robin Hood"-strategien for å løse kollisjoner, Markér tydelig i besvarelsen din hvor du har gjort endringer i koden.

## Oppgave 3: Fjerning av data
Implementer fjerning av et element (en tekststreng) i [programmet for hashing med kjeding](https://it.hiof.no/algdat/2018/kode/hashChained.java).