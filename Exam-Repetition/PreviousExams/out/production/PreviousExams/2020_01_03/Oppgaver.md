## Oppgave 1 - Algoritme analyse:

### a)
Løkka før n/2 ganger. Totalt n/2 = O(n)

### b)
Ytre løkka går n ganger, indre går 2*i ganger
Totalt O(n^2)

### c)
Ytre løkke går n^2 ganger.
Indre løkke går log i^2 ganger, 
Totalt O(n^2 log n)

### d)
N reduseres med 1 for hver gang, helt ned til 1
O(n) gjennomløp

### e)
N reduseres med n/2 ganger. Totalt O(log n)

### f)
N reduseres med n/2 for hver gang. Men siden det skjer 2 ganger per gjennomløp, går programmet n ganger
Totalt O(n).

## Oppgave 2 - Binære trær
Level-order / nivå-for-nivå traversering:
15 7 19 6 9 18 22 3 12

### oppgave a)
1. Preorder (left, root, right)
15 7 6 3 9 12 19 18 22

2. Inorder (root, left, right)
3 6 7 9 12 15 18 19 22

3. Postorder (left, right, root)
3 6 12 9 7 18 22 19 15


### oppgave b)
Ja det er et avl tre, fordi det er ingen noder som har større høydeforskjell enn 1.

### oppgave c)
skal sette inn: 8 5 21

15 7 19 6 9 18 22 3 8 12 21 5

### oppgave d)
skal fjerne 15

12 7 19 6 9 18 22 3 

## oppgave 3
### oppgave a + b + c)

```java
// a
int antallBlader(binærNode rot) {
  if (rot == null) {
    return 0;
  }

  if (rot.venstre == null && rot.høyre == null) {
    return 1;
  }

  return (antallBlader(rot.venstre) + antallBlader(rot.høyre) )
}

// b
void speil(binærNode rot) {

  if (rot != null) {
    binærNode temp = rot.venstre;
    rot.venstre = rot.høyre;
    rot.høyre = temp;

    speil(rot.venstre);
    speil(rot.høyre);
  }
}

// c
void speil(binærNode rot) {
  
  if (rot == null) {
    return;
  }

  Queue Q = new Queue();
  Q.enqueue(rot);

  while (!!.isEmpty()) {
    binærNode denne = Q.dequeue();

    binærNode temp = denne.venstre;
    denne.venstre = denne.høyre;
    denne.høyre = temp;

    if(denne.venstre != null) {
      Q.enqueue(denne.venstre;)
    }

    if(denne.høyre != null) {
      Q.enqueue(denne.høyre;)
    }

  }
}
```

## Oppgave 4
### a)
4371 1323 6173 4199 4344 9679 1989

Lineær:
0: 9679
1: 4371
2: 1989
3: 1323 
4: 6173
5: 4344
6
7
8
9: 4199

Kvadrat
0: 9679
1: 4371
2
3: 1323
4: 6173
5: 4344
6
7
8: 1989
9: 4199

Kjeding
0
1: 4171
2
3: 6173, 1323
4: 4344
5
6
7
8
9: 1989, 9679 4199

LCFS
0: 9679
1: 4199
2: 4371
3: 6173
4: 4344
5: 1323
6
7
8
9: 1989


4371 1323 6173 4199 4344 9679 1989

RH
0: 9679
1: 1989
2: 4371 
3: 1323
4: 6173
5: 4344
6
7
8
9: 4199
### b)
1. Åpen hashing:
Hvis man skal fjerne element fra hashtabellen ved åpen hashin, kan man ikke bare ta den ut av hashtabellen. Det man gjør er å markere elementet som skal fjernes, og fjerne den når det er nødvendig med rehashing. 

2. Kjeding: 
Finner listen som elementet skal fjernes fra. Dette gjøres ved å beregne hashindeksen, deretter fjerner man verdien på vanlig møte fra lenket liste. 

### c)
1. LCFS
Ja. Denne fungerer ved å endre til kvadratisk probes. Det er fordi vi følger en og samme kjede med probes, og ser i hvert steg etter hvilken indeks neste skal være på.

2. RH
Nei. Ved robin hood, kan man ikke bruke kvadratisk probing. Det er fordi hvis vi skal flytte et element som allerede er i tabellen, vet vi ikke hvor neste probe befinner seg. Neste probes regnes ut ved å sammenligne den som skal settes inn og den som allerede er der sin distanse fra original innsetting. 