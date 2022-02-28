# 9.3: Øvingsoppgaver

### Oppgaver:
- [x] Oppgave 1
  - [x] a
  - [x] b
  - [x] c
- [x] Oppgave 2
  - [x] a
  - [x] b
  - [x] c
  - [x] d
- [x] Oppgave 3
  - [x] a
  - [x] b
  - [x] c
- [ ] Oppgave 4
- [ ] Oppgave 5

## Oppgave 1
Denne oppgaven baserer seg på følgende binære søketre (ikke AVL) der verdien i hver node er en enkel bokstav:

           k
          / \
         /   \
        c     n
       / \     \
      a   e     s
         / \   / 
        d   h p

1. Sett inn hver av disse verdiene i dette treet:

       m  f  b  t  c  s

Finn ut hvilke sammenligninger av verdier som blir gjort i hver enkelt av tilfellene. Gjør hver innsetting uavhenging av de andre, slik at innsettingen foregår i det opprinnelige treet som er "tegnet" ovenfor:

2. Finn hvilke sammenligninger som blir gjort når vi leter etter følgende verdier i søketreet ovenfor:

       c  s  k  a  d  f  t

3. Bruk den vanlige algoritmen for fjerning av node fra et søketre til å fjerne følgende verdier fra treet ovenfor:

       a  p  n  s  e  k

Gjør hver fjerning uavhengig av de andre, slik at fjerningen hele tiden skjer i det opprinnelige treet. Kontroller at fjerningen gjøres riktig, dvs. at treet fortsatt er et søketre etter at en verdi er fjernet.

## Oppgave 2
Dette er en tidligere eksamensoppgave.
I denne oppgaven skal du programmere noen metoder som opererer på binære søketrær. Dataene som lagres i hver node i treet er et heltall og en enkelt bokstav. Nodene har som vanlig referanser til venstre og høyre barn. I tillegg har hver node en referanse til foreldernoden (forgjengeren) i treet. Disse referansene til foreldernoder skal kun brukes i oppgave d). Nodene har også en heltallsvariabel sum som bare skal brukes i oppgave c).

Følgende klasse skal brukes til å lagre hver node i søketreet:

    class tre_node {
        public tre_node() ...   // Konstruktør, skal ikke programmeres
        int verdi;              // Heltallsverdi som lagres i hver node
        char bokstav;	      // Bokstav/tegn som lagres i hver node
        int sum; 		      // Brukes bare i oppgave c)
        tre_node v, h;	      // Venstre og høyre barn
        tre_node forelder;      // Brukes bare i oppgave d)
    }
Hvis venstre og/eller høyre subtre til en node er tomt, vil referansene v og/eller h i noden være lik null. Vi krever ikke at søketreet skal være balansert.
Nodene i søketreet ligger ordnet/sortert på variabelen verdi i hver node, slik at alle heltallsverdier i en nodes venstre subtre er mindre eller lik verdien i noden selv (hvis venstre subtre ikke er tomt), mens alle verdier i nodens høyre subtre er større enn verdien i noden (hvis høyre subtre ikke er tomt). Det kan altså finnes flere forekomster av samme verdi i treet. Hele søketreet kan representeres med en referanse til roten i treet.

I programkoden du skriver kan du anta at du har tilgang (f.eks. friendly access) til alle variable inne i klasseobjektene som skal brukes.

1. Lag en metode:


     void skriv_bokstav(tre_node rot, int x)

Parameteren rot refererer her til roten i et søketre. Metoden skal skrive ut verdien av variabelen bokstav for alle de nodene i treet som har en heltallsverdi (variabelen verdi) lik verdien av parameteren x. For noder som ikke har verdi lik x, skal det ikke gjøres noen utskrift. Metoden du lager skal helst være så effektiv som mulig, men du kan selv velge om du vil lage den rekursiv eller iterativ.

2. Anta at det er totalt n noder i søketreet.Bruk O - notasjon til å angi en øvre grense for arbeidsmengden til metoden skriv_bokstav fra oppgave a), hvis:
   1. Søketreet er balansert. 
   2. Alle nodene i treet (unntatt én) har bare ett subtre som ikke er tomt.

3. Hver av nodene i søketreet har, i tillegg til variabelen verdi som inneholder nodens nøkkelverdi, også en heltallsvariabel sum. I denne oppgaven antar vi at variabelen sum i utgangspunktet er satt lik 0 (null) i alle noder. Lag en metode:


    void sett_sum(tre_node rot)

som, for hver node i søketreet, setter variabelen sum lik summen av alle (nøkkel)verdiene i nodens subtrær pluss verdien (av variabelen verdi) i noden selv.
Parameteren rot er her til roten i søketreet. Metoden sett_sum skal være rekursiv.

4. I denne oppgaven skal du lage en metode:


    void sett_forelder(tre_node rot)

som, for hver node i søketreet, setter variabelen forelder til å referere til nodens forgjenger (foreldernode) i treet. Du kan anta at forelder i utgangspunktet har en vilkårlig (ikke bestemt) verdi i hver node. Roten i treet (representert ved parameteren rot), skal få forelder satt lik null.

## Oppgave 3
1. Ta utgangspunkt i følgende AVL-tre med verdiene 1,2,3,...,10:


          4
         / \
        /   \
        2     8
       / \   / \
      1   3 6   9
         /  \   \
        5   7   10


Tegn hvordan treet blir seende ut etter innsetting (i denne rekkefølgen) av verdiene 11,12,13,...,20.

2. Ta utgangspunkt i følgende AVL-tre:


         30
        /  \
       /    \
     20      70
    /  \    /  \
    10   25  50   80
            /  \
          40    60


Vis hvordan treet blir seende ut ved innsetting av følgende tall:

     45   55   65   75


Hver av disse innsettingene skal gjøres i det opprinnelige treet som er "tegnet" ovenfor.
3. Følgende AVL-tre er gitt:

             30
            /  \
           /    \
         20      50
         /      /  \
       10     40    60
               \     \
               45    70
     

Ta utgangspunkt i dette treet og tegn hvordan det blir etter innlegging av verdiene:
75 og deretter 80
75 og deretter 65
75, 35 og 47
75, 35 og 32

## Oppgave 4

Lag en rekursiv metode:

    boolean erAVL(node rot);

som sjekker om et vanlig binært tre oppfyller balansekravene til et AVL-tre. Bruk et enkelt tre der data i nodene bare er et heltall.

## Oppgave 5

Binære søketrær kan brukes til å implementere en sorteringsalgoritme kalt treesort:
1. Legg alle dataene som skal sorteres inn i et binært søketre.
2. Legg dataene tilbake i sortert rekkefølge ved å gjøre en inorder traversering av treet.
Programmer treesort for sortering av arrayer med heltall. Hva er arbeidsmengden for treesort?