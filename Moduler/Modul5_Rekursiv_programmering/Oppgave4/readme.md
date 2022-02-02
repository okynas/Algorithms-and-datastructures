## Oppgave 4

De såkalte binomialkoeffesientene C(n, m) er en rekke med tall som kan defineres rekursivt ved:

    C(n, 0) = 1 og C(n, n) = 1, 	for n >= 0
    C(n, m) = C(n-1, m) + C(n-1, m-1), 	for 0 < m < n

- Skriv en rekursiv metode som beregner C(n, m) etter formelen ovenfor. 
- Tegn en figur (et såkalt kalltre) som viser alle de rekursive metodekallene for metoden fra punkt 1 når den beregner C(6, 4). 
- Test metoden din ved å lage et program som leser inn verdier for n og m og deretter bruker metoden til å beregne binomialkoeffesienten.

### Svar

[Oppgave 1a](src/BinomialKoeffesient.java)

Oppgave 1b

                   +-----6,4-----+ 
                  /              |
                 /               | 
                /                | 
               /                 | 
              5,4                5,3-----------+
             /   \               /              \
            /     \             /                \
            4,4   4,3         4,3                4,2----------+
           /   \             /   \              /              \
         3,3   3,2        3,3   3,2           3,2              3,1
         /      \         /       \          /   \            /   \
        2,2     2,1     2,2       2,1       2,2   2,1       2,1  2,0
        /        \      /  \      /  \      /      \
      1,1        1,0  1,1   1,0  1,1  1,0 1,1      1,0