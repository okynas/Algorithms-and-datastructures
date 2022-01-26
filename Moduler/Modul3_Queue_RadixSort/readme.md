
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
Skriv om koden for simulering av et postkontor slik at det brukes flere køer. Det skal nå være en kø av kunder foran hver kasse. Nyankomne kunder vil alltid stille seg i den korteste køen. Test programmet og se om det blir noen forskjell i ventetider i forhold til simuleringen med bare én kundekø.

#### Postkontoret:
```java
import java.io.*;
import java.util.*;

/* Tidssdrevet simulering av aktiviteten pÃ¥ et postkontor:
 *
 * - Alle kundene som ankommer stiller seg i en og samme kundekÃ¸
 * - Det kommer maksimalt Ã©n ny kunde per tidsenhet, sannsynligheten
 *   for kundeankomst er den samme i alle tidsteg
 * - Det er et fast antall kasser/betjeningsluker
 * - Det er en Ã¸vre grense for betjeningstiden for en kunde
 * - Brukes Javas egen innebygde kÃ¸ 
 */

public class postkontor
{
    int    antKasser;  // Antall Ã¥pne kasser/betjeningsluker
    int    maksBetTid; // Maksimal betjeningstid for en  kunde
    int    maksTid;    // Antall tidssteg som simuleringen skal gÃ¥
    float  P_kunde;    // Sannsynligheten for kundeankomst i hvert tidssteg
    
    // KonstruktÃ¸r som leser data/parametre for simuleringen
    public postkontor(String navn)
    {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Velkommen til " + navn + " postkontor");
	System.out.print("Antall tidsteg?: ");
	maksTid = scanner.nextInt();
	System.out.print("Antall kasser?: ");
	antKasser = scanner.nextInt();
	System.out.print("Lengste betjeningstid?: ");
        maksBetTid = scanner.nextInt();
	System.out.print("Gj.snittlig antall kundeankomster per tidsenhet? (< 1.0): ");
	P_kunde = scanner.nextFloat();
    }

    // Indre klasse som lagrer ankomsttiden for en kunde
    private class kunde
    {
	private int ankomst;
	public kunde(int ankomst) { this.ankomst = ankomst; }
	public int venteTid(int tid) { return tid - ankomst; }
    }        

    // Indre klasse som lagrer tidspunktet nÃ¥r en kasse blir ledig
    private class kasse
    {        
	private int tidFerdigKunde; 
      	public kasse() { tidFerdigKunde = 0; }
	public void settTidFerdigKunde(int tid) { tidFerdigKunde = tid; }    
	public boolean erLedig(int tid) { return tid >= tidFerdigKunde; }
    }

    // Metode som gjÃ¸r selve kÃ¸simuleringen
    public void simuler()
    {
	// Variable for Ã¥ samle opp data underveis i simuleringen
	//
	int totalBetTid   = 0; // Sum betjeningstid for alle betjente kunder
	int totalVenteTid = 0; // Sum ventetid for alle betjente kunder
	int totAntKunder  = 0; // Totalt antall kunder betjent
	int totAntledig   = 0; // Totalt antall ganger en kasse var ledig

	// Lager en ny, tom KundeKÃ¸
	Queue<kunde> KundeKÃ¸ = new LinkedList<kunde>();

	// Oppretter en array som lagrer alle Ã¥pne kasser
	kasse[] kasser = new kasse[antKasser];
	
	// Setter alle kassene til Ã¥ vÃ¦re ledige
	for (int i = 0; i < antKasser; i++)
	    kasser[i] = new kasse();

	// Initierer trekkingen av tilfeldige tall
        Random R = new Random(); 
            
	// Simulerer et og et tidssteg 
	for (int tid = 0; tid < maksTid; tid++)
	{
	    // Trekker nytt tilfeldig tall. Hvis tallet som trekkes er
	    // mindre enn sannsynligheten for ny kunde (P_kunde),
	    // settes en ny kunde inn i kÃ¸en
	    if (R.nextDouble() < P_kunde)
		KundeKÃ¸.add(new kunde(tid));

	    // Tar ut Ã©n kunde fra kÃ¸en for hver ledige kasse
	    for (int i = 0; i < antKasser; i++)
		if (kasser[i].erLedig(tid))
		{
		    if (!KundeKÃ¸.isEmpty())
		    {
			// Trekk en tilfelding betjeningstid
			int betTid = R.nextInt(maksBetTid) + 1; 

			// Tar ut kunde fra kÃ¸
			kunde k = KundeKÃ¸.remove();

			// Markerer at kassen er opptatt
			kasser[i].settTidFerdigKunde(tid + betTid);

			// Samler opp data fra dette tidssteget
			totalBetTid += betTid;
			totalVenteTid += k.venteTid(tid);
			totAntKunder++;
		    }
	            else
			// KÃ¸en er tom og vi har en ledig kasse
			totAntledig++;
		}
	}
        
	// Simulering ferdig, skriv ut litt statistikk
	System.out.println("\nPostkontoret er nÃ¥ stengt");
	System.out.println("Antall kunder behandlet: " + totAntKunder);
	System.out.println("Antall kunder i kÃ¸: " + KundeKÃ¸.size());
	if (totAntKunder > 0)
	{
	    System.out.println("Gjennomsnittlig betjeningstid: " +
			       (float) totalBetTid / (float) totAntKunder);
	    System.out.println("Gjennomsnittlig ventetid: " +
			       (float) totalVenteTid / (float) totAntKunder);

	}
	System.out.println("Gjennomsnittlig antall ledige kasser: " +
			   (float) totAntledig / (float) maksTid );
	
     }
    
    // Testprogram
    public static void main(String[] args)
    {
	postkontor pk = new postkontor("Remmen");
	pk.simuler();
    }

}
```

## Oppgave 3
Lag et program som implementerer den enkle sorteringsmetoden "counting sort". Du kan gjerne ta utgangpunkt i koden for radixsortering

#### Radix Sort inspirasjon:
```java
import jsjf.CircularArrayQueue;
import java.util.Random;

public class radixSort
{
    void sort(int a[], int maksAntSiffer)
    {
	// Radixsortering av en array a med desimale heltall
	// maksAntSiffer: Maksimalt antall siffer i tallene

	int ti_i_m = 1; // Lagrer 10^m 
	int n = a.length;

	// Oppretter 10 tomme kÃ¸er 
	CircularArrayQueue<Integer>[] Q = 
	    (CircularArrayQueue<Integer>[])(new CircularArrayQueue[10]);

	for (int i = 0; i < 10; i++)
	    Q[i] = new CircularArrayQueue<Integer>(); 
            
	// Sorterer pÃ¥ et og et siffer, fra hÃ¸yre mot venstre

	for (int m = 0; m < maksAntSiffer; m++)
	{
	    // Fordeler tallene i 10 kÃ¸er
	    for (int i = 0; i < n; i++)
	    {
		int siffer = (a[i] / ti_i_m) % 10;
		Q[siffer].enqueue(new Integer(a[i]));
	    }

	    // TÃ¸mmer kÃ¸ene og legger tallene fortlÃ¸pende tilbake i a
	    int j = 0;
	    for (int i = 0; i < 10; i++)
		while (!Q[i].isEmpty())
		    a[j++] = (int) Q[i].dequeue();

	    // Beregner 10^m for neste iterasjon
	    ti_i_m *= 10;
	}
    }
        
    public static void main(String[] args)
    {
	// Leser antall tall og antall siffer fra kommandolinja
	int n = Integer.parseInt(args[0]);
	int m = Integer.parseInt(args[1]);

        // Beregner maks.verdi for tallene som skal sorteres
	int ti_i_m = (int) java.lang.Math.pow(10,m);
	int a[] = new int[n];
        Random R = new Random(); 

	// Fyller array med tilfeldige tall mellom 0 og 10^m - 1 
	for (int i = 0; i < n; i++)
	    a[i] = R.nextInt(ti_i_m); 

	// Sorterer
	radixSort rS = new radixSort();
	rS.sort(a, m);
	
	// Skriver ut sortert array formatert i kolonner
	int linjebredde = 80;
	int tall_pr_linje = linjebredde/(m + 1);
	for (int i = 0; i < n; i++)
	{
	    String format = "%" + m + "d ";
	    System.out.printf(format, a[i]);
	    if (((i+1) % tall_pr_linje == 0) || (i == n - 1))
		System.out.println();
	}
    }

}
```

## Oppgave 4
Skriv om koden for radixsortering slik at programmet sorterer tegnstrenger alfabetisk, i stedet for heltall. Du kan anta at strengene kun inneholder de 26 bokstavene fra det engelske alfabetet.

#### Radixsortering:
Kodesnutten ovenfor ^^.

## Oppgave 5
Radixsortering kan implementeres uten bruk av køer. En mulig løsning er å bruke en ekstra array ay lengde n og en array av lengde 10, og telle opp antall forekomster av alle sifrene 0-9 i hvert gjennomløp. Her er en visualisering av denne metoden (Lenker til en ekstern side.). Skriv om koden for radixsortering (Lenker til en ekstern side.) av heltall slik at den bruker denne metoden i stedet for å legge tallene i 10 køer.
