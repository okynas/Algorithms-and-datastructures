# Eksamen 2019
## Oppgave 1
1 3
2 18
3 abcd
4 1 og 2
5 2
6 ingen
7 alle tallene er heltall med maks m siffer, der m er mye mindre enn n
8 Arrayen er nesten sortert, det er bare noen få tall som står feil
9 o(n)
10 o(n^2)
11 o(n logn)
12 minst (m-1)/2
13 63
14 c
15 2
16 lcfs
17 1-4-6-3-2-5-7-8
18 1-4-5-6-7-2-3-8
19 0-7-8-2-3-8-14-15
20 1-4-5-2-3-6-7-8

## Oppgave 2

```java
int startSekvens1(int A[]) {
  int n = A.length;

  for (int i = 1; i < n; i++) {
    if (A[i] < A[i-1]) {
      return i;
    }
  }

  return 0;

  // hvis i midten, gjør wrap-around
}

int startSekvens2(int A[]) {
  int n = A.length;

  if (A[0] < A[n-1]) {
    return 0;
  }

  int low = 0, high = n-1, mid = 0;

  while (true) {
    mid = low + (high - low + 1) / 2;
    if (A[mid] < A[mid - 1]) {
      return mid;
    }

    if (A[low] > A[mid]) {
      high = mid - 1;
    }
    else {
      low = mid + 1;
    }
  }

}
```

## Oppgave 3

```java
// Finner og skriver ut alle løsninger av tårnproblemet
public class tårn{
  public static int n; // Størrelse på brettet
  public static int p[]; // Lagrer en løsning på tårnproblemet

  // <Evt. andre variabler/arrayer som trengs>
  public boolean[] brukt;

  public static void lagLøsning(int rad){
    // Skriver ut alle mulige løsninger på tårnproblemet rekursivt
    // ved å sette ut tårn fra og med denne raden og til og med rad n.
    // Det er allerede satt ut tårn på radene 1, 2, ..., rad-1
    // <Skal programmeres i oppgave 2>
    if (rad > n) {
      skrivLosning();
    }
    else {
      for (int kol = 1; kol <= n; kol++) {
        if (!brukt[kol]) {
          p[rad] = kol;
          brukt[kol] = true;
          lagLosning(n+1);
          brukt[kol] = false;
        }
      }
    }
  }

  public static void skrivLøsning(){
    for (int i = 1; i <= n; i++) {
      System.out.print(p[i] + " ");
      System.out.println();
    }
  }

  public static void main(String args[]){
    System.out.print("n?: ");
    n = Integer.parseInt(System.console().readLine());
    p = new int[n + 1];

    brukt = new boolean[n+1];

    for (int i = 1; i <= n; i++) {
      brukt[i] = false;
    }

    lagLøsning(1);
  }
}
```


## Oppgave 4
### a)
```java
void settInn(int verdi) {
  // Setter inn en ny forekomst av en verdi i søketreet
  if (erTomt()) {
    rot = new treNode(verdi);
  } else {
    treNode current = rot;
    boolean finished = false;
    while(!finished) {
      if (verdi == current.data) {
        current.antall++;
        finished = true;
      } else {
        if (verdi < current.data) {
          if (current.venstre == null) {
            current.venstre = new treNode(verdi);
            finished = true;
          } else {
            current = current.venstre;
          }
        } else  {
          if (current.høyre == null) {
            current.høyre = new treNode(verdi);
            finished = true;
          } else {
            current = current.høyre;
          }
        }
      }
    }

  }
}
```

### b)
```java
int settHøyde(treNode t) {
  if (t == null) {
    return -1;
  }

  int v = settHøyde(t.venstre);
  int h = settHøyde(t.høyre);

  if (v>h) {
    t.høyde = v + 1;
  } else {
    t.høyde = h + 1;
  }

  return t.høyde;

}
```

### c)
```java
boolean erPerfekt(treNode t) {
  // Returnerer true hvis treet med rot i t er et perfekt binært tre
  // Forutsetter at høyden er satt riktig i alle noder

  // tomt tree er PBT
  if (t == null) {
    return true;
  }

  // tree med høyde = 0 er PBT
  if (t.høyde == 0) {
    return 0;
  }

  if (t.venstre == null || t.høyre == null) {
    return false;
  }

  if ( (erPerfekt(t.venstre) && (t.høyde - t.venstre.høyde == 1)) &&
   (erPrefekt(t.høyre) && (t.høyde - t.høyre.høyde == 1)) ) {
    return true;
  }


  return false;
}
```