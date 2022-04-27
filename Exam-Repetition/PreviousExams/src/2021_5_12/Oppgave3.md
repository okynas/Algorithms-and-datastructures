## Oppgave 3: Hashing med lineær probing 

int hash(int value) { 
  return value % h; 
}

h = 13

13 14 15 3 1 21 9 8 25 12

0:
1:
2:
3:
4:
5:
6:
7:
8:
9:
10:
11:
12:

Ved vanlig lineær probing: ser den slik ut:
0: 13
1: 14
2: 15
3: 3
4: 1
5: 12
6:
7:
8: 21
9: 9
10: 8
11:
12: 25

### a) LCFS

0: 25
1: 13
2: 1 
3: 14
4: 15
5: 3
6:
7:
8: 8
9: 21
10: 9
11:
12: 12

### b) RH


0: 12 
1: 13 
2: 1  
3: 14
4: 15
5: 3
6:
7:
8: 21 
9: 8
10: 9
11:
12: 25 

### c) og d)
Egen java kode:

### e)
Hvis load factor = 0.5, vil arbeidsmengden være O(n). Dette er fordi for-løkken går igjenno like mange ganger som er ca 2n. Dist metoden kalles O(1) gang for hvert gjennomløp.

### f)
Minste verdien vil være Robin hood. Det er fordi denne prøver en vei hvor den sjekker korteste avstand mellom to indekser, og sammenligner disse for hver gang helt til et element kan settes inn.