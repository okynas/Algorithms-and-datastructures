## Oppgave 3a
     42
   /    \
  17    19
  / \
 36 29

     17
   /    \
  42    19
  / \
 36 29

     17
   /    \
  29    19
  / \
 36 42

## Oppgaev 3b
```java
/**
finner den siste noden i binærheapen med rota root,
sletter denne fra treet,
og returner verdien i noden som slettes.

«Siste node» er den siste noden som vil bli besøkt i en level-order
traversering.

(Hint: Hvis vi tenker en level-order rekkefølge, er foreldren til den siste
noden forløperen til den første noden som har ingen barn, eller noden som bare har
ett barn).

*/
int deleteLast (TreeNode root) {
  int value = 0;
  if (root == null) {
    // feilhåndtering
    System.out.println("Kan ikke fjerne roten, ettersom roten ikke eksisterer");
    return value;
  }

  if (root.left == null) {
    // vi har bare en node i treet, spesialtilfelle som må håndteres før metoden kalles
    // feilhåndtering
    value = root.value; //?
    root.value = null; // ?
    return value;
    // return root.value;
  }

  Queue<TreNode> q = new LinkedList<TreeNode>();
  q.add(root);
  TreeNode prev = null;
  while(!q.isEmpty()) {
    TreeNode current = q.remove();
    // kun ett barn, i venstre subtre
    if (current.right == null && current.left != null) {
      value = current.left.value;
      current.left = null;
      break;
    }

    // ingen barn i treet
    if (current.left == null) {
      value = prev.right.val;
      prev.right = null;
      break;
    }

    if (current.left != null) {
      q.add(current.left);
    }

    if (current.right != null) {
      q.add(current.right);
    }
    prev = current;
  }

  return value;

}
```

## Oppgace 3c
```java
int removeMin (TreeNode root) {
  // Implementeres i 3C
  // Returnerer verdien i rota i minHeapen representert ved root
  // Verdien i den siste noden kopieres til rota,
  // og den siste noden slettes
  // Deretter repareres minHeapen
  if (root == null) {
    // feilhåndtering
    System.out.println("Kan ikke fjerne minste element, fordi roten ikke eksisterer");
    return 0;
  }
  if (root.left == null) {
    // spesialtilfelle, kun roten er i heapen.
    // feilhåndtering
    root = null; // ?
    return 0;
  }
  int val = root.val;
  root.val = deleteLast(root);

  TreeNode current = root;
  while(current.left != null) {
    TreeNode smallest;
    if (current.right == null) {
      smallest = current.left;
    } else {
      smallest = current.left.val < current.right.val ? current.left : current.right;
    }
    if (smallest > current.val) {
      return val;
    }
    int temp = current.val;
    current.val = smallest.val;
    smallest.val = temp;

    current = smallest;
  }
  return val;
}

```

## Oppgave 4a+b
```java
public String crack(char[] message, int[] key) {
  String s = "";
  for (int i = 0; i < key.length; i++) {
    s+=message[key[i]];
  }
  return s;
}

String guess(char[] message) {
  // lager liste med alle permutasjonene av nøkler
  List<int> keys = foo(message.length);
  for(int[] key: keys) [
    System.out.println(crack(message, key));
  ]
}
```