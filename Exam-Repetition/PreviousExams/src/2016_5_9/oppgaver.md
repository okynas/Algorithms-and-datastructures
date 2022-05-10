## Oppgave 3
```java
void blackBoxSort(int a[]) {
  int n = A.length;
  blackBox B = new blackBox(n);

  for (int i = 0; i < n; i++) {
    B.insert(A[i]);
  }

  for (int i = 0; i < n; i++) {
    A[i] = B.removeMin();
  }
}
```

## Oppgave 4
```java
class treNode {
  String etternavn;
  listeNode første;
  treNode venstre, høyre;
}

class listeNode {
  String fornavn;
  int alder;
  listNode neste;
}

public listeNode(String f, int a) {
  fornavn = f;
  alder = a;
  neste = null;
}

public treNode(String f, String e, int a) {
  etternavn = e;
  venstre = høyre = null;
  første = listeNode(f, a);
}

public void skrivPersoner(treNode rot) {
  if (rot == null) {
    return;
  }

  skrivPersoner(rot.venstre);

  listeNode denne = rot.første,
  while(denne != null) {
    System.out.println(denne.etternavn + ", " + denne.fornavn + " ("+ denne.alder + ")");
    denne = denne.neste;
  }

  skrivPersoner(rot.høyre);
}

public boolean finnes(treNode rot, String fornavn, String etternavn) {
  if (rot == null) {
    return false;
  }

  int resultat = rot.etternavn.compare(etternavn);

  if (resultat < 0 ){
    return finnes(rot.venstre, fornavn, etternavn);
  }

  if (resultat > 0 ){
    return finnes(rot.høyre, fornavn, etternavn);
  }

  listeNode denne = rot.første;
  while(denne != null) {
    int resultat = rot.fornavn.compare(fornavn);

    if (resultat < 0 ){
      return false;
    }

    if (resultat == 0 ){
      return true;
    }

    denne = denne.neste;
  }
  return false;
}
```