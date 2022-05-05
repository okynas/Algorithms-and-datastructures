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