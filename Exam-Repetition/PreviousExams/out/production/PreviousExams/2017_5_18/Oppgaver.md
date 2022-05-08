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

  while (index < 0 && A[i] < verdi) {
    index++;
  }
  if (i < n && A[i] == verdi) {
    return index;
  }
  return -(index + 1);
}

public static int finn2(int A[], int verdi) {
  int nedre = 0, ovre = A.length, midt = 0, midtverdi = 0;
  boolean ferdig = false;

  while (nedre <= ovre && !ferdig) {
    midt = (nedre+ovre)/2;
    midtverdi = A[midt];

    if (verdi > midtverdi) {
      nedre = midt+1;
    } else if(verdi < midtverdi) {
      ovre = midt - 1;
    }
    else {
      ferdig = true;
    }
  }

  if (nedre > ovre) {
    return -(nedre+1);
  }

  while(midt > 0 && A[midt - 1] == verdi) {
    midt--;
  }
  return midt;

}
```

## Oppgave 3c
```java
public int min() {
  // ingen noder i treet.
  if (isEmpty()) {
    return 0;
  }
  node current = rot;
  while (current.left != null) {
    current = current.left;
  }

  return current.value;
}
```

## Oppgave 3f

```java
public void insert(int value){
  numNodes++;
  if (root == null){
    root = new node(value);
    height = 0; // 3f
    return;
  }
  node current = root, parent = null;
  int level = 0; // 3f
  while (current != null){
    parent = current;
    current = value < parent.value ? parent.left : parent.right;
    level++; // 3f
  }
  current = new node(value);
  if (value < parent.value) {
    parent.left = current;
  } else {
    parent.right = current;
  }

  if (level > height) { // 3f
    height = level; // 3f
  }
}
```

## 3h
```java
public void lowestLevel() {
  lowestLevelRek(rot, 0);
  System.out.println();
}

private void lowestLevelRek(node r, int level) {
  if (r == null) {
    return;
  }

  lowestLevelRek(r.left, level + 1);
  if (level == height) {
    System.out.println(r.value + " ");
  }

  lowestLevelRek(r.right, level + 1);
}
```

## 4a
    a:    b:  c:    d:    e:    f:
a:  0     *   *     *     0.1   0.9
b:  0.3   0   0.3   0.4   *     *
c:  *     *   0     0.6   0.4   *
d:  *     *   *     0     1     *
e:  0.55  *   *     *     0     0.45
f:  *     *   *     1     *     0

## 4b
    a:    b:  c:    d:    e:    f:
a:  0     *   *     1.55  0.1   0.55
b:  0.3   0   0.3   0.4   0.4   0.85
c:  0.95  *   0     0.6   0.4   0.85
d:  1.55  *   *     0     1     1.45
e:  0.55  *   *     1.45  0     0.45
f:  2.55  *   *     1     2     0

## 4c
korteste vei til gjeldende node er markert med *
noder som ikke er oppsøkt er markert med -

steg    a:    b:    c:    d:    e:    f:
1:      0.3   0*    0.3   0.4   -     -
2:      0.3*  0*    0.3   0.4   0.4   1.2
3:      0.3*  0*    0.3*  0.4   0.4   1.2
4:      0.3*  0*    0.3*  0.4*  0.4   0.85
5:      0.3*  0*    0.3*  0.4*  0.4*  0.85*