
# 3.3: Øvingsoppgaver
## Oppgave 1
Skriv om palindromprogrammet fra uke 3 slik at det bruker en stack og en kø til å finne ut om en tekststreng er et [palindrom](http://no.wikipedia.org/wiki/Palindrom). Programmet skal først legge alle tegnene både på stacken og i køen, og skal deretter sjekke om tegnene utgjør et palindrom.

Palindromprogram:
```java
import java.io.*;
import java.util.Scanner;

// Bruker lÃ¦rebokas stack-modul. Last ned koden til egen maskin,
// legg den i en underkatalog "jsjf" og kompiler

import jsjf.ArrayStack;

public class uke_3_2
{
    public static boolean erPalindrom(String line)
   /**
     * Sjekker om en tegnstreng er et et palindrom. Litt fancy
     * versjon som ignorerer bÃ¥de space og smÃ¥/store bokstaver
     */
    {
	ArrayStack<Character> stack = new ArrayStack<Character>();

	// GjÃ¸r om til smÃ¥ bokstaver og fjerner all whitespace
	line = line.toLowerCase();
	line = line.replaceAll("\\s","");

        // Legger tegnene pÃ¥ en stack

	for (int i = 0; i < line.length(); i++)
	    stack.push(new Character(line.charAt(i)));

	// Sjekker om lest linje er er palindrom

	int i = 0;
	while (!stack.isEmpty())
	    if (line.charAt(i++) != stack.pop())
		return false;
	return true;
    }

    public static void main(String[] args)
   /**
     * Leser en linje fra standard input, sjekker om tegnene utgjÃ¸r
     * et palindrom.
     */
    {
	String line;
	Scanner in = new Scanner(System.in);

	System.out.print("? ");
	line = in.nextLine();

	if (erPalindrom(line))
	    System.out.println("'" + line + "' er et palindrom");
	else
	    System.out.println("'" + line + "' er ikke et palindrom");
    }
}
```

NB!: Kan bruke arraystack fra tidligere moduler, eller innebygd i java.

## Oppgave 2
Skriv om koden for simulering av et postkontor (Lenker til en ekstern side.) slik at det brukes flere køer. Det skal nå være en kø av kunder foran hver kasse. Nyankomne kunder vil alltid stille seg i den korteste køen. Test programmet og se om det blir noen forskjell i ventetider i forhold til simuleringen med bare én kundekø.

## Oppgave 3
Lag et program som implementerer den enkle sorteringsmetoden "counting sort". Du kan gjerne ta utgangpunkt i koden for radixsortering (Lenker til en ekstern side.).

## Oppgave 4
Skriv om koden for radixsortering (Lenker til en ekstern side.) slik at programmet sorterer tegnstrenger alfabetisk, i stedet for heltall. Du kan anta at strengene kun inneholder de 26 bokstavene fra det engelske alfabetet.

## Oppgave 5
Radixsortering kan implementeres uten bruk av køer. En mulig løsning er å bruke en ekstra array ay lengde n og en array av lengde 10, og telle opp antall forekomster av alle sifrene 0-9 i hvert gjennomløp. Her er en visualisering av denne metoden (Lenker til en ekstern side.). Skriv om koden for radixsortering (Lenker til en ekstern side.) av heltall slik at den bruker denne metoden i stedet for å legge tallene i 10 køer.
