# 8.4: Øvingsoppgaver

### Oppgaver
- [x] Oppgave 1
- [x] Oppgave 2
- [x] Oppgave 3
- [x] Oppgave 4
- [ ] Oppgave 5

## Oppgave 1
Følgende binære tre er gitt:

             A
            / \
           B   C
          / \   \
         /   \   \
        /     \   \
       D       E   F
      / \     / \   \
     G   H   I   J   K
            / \
           L   M
1. Hvilken node er rotnoden?  = A
2. Hvilke noder er blader i treet? = GHLMJK 
3. Hva er høyden til treet? = 4
4. Angi rekkefølgen som nodene oppsøkes i ved hhv. preorder, inorder, postorder og bredde-først traversering.
   1. ABDGHEILMJCFK
   2. GDBHLIMEJACFK
   3. GHDLMIJHBKFCA
   4. ABCDEFGHIJKLM

## Oppgave 2
Følgende binære tre er gitt:

             A
            / \
           B   C
          / \   \
         /   \   \
        /     \   \
       D       E   F
      / \     / \   \
     G   H   I   J   K
            / \
           L   M

Angi, for hver node/hvert subtre i dette treet:

- a. Foreldernoden 
- b. Barn 
- c. Søsken 
- d. Høyde 
- e. Størrelse (antall noder i subtreet med rot i denne noden)

```markdown
Node   a    b      c     d     e
---------------------------------
A     *    B C    *     4     13
B     A    D E    C     3     9
C     A    F      B     2     3
D     B    G H    E     1     3
E     B    I J    D     2     5
F     C    K      *     1     2
G     D    *      *     0     1
H     D    *      *     0     1
I     E    L M    J     1     3
J     E    *      I     0     1
K     F    *      *     0     1
L     I    *      M     0     1
M     I    *      L     0     1
---------------------------------
*: Ingen
``` 

## Oppgave 3
Hva skrives ut når følgende rekursive metode

```java

public void mysteryPrint(BinaryNode t) {
    if (t != null)
    {
       System.out.print(t.element);
       mysteryPrint(t.left);
       System.out.print(t.element);
       mysteryPrint(t.right);
       System.out.print(t.element);
    }
}

```

brukes på følgende binære tre?

            a
           / \
          /   \
         /     \
        b       c
         \     /
          d   e

Vi antar at den kalles med en referanse til roten i dette treet, og at variabelen "element" i hver node inneholder et enkelt tegn som i figuren.

### SVAR:

    abbdddbaceeecca

## Oppgave 4
Nodene i et binært tre inneholder bare et enkelt heltall, samt referanser til høyre og venstre barn:

```java

class treNode {
   int data;
   treNode venstre, hoeyre;

   public treNode(int n)
   {
      data = n;
      venstre = hoeyre = null;
   }
}

```

Programmer følgende rekursive metoder:

```java

int antallBlader(treNode rot)
{
// Returnerer antall blader i et tre med en gitt rot
}

int antallMedEttBarn(treNode rot)
{
  // Returnerer antall noder med bare ett barn
  // i et tre med en gitt rot
}

int antallMedToBarn(treNode rot)
{
  // Returnerer antall noder med to barn (fulle noder)
  // i et tre med en gitt rot
}

```

Lag også et lite testprogram som sjekker at metodene fungerer.

## Oppgave 5
Nodene i et binært tre der dataene er enkle tegn er beskrevet slik:

```java

public static class treeNode
{
    char data;
treeNode left, right;

    public treeNode(char c, treeNode l, treeNode r)
    {
       data = c;
       left = l;
       right = r;
    }	
}

```
Lag en rekursiv metode som kopierer et helt binært tre med enkle tegn. Metoden skal ha som parameter en peker/referanse til roten i treet, og skal returnere en peker til roten i det kopierte treet. Hva er arbeidsmengden til denne metoden for et tre som inneholder n noder?