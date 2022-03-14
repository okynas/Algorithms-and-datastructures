## Obligatorisk oppgave 4: Tekstanalyse

#### Sub-TASKS:
- [x] Lese en tekst fra bruker eller fil
  - [x] Splitte opp tekst-input i ord.
  - [x] Ett ord inneholder kun bokstaver, slutt ved spesialtegn som ikke er en bokstav.
  - [x] Gjør om alle bokstavene til store bokstaver => blir ikke forskjell på start eller slutt av setnign
- [x] Registrere alle ordene som forekommer i teksten i binært søketre 
  - [x] Lage binært søketre
    - [x] Lage metodene til binært søketre
    - [x] Initielt tomt binært søketre
    - [x] Hvis duplikat, skal en teller i noden økes med 1
  - [x] Skrive ut ordene i alfabetisk rekkefølge (InOrder)
  - [x] Skrive ut antall forekomster av ordene

Denne oppgaven går ut på å lese en tekst og registrere alle ordene som forekommer i teksten i et binært søketre.

Skriv et program som leser tekst fra en fil (eller fra standard input) og [deler teksten opp i forskjellige ord](https://it.hiof.no/algdat/oblig/words.java) . Et ord regnes å bestå bare av bokstaver, og et ord er slutt når det kommer et tegn som ikke er en bokstav. Gjør om alle bokstavene i hvert ord til en stor bokstav, slik at det ikke blir forskjell på ord som kommer i begynnelsen av en setning og ord som kommer inne i en setning.

Hvert ord som leses fra teksten skal legges inn i et binært søketre som initiellt er tomt. Hvis ordet allerede finnes fra før, skal det ikke settes inn på nytt, men en teller i noden som registrerer antall forekomster av ordet skal oppdateres.

Etter at hele teksten er lest skal alle ordene som forekom skrives ut i alfabetisk rekkefølge, sammen med antallet ganger ordet forekom. Hvis treet er riktig bygd opp er det lett å skrive ut ordene i alfabetisk rekkefølge ved å traversere treet på en bestemt måte.

Skriv hele programmet fr a bunnen av, inkludert koden for innsetting av noder i søktreet. 