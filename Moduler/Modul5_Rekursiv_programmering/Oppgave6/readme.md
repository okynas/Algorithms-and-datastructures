## Oppgave 6

Hva blir skrevet ut ved kjøring av følgende program? Hva beregnes av metoden strange?

```java
public class oppgave6 {
  public static void main(String args [])
  {
    System.out.println( strange(8) );
  }

  public static int strange(int n)
  { 
    if (n == 1) 
      return 0; 
    else 
      return 1 + strange(n / 2);
  }
}
```
Hva tror du utføres av følgende rekursive metode?

```java
public int mystery(int x[], int n) 
{ 
  int tmp; 

  if (n == 1) 
    return x[0]; 
  else 
  { 
    tmp = mystery(x, n - 1);
 
    if (x[n-1] < tmp) 
      return x[n-1] ; 
    else 
      return tmp; 
  }
}
```

## Svar

a.

strange(8) 
= 1 + strange(4)
= 1 + strange(2)
= 1 + strange(1)
= 0

= 1+1+1+0 = 3
x^3 = 8 => x = 2

Dette er 2'er logaritmen til 8. 2^3=8

b.

mystery(int x = [1,2,3,4,5], 5)

finner minste element i lista / vektoren.