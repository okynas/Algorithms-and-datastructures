## Oppgave 2 a
```java
public void addFirst(int value) {
  head = new node(v, head);
  numNodes++;
}
public int removeFirst() {
  if (numNodes == 0) {
    return -1;
  } else {
    int v = head.value;
    head = head.next;
    numNodes--;
    return v;
  }
}

```

## Oppgave 2b
```java
public void addLast(int value) {
  if (numNodes == 0) {
    head = new node(v, null);
  } else {
    node p = head;
    while(p.hasNext()) {
      p = p.next;
    }
    p.next = new node(v, null);
  }
  numNodes++;
}
public int removeLast() {
  if (numNodes == 1) {
    int v = head.value;
    head = head.next;
    numNodes--;
    return v;
  } else if (numNodes != 0) {
    node p = head;
    while (p.hasNext()) {
      p = p.next;
    }
    int v = p.next.value;
    p.next = null;
    numNodes--;
    return v;
  } else {
    return -1;
  }
}
```

## Oppgave 4a
```java
public boolean insert(int value) {     // Setter inn en ny verdi i treet. Skal skrives
  node p = root, q = null;           // om i oppgave 4 a)
  int cmp = 0;
  while (p != null){
    q = p;
    cmp = value – p.value;

    // LØSNING PÅ 4A
    if (cmp == 0) {
      return false;
    }

    p = cmp < 0 ? p.left : p.right;
  }
  p = new node(value);
  if (empty())
    root = p;
  else if (cmp < 0)
    q.left = p;
  else
    q.right = p;
  n++;
  return true;
}

```

## Oppgave 4b
```java
public int depth(int value) {
  return depth(value, root);
}

private int depth(int value, node p) {
  int diff = 0;
  int distance = 0;
  while (p!= null) {
    diff = value - p.value;
    if (diff == 0) {
      return distance;
    }
    if (diff < 0) {
      p = p.left;
    } else {
      p = p.right;
    }
    distance++;
  }
  return -1;
}
```

## Oppgave 4c
```java
public int distance(int v1, int v2){

  // v2 skal alltid være størst
  if(v1 > v2) {
    int temp = v2;
    v2 = v1;
    v1 = temp;
  }

  node p = rot;
  // så lenge noden ikke er null.
  while(p != null) {
    // v1 og v2 ligger til venster
    if (v2 < p.value) {
      p = p.left;
    }
    // v1 og v2 ligger til høyre
    else if (v1 > p.value) {
      p = p.right;
    }
    // veien deler seg, og dette er
    // forelder-noden til v1 og v2.
    else {
      break;
    }
  }

  // ingen av verdiene finnes
  if (p == null) {
    return -1;
  }
  // avstandene mellom nodene og p
  int distance1 = depth(v1, p);
  int distance2 = depth(v2, p);

  // hvis en av verdiene ikke finnes
  if (distance1 == -1 || distance2 == -1) {
    return -1;
  }
  // avstanden er summ av avstand til
  // nærmeste forgjenger
  return (distance1 + distance2);

}
```