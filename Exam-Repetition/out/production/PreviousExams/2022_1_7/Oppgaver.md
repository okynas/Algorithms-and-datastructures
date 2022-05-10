# Algoritme eksamen 7 januar 2022 (KONTE)
## Oppgave 1
### a)
Metoden skal undersøke om listen er sortert stigende, og returnere true dersom den er det,
false ellers.

```java
// internt i IntList klassen:
public boolean isSorted() {
  if (isEmpty()) {
    return true;
  }

  ListNode current = head;
  while (current != tail ) {
    if (current.data > current.next.data) {
      return false;
    } else {
      current = current.next;
    }
  }
  
  return false;
}
```

### b)

De to listene L1 og L2 som er input til metoden skal være sortert stigende. Metoden trenger ikke å
sjekke om de er sorterte.
flettSammen skal lage og returnere en ny liste der elementene i de to sorterte inputlistene L1
og L2 er flettet sammen. Den nye listen skal altså være stigende sortert, og inneholde alle
elementene i L1 og L2. L1 og L2 skal begge være tomme når metoden er ferdig.
Du skal bruke metodene fra klassen IntList til både å hente ut data fra L1 og L2 og å sette
dem inn i den nye listen. Legg vekt på å skrive kode som er så effektiv som mulig.

```java
// eksternt fra IntList klassen
IntList flettSammen(IntList L1, IntList L2) {
  IntList sl = new IntList();

  while (!L1.isEmpty() && !L2.isEmpty()) {
    int val1 = L1.first();
    int val2 = L2.first();
    if (val1 < val2) {
      sl.addToRead(L1.removeFirst())
    } else {
      sl.addToRead(L2.removeFirst())
    }
  }

  while(!L1.isEmpty()) {
    sl.addToRead(L1.removeFirst())
  }

  while(!L2.isEmpty()) {
    sl.addToRead(L2.removeFirst())
  }
}
```

### c)

1. Lag to nye, kortere lister som inneholder hver sin halvdel av listen L
2. Sortér de to korte listene rekursivt
3. Flett sammen de to sorterte korte listene til én sortert liste
Metoden flettSammen fra oppgave 1 b) skal brukes til å gjøre flettingen i steg 3.

```java
IntList fletteSort(IntList L) {
  if (L.size() < 2) {
    return L;
  }

  IntList L1 = new IntList();
  IntList L2 = new IntList();

  while(!L.isEmpty()) {
    L1.addToRead(L.removeFirst());
    if (!L.isEmpty()) {
      L2.addToRear(L.removeFirst());
    }
  }

  L1 = fletteSort(L1);
  L2 = fletteSort(L2);

  return (flettSammen(L1, L2));

}
```


## Oppgave 2
### a)
O(1), fordi ingen av funksjonene bruker løkker, og blir derfor en enkel operasjon.

### b)
O(n), metoden har en løkke som går igjennom hele lisa for å finne det nest siste elementet.

### c)
O(n), ved hver iterasjon i metoden, settes nytt element inn i listen, altså n iterasjoner.

### d)
O(n log n), fordi for hvert gjennomløp er det 2 operasjoner som halverer antall ganger koden kjøres. Og det er en løkke som 
går n ganger, og fjerner og legger til første element.

## Oppgave 3
10, 25, 15, 7, 21, 18, 4, 30, 5, 33

### a)

v   h   d   s
10  4   0   10
25  3   1   6
15  2   2   3
7   2   1   3
21  1   3   2
18  0   4   1
4   1   2   1
30  1   2   1
5   0   3   1
33  0   3   1

V   H   D   S
10  4   0   10
25  3   1   6
15  2   2   3
7   2   1   3
21  1   3   2
18  0   4   1
4   1   2   2 
30  1   2   2
5   0   3   1
33  0   3   1

### b)
Pre-Order: 10 7 4 5 25 15 21 18 30 33
In-Order: 4 5 7 10 15 18 21 25 30 33
Post-Order: 5 4 7 18 21 15 33 30 25 10
Level-Order: 10 7 25 4 15 30 5 21 33 18

## Oppgave 4
### a)
Den private metoden skal sette inn verdien verdi i søketreet på vanlig måte. Den skal i tillegg
sørge for at verdien av variabelen S er korrekt i alle nodene også etter innsetting av en ny verdi i
treet. Hvis verdien som skal settes inn finnes i treet fra før, skal metoden bare returnere false
uten at det gjøres noen innsetting, ellers skal den returnere true.
Programmér den private metoden settInn.

```java
private boolean settInn(TreNode rot, int verdi) {
  if (verdi == rot.data) {
    return false;
  }

  if (verdi < rot.data) {
    if (rot.venstre == null ) {
      rot.venstre = new TreNode(verdi);
      rot.S++;
      return true;
    }
    else {
      if(settInn(rot.venstre, verdi)) {
        rot.S++;
        return true;
      }  
      else {
        return false;
      }
    }
  } else {
    if (rot.høyre == null) {
      rot.høyre = new TreNode(verdi);
      rot.S++;
      return true;
    } else {
      if (settInn(rot.høyre, verdi)) {
        rot.S++;
        return true;
      } else {
        return false;
      }
    }
  }
}
```

### b)

Klassen IntBST inneholder en (ferdig programmert) public-metode skrivS som brukes til å
skrive ut dataverdien i alle noder i treet som har en størrelse lik verdien på parameteren S. Denne
metoden kaller en privat rekursiv metode som skal skrive ut alle nodene med størrelse lik S i
subtreet som starter i parameteren rot:

```java
private void skrivS(TreNode rot, int S) {
  if (rot == null || rot.S < S) {
    return;
  }
  if (rot.S == S) {
    System.out.println(rot.data + " ");
  }

  skrivS(rot.venstre, S);
  skrivS(rot.høyre, S);
}
```

## Oppgave 5

Tallene skal settes inn:
21 23 63 49 34 99 89
### Linear
0: 99
1: 21
2: 89
3: 23
4: 63
5: 34
6:
7:
8:
9: 49

### kvadratisk
0: 99
1: 21
2:
3: 23
4: 63
5: 34
6:
7:
8: 89
9: 49

### kjeding
0:
1: 21
2:
3: 63, 23
4: 34
5:
6:
7:
8:
9: 89, 99, 49

### last come first serve
0: 99
1: 49
2: 21
3: 63
4: 34
5: 23
6:
7:
8:
9: 89

### robin hood
21 23 63 49 34 99 89

0: 99
1: 89
2: 21
3: 23
4: 63
5: 34
6:
7:
8:
9: 49