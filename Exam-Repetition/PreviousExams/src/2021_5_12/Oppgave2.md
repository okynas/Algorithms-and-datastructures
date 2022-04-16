## Oppgave 2

Oppgave 2a,b finnes i oppgave2.java

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

