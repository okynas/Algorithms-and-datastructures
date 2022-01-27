## 4.2: Øvingsoppgaver
### Oppgave 1
I hver av de seks bitene med Java-kodene nedenfor er L en uordnet liste av typen List, som inneholder elementer av typen Integer. Vi antar at List tilbyr de samme metodene for innsetting, fjerning og søking som lærebokas uordnede lister.

```java
int n = L.size();
for (int i = 0; i < n; i++){
    Integer I=(Integer)L.removeFirst();
};
```

```java
int n = L.size();
for (int i = 0; i < n; i++){
    Integer I=(Integer)L.removeLast();
}
```

```java
List<Integer> L = new List<Integer>();
for (int i = 0; i < n; i++)
    L.addToFront(new Integer(i));
```


```java
List<Integer> L = new List<Integer>();
for (int i = 0; i < n; i++)
    L.addToRear(new Integer(i));
```

```java
List<Integer> L = new List<Integer>();
Integer I, I_minus_1;
I = new Integer(0);
L.addToFront(I);

for (int i = 1; i < n; i++) {
    I_minus_1 = I;
    I = new Integer(i);
    L.addAfter(I, I_minus_1);
}
```

```java
int n = L.size(), sum = 0;
Integer I = (Integer) L.last();
for (int i = 0; i < n; i++)
    if (L.contains(I))
        sum + = i;
```

Hva er arbeidsmengden for hver av disse seks kodesekvensene, angitt med O-notasjon, hvis den uordnede listen L er implementert:

- Med bruk av en array.
- Som en lenket liste.

### Oppgave 2
I begge bitene med Java-kod ene nedenfor er L en liste av samme type som beskrevet i forrige oppgave, men listen er nå ordnet.

````java
 List<Integer> L = new List<Integer>();
  for (int i = 0; i < n; i++)
    L.add(new Integer(i));
````

````java
  int n = L.size(), sum = 0;
  Integer I = (Integer) L.last();
  for (int i = 0; i < n; i++)
    if (L.contains(I))
      sum + = i;

````

Hva er arbeidsmengden for disse to kodesekvensene, angitt med O-notasjon, hvis den ordnede listen L er implementert:

- Med bruk av en array og med lineært søk.
- Som en lenket liste.
- Med bruk av en array og med binært søk.

### Oppgave 3
Skriv om palindromprogrammet (Lenker til en ekstern side.) slik at det i stedet bruker en uordnet, lenket liste til å sjekke om tekststreng er et palindrom (Lenker til en ekstern side.). Legg først alle tegnene inn i listen. Bruk deretter metodene for å fjerne første og siste element i en liste til å gå gjennom hele tekststrengen. Bruk lærebokas listemodul (Lenker til en ekstern side.) i programmet ditt.

### Oppgave 4
Skriv om koden for Josephus' problem (Lenker til en ekstern side.), slik at det bruker en kø i stedet for en liste for å finne den riktige rekkefølgen for fjerning av elementene.

### Oppgave 5
Skriv om koden for radixsortering (Lenker til en ekstern side.) slik at programmet sorterer en uordnet liste med heltall i stedet for en array. Bruk lærebokas listemodul.

 