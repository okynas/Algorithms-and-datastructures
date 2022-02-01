## Oppgave 2

La S(n) betegne summen av de n første naturlige tallene 1, 2, 3, ..., n. Skriv tre metoder (funksjoner) som beregner S(n) på følgende måter:

    Skriv en enkel for-løkke som beregner 
    S(n) = 1 + 2 + 3 + ... + n.

    Bruk den rekursive definisjonen:

      S(0) = 0   og
      S(n) = n + S(n-1).

    Bruk formelen S(n) = n · (n+1)/2

Hvilken av disse tre metodene er lettest å programmere? Hvilken er lettest å forstå for en som ikke kan noe matematikk? Hvilken er raskest for store verdier av n?


### Svar:

Programmet ligger [her](src/Main.java)

1. Den metoden som er lettest å programmere er Metode2 eller 3
2. Det er lettest å forstå seg på 1, (hvis man ikke kan matte)
3. Den raskeste, for store verdier av n, er metode 3.