### Oppgave 2

I begge bitene med Java-kodene nedenfor er L en liste av samme type som beskrevet i forrige oppgave, men listen er nå ordnet.
```java
List<Integer> L = new List<Integer>();
for (int i = 0; i < n; i++)
    L.add(new Integer(i));

int n = L.size(), sum = 0;
Integer I = (Integer) L.last();
for (int i = 0; i < n; i++)
    if (L.contains(I))
      sum + = i;
```

Hva er arbeidsmengden for disse to kodesekvensene, angitt med O-notasjon, hvis den ordnede listen L er implementert:

- Med bruk av en array og med lineært søk. 
- Som en lenket liste. 
- Med bruk av en array og med binært søk.

### SVAR:

1. array med lineært søk:
- add: O(n)
- contains: O(n)

Arbeidsmengde:
- add: O(n^2)
- contains: O(n^2)

2. lenket liste:
- samme som forrige oppgave

3. Array med binært søk
- add: O(n)
- contains: O( log n)

Arbeidsmengde:
- add: O(n^2)
- contains: O(n log n)