```java
int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
snu(A);
for (int i = 0; i < A.length; i++) {
  System.out.print(A[i] + " ");
}
System.out.println();

// 9 8 7 6 5 4 3 2 1
```


```java
// a
void snu(int A[]) {
  int n = A.length;
  int B[] = new int[n];

  for (int i = 0; i < n; i++) {
    B[i] = A[i];
  }

  for (int i = 0; i < n; i++) {
    A[i] = B[n - i - 1];
  }
}

// b
void snu(int A[]) {
  int n = A.length, nedre, ovre, temp;

  for (int nedre = 0, ovre = n-1; nedre < ovre; nedre++, ovre--) {
    temp = A[nedre];
    A[nedre] = A[ovre]
    A[ovre] = temp;
  }
}

// c
void snuInt(int A[]) {
  snuRek(A, 0, A.length - 1);
}

void snuRek(int A[], int nedre, int ovre) {
  if (nedre >=ovre) {
    return;
  }
  int temp = A[nedre];
  A[nedre] = A[ovre];
  A[ovre] = temp;
  snuRek(A, nedre + 1, ovre - 1);
}

// d
void snuInt(int A[]) {
  int n = A.length;
  intStack s = new intStack(n);

  for (int i = 0; i < n; i++) {
    s.push(A[i]);
  }

  for (int i = 0; i <n; i++>) {
    A[i] s.pop();
  }
}

// e
void snuInt(int A[]) {
  int n = A.length;
  intQueue q = new intQueue();

  for (int i = 0; i < n; i++) {
    q.enqueue(A[i]);
  }

  int i = n-1;
  while(!q.isEmpty()) {
    A[i] = q.dequeue();
    i--;
  }
}

```

## Oppgave 2
```java
public int finn(int A[], int verdi) {
  int index;
  int n = A.length;

  for (index = 0; index < n; index++) {
    if (A[index] == verdi) {
      return index;
    }
  }
  return -(index + 1);
}
```