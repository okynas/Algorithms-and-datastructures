# 5.2: Øvingsoppgaver

Alle oppgavene her gir trening i bruk av rekursiv tankegang og programmering. Hvis du synes rekursjon er vanskelig å forstå, anbefales du sterkt å løse noen av disse oppgavene på egenhånd. Den eneste måten å lære rekursiv koding på er å lage enkle programmer selv, se at det fungerer, og dermed mestre det. De som har tid og overskudd kan gjerne gjøre så mange som mulig av lærebokas oppgaver i tillegg.

## Oppgave 1

Skriv om palindromprogrammet (Lenker til en ekstern side.) fra uke 3 slik at det bruker en rekursiv funksjon til å sjekke om en tekststreng er et palindrom (Lenker til en ekstern side.).

## Oppgave 2

La S(n) betegne summen av de n første naturlige tallene 1, 2, 3, ..., n. Skriv tre metoder (funksjoner) som beregner S(n) på følgende måter:

    Skriv en enkel for-løkke som beregner S(n) = 1 + 2 + 3 + ... + n.

    Bruk den rekursive definisjonen:

      S(0) = 0   og
      S(n) = n + S(n-1).

    Bruk formelen S(n) = n · (n+1)/2

Hvilken av disse tre metodene er lettest å programmere? Hvilken er lettest å forstå for en som ikke kan noe matematikk? Hvilken er raskest for store verdier av n?

## Oppgave 3

- Anta at Java ikke har noen innebygget multiplikasjonsoperator (*), men kun addisjon (+). Skriv en rekursiv metode som har som argumenter to ikke-negative heltall m og n, og som returnerer produktet m · n beregnet ved rekursiv addisjon.
- Anta at Java ikke har noen innebygget addisjonsoperator (+), men kun inkrement (++). Skriv en rekursiv metode som har som argumenter to ikke-negative heltall m og n, og som returnerer summen m + n beregnet ved rekursivt inkrement.

## Oppgave 4

De såkalte binomialkoeffesientene C(n, m) er en rekke med tall som kan defineres rekursivt ved:

    C(n, 0) = 1 og C(n, n) = 1, 	for n >= 0
    C(n, m) = C(n-1, m) + C(n-1, m-1), 	for 0 < m < n

Skriv en rekursiv metode som beregner C(n, m) etter formelen ovenfor.

Tegn en figur (et såkalt kalltre) som viser alle de rekursive metodekallene for metoden fra punkt 1 når den beregner C(6, 4).

Test metoden din ved å lage et program som leser inn verdier for n og m og deretter bruker metoden til å beregne binomialkoeffesienten.

## Oppgave 5

Ackermanns funksjon, A, som er definert nedenfor, brukes ofte i testprogrammer for å finne ut hvor godt rekursjon er implementert i en kompilator:

    A(0, n) = n + 1, 	for n >= 0
    A(m, 0) = A(m-1, 1), 	for m > 0
    A(m, n) = A(m-1, A(m, n-1)), 	for m > 0 og n > 0

    Beregn A(2, 3) for hånd. Hvor mange ganger må Ackermann's funksjon beregnes for å regne ut denne verdien?

Lag en rekursiv metode som beregner A(m, n). Lag et lite testprogram som leser inn m og n og bruker metoden til å regne ut A(m, n). Hvor store verdier av m og n klarer metoden din før du har brukt opp all tilgjengelig hukommelse i maskinen (evt. før den crasher)?

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

## Oppgave 7

Skriv en rekursiv metode:

````java
public void snu(String s, int n);
````

som skriver ut tegnene i tegnstrengen s i omvendt rekkefølge til standard output (skjermen). Parameteren n angir lengden (eller antall tegn) i s. Hvis f.eks. s inneholder "grebiøH", skal metoden skrive ut "Høiberg".

Skriv en rekursiv metode med samme argumenter som metoden i punkt 1, som skriver ut alle mulige uordnete utvalg (eller kombinasjoner) av 2 tegn fra den gitte tegnstrengen. For f.eks. strengen ACEG skal det skrives ut:

      AC AE AG CE CG EG 

Klarer du å lage en iterativ variant av denne metoden?

## Oppgave 8

Skriv en rekursiv metode som reverserer (snur om rekkefølgen på) elementene i en array x av lengde n. Funksjonen skal flytte delvektoren

    x[1, 2, 3, ..., n-1]

et "hakk" nedover, til delvektoren

    x[0, 1, 2,..., n-2]

    x[0] blir da satt lik x[1], x[1] blir satt lik x[2] osv. Deretter skal den "gamle" verdien av x[0] lagres i x[n-1]. Rekkefølgen av elementene i delvektoren:

    x[0, 1, 2,..., n-2]

skal så snus om med et rekursivt kall.