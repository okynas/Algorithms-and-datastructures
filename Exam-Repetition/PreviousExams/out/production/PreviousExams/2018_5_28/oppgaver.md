# Eksamen 2018

## Oppgave 1 + 2 + 3
![image.png](image.png)
![image2.png](image2.png)
![image3.png](image3.png)
![image4.png](image4.png)
![image5.png](image5.png)


## Oppgave 4

![image6.png](image6.png)
![image7.png](image7.png)
![image8.png](image8.png)

```java
private int countOdd(treeNode r)  {
  if (r == null) {
    return 0;
  }

  int odd = 0;

  if (r.value % 2 != 0) {
    odd = 1;
  }
  return (odd + countOdd(r.left) + countOdd(r.right));
}

/*
a skal være mindre enn b

skrive ut alle verdiene i søketreet som er større eller lik a og mindre eller lik b, sortert rekkefølge
eks a): print(4,9): 4 5 6 7 7 8

kalle hjelpefuinksjon printRange(treeNode r, itn a , int b) <- denne gjør utskriften

skal være rekursiv
*/
private void printRange(treeNode r, int a, int b) {
  if (r == null)
    return 0;

  if (a < r.value)
    printRange(r.left, a, b);

  if (a <= r.value && r.value <= b)
    System.out.println(r.value + " ");

  if (b >= r.value)
    printRange(r.right, a, b);

}

public void cornerNodes(treeNode r) {
  // returnerer hvis treet er tomt
  if (r == null) {
    return 0;
  }
  // oppretter en tom kø som kan lagre noder i treet.
  Queue q = new Queue();
  q.enqueue(r);

  while(!q.isEmpty()) {
    // alle noder i dette nivået ligger nå i køen
    // antall noder er lik køens lengde
    int size = Q.size();
    int n = size;

    // tar ut nodene på dette nivået ut av køen.
    while (n>0) {
      treNode node = q.dequeue();
      n--;
      // skriver ut hvis noden er hjørne node (første eller siste noden på dette nivået)
      if (n == size - 1 || n == 0) {
        System.out.println(node.value);
      }
      // legger nodens venstre og høyre barn i kø
      if (node.left != null) {
        q.enqueue(node.left);
      }
      if (node.right != null) {
        q.enqueue(node.right);
      }
    }
    System.out.println();
  }
}



```

