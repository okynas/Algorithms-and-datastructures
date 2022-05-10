## Oppgave 2
```java
// int n;            // Antall rader/kolonner i gatenettverket
// int pubX, pubY;   // Pubens plassering/koordinater i nettverket
// int hjemX, hjemY; // Hjemmets plassering/koordinater i nettverket

// //               {"høyre", "ned", "venstre", "opp"};
// int rekkefølge = {0, 1, 2, 3};

public void raveRundt(int startX, int startY) {
  if (startX == hjemX && startY == hjemY) {
    System.out.println("Hjemme");
    return;
  } else {
    boolean lovligSteg = false;
    int retning, stepX = 0, stepY = 0, nyX = 0, nyY = 0;

    while(!lovligSteg) {
      retning = R.nextInt(4);
      if (retning = 0) {
        // høyre
        stepX = 1;
        stepY = 0;
      } else if (retning == 1) {
        // ned
        stepX = 0;
        stepY = 1;
      } else if (retning == 2) {
        // venstre
        stepX = -1;
        stepY = 0;
      } else if (retning == 3) {
        // opp
        stepX = 0;
        stepY = -1;
      }

      nyX = startX + stepX;
      nyY = startY + stepY;

      lovligSteg = (nyX >= 0 && nyX < n && nyY >= 0 && nyY < n);
    }
    antallKryss++;
    if (antallKryss % 10 == 0) {
      System.out.print(".");
    }
    raveRundt(nyX, nyY);
  }
}

public static void main(String[] args) {
  n = 10;
  pubX = 0;
  pubY = n-1;
  hjemX = n-1;
  hjemY = 0;
  R = new Random();
  antallKryss = 0;
  raveRundt(pubX, pubY);
}
```

## Oppgave 3
```java
void skrivSortert(treNode rot) {
  if (rot == null) {
    return;
  }

  skrivSortert(rot.venstre);
  System.out.print(rot.v1 + " ");
  skrivSortert(rot.midt);
  if(rot.antallVerdier == 2) {
    System.out.prin(rot.v2 + " ");
    skrivSortert(rot.høyre);
  }
}

boolean finnes(treNode rot, int x) {
  if (rot == null) {
    return false;
  }

  if (x < rot.v1) {
    return finnes(rot.venstre, x);
  }
  if (x == rot.v1) {
    return true;
  }
  if (rot.antallVerdier == 2) {
    if (x > rot.v2) {
      return finnes(rot.høyre, x);
    }
    else if (x == rot.v2) {
      return true;
    }
  }
  return finnes(rot.midt, x);
}

boolean finnes_i(treNode rot, int x) {
  treNode denne = rot;
  while (denne != null) {
    if (x < denne.v1) {
      denne = denne.venstre;
    } else if (x == denne.v1) {
      return true;
    } else if (denne.antallVerdier == 2) {
      if (x > denne.v2) {
        denne = denne.høyre;
      } else if (x == denne.v2) {
        return true;
      } else {
        denne = denne.midt;
      }
    } else {
      denne = denne.midt;
    }
  }
  return false;
}

boolean erTre(treNode rot) {
  if (rot == null) {
    return true;
  }
  // bladnode?
  if(rot.antallVerdier == 1 && rot.venstre == null && rot.høyre == null) {
    rot.hoyde = 0;
    return true;
  }
  if(rot.antallVerdier == 2 && rot.venstre == null && rot.midt == null && rot.høyre == null) {
    rot.hoyde = 0;
    return true;
  }
  // ikke bladnode, mangler ett av barna?
  if(rot.antallVerdier == 1 && (rot.venstre == null || rot.høyre == null) ) {
    return false;
  }
  if(rot.antallVerdier == 2 && (rot.venstre == null || rot.midt == null || rot.høyre == null) ) {
    return false;
  }
  // indre node
  if(!erTre(rot.venstre) || !erTre(rot.midt) || (rot.antallVerdier == 1 || !erTre(rot.høyre))) {
    return false;
  }
  // alle subtrær er b trær
  if (rot.antallVerdier == 1 && rot.venstre.hoyde == rot.midt.hoyde) {
    rot.hoyde = rot.venstre.hoyde + 1;
    return true;
  }
  if (rot.antallVerdier == 2 && rot.venstre.hoyde == rot.midt.hoyde && rot.midt.hoyde == rot.høyre.hoyde) {
    rot.hoyde = rot.venstre.hoyde + 1;
    return true;
  }
  return false;
}
```

## Oppgave 4
```java
class eksamenOppg4 {

  class HashNode {
    int data;
    HashNode neste;
    public HashNode(int data, HashNode h) {
      this.data = data;
      this.neste = h;
    }
  }

  HashNode[] hashtabell;
  int hashLengde;

  int hash(int i) {
    // hashfunksjon, ikke implementert
    return 0;
  }

  int nextPrime(int n) {
    // returnerer minste heltall stærre eller lik n,
    // ikke implementert
    return 0;
  }

  public void sortList(int Arr[]) {
    // sorterer en lenket liste med heltall, returnerer peker til start på sortert liste
    // ikke implementert
    return null;
  }

  public void insert(int data) {
    // setter inn et heltall i hashtabell med kjeding
    int index = hash(data);
    hashTabell[index] = new HashNode(data, HashTabell[index])
  }

  void hashTableSort(int A[]) {
    // sorterer en array med heltall i lineær tid hvis
    // 1) hashfunksjonen "grovsorterer" som angitt i oppgaven
    // 2) hashfunksjonen sprer jevnt, slik at alle de lenkede
    // som brukes i hashing med kjede er korte.
    int n = A.length;
    // velger hashlengde lik minste neste primtall større eller lik n
    hashLengde = nextPrime(n);
    hashTabell = new HashNode[hashLengde];
    // setter alle heltallene i hashtabell: O(n)
    for (int i = 0; i < n; i++) {
      insert(A[i]);
    }
    // legger tallene sortert tilbake i arrayen O(n)
    int arrayIndex = 0;
    for (int i = 0; i < hashLengde; i++) {
      hashNode sortert = sortList(hashTabell[i]);
      while(sortert != null) {
        A[arrayIndex] = sortert.data;
        sortert = sortert.neste;
        arrayIndex++;
      }
    }
  }
}
```