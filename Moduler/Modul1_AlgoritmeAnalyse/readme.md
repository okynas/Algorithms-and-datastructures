# 1.2: Øvingsoppgaver

### Oppgaver:
- [x] Oppgave 1
- [x] Oppgave 2
- [x] Oppgave 3
- [x] Oppgave 4

## Oppgave 1

Bruk O-notasjon til å angi arbeidsmengden for hver av de 7 kodebitene nedenfor:

      for (int i = 0; i < n; i++)
        sum++;
      
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            sum++;
      
      for (int i=0; i < n; i++)
        sum++;
      for (int j = 0; j < n; j++)
        sum++;
      
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n * n; j++)
            sum++;
      
      for (int i = 0; i < n; i++)
        for (int j = 0; j < i; j++)
            sum++;
      
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n * n; j++)
            for (int k = 0; k < j; k++)
                sum++;
      
      for (int i = 0; i < n; i++)
        for (int j = 0; j < i * i; j++)
            if (j % i == 0)
                for (int k = 0; k < j; k++)
                    sum++;

## Oppgave 2
Et program bruker 0.5 ms (millisekunder eller "tusendeler") for en input av størrelse n=100. Hvor lang tid brukes for en input av størrelse 500 (problemstørrelsen øker altså med en faktor 5) når kjøretiden t er:

1. Lineær, dvs. t = O(n)
2. Superlineær, dvs. t = O(n logn):
3. Kvadratisk, dvs. t = O(n2)
4. Kubisk, dvs. t = O(n3)

## Oppgave 3
Et program (algoritme) bruker 0.5 ms (millisekunder eller "tusendeler") for en input av størrelse n=100. Hvor stort problem (uttrykt ved n) kan løses i løpet av 1 minutt (60000 ms) når kjøretiden t er:
1. Lineær, dvs. t = O(n)
2. Superlineær, dvs. t = O(n logn):
3. Kvadratisk, dvs. t = O(n2)
4. Kubisk, dvs. t = O(n3)

## Oppgave 4
Skriv et program som tester hvor lang tid maskinen bruker for å utføre hhv.:

      n log(n), n2, n3, n5, 2n og n! addisjoner for n = 10, 20, 30,... 90, 100. 

## Oppgave 5
For et tall n>0 vil følgende programbit beregne 2'er logaritmen til n i variabelen L2, rundet av nedover til nærmeste heltall:

      i = 1;
      L2 = -1;
      while (i <= n)
      {
         i = i * 2;
         L2 = L2 + 1;
      }

Av hvilken størrelsesorden er tidsforbruket til denne algoritmen? 
