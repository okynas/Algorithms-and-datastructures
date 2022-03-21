## Oppgave 1: "Last come, first served"
I store datasett er det ofte slik at data som nylig er lagt inn er de som det søkes mest etter. Det vil da lønne seg å bruke en datastruktur som finner de nyeste elementene raskest -- en "last come, first served"-organisering av dataelementene.

Hvis vi bruker hashing med åpen adressering, kan dette løses ved å sørge for antall probes alltid er minst for de nyeste elementene i hashtabellen. For hashing med lineær probing kan følgende metode benyttes for å håndtere kollisjoner:

1. Når et nytt dataelement settes inn i tabellen, skal det alltid lagres på indeksen som beregnes av hashfunksjonen.
2. Hvis en indeks i hashtabellen er i bruk, skal elementet som allerede ligger der flyttes "et hakk til høyre" for å lage en ledig plass. 
3. Denne prosessen gjentas inntil vi ikke lenger trenger å flytte dataelementer "et hakk til høyre" (vi kommer til en ledig plass i tabellen). 

Skriv om testprogrammet for [hashing med lineær probing](https://it.hiof.no/algdat/kode/hashLinear.java), slik at det i stedet bruker denne "last come, first served"-strategien for å løse kollisjoner. Markér tydelig i besvarelsen din hvor du har gjort endringer i koden. 