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

## SVAR:

- removeFirst:
- removeLast:
- addToFront:
- addToRear:
- addAfter:
- contains:

#### 1a - Uordnet ArrayList

- removeFirst: O(n)
- removeLast: O(1)
- addToFront: O(n)
- addToRear: O(1)
- addAfter: O(n)
- contains:	O(n)

Arbeidsmengde:
1. n*O(n) = O(n^2)
2. n*O(1) = O(n)
3. O(n^2)
4. O(n)
5. O(n^2)
6. O(n^2)

#### 1b - Uordnet lenket liste

- removeFirst: O(1)
- removeLast: O(n)
- addToFront: O(1)
- addToRear: O(1)
- addAfter: O(n)
- contains: O(n)

Arbeidsmengde:
1. O(n)
2. O(n^2)
3. O(n)
4. O(n)
5. O(n^2)
6. O(n^2)