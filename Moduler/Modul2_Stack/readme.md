
# 2.2: Øvingsoppgaver
## Oppgave 1

La S være en stack der dataene f.eks. kan være enkle heltall. Bruk operasjonene pop, push, peek og isEmpty i lærebokas stack-modul (Lenker til en ekstern side.) til å lage metoder som utfører følgende operasjoner:

* Returner innholdet av tredje element på S, telt fra toppen av stacken. Hvis S inneholder mindre enn 3 elementer, returneres null. Innholdet av S skal ikke være forandret når funksjonen terminerer.
* Returner innholdet av elementet på bunnen av S. Hvis S er tom, returneres null. S skal ikke være forandret ved terminering. Her må(?) det brukes en ekstra stack. 
* Fjern alle elementer på S som har verdi lik x. De resterende elementene på S skal ligge i uforandret rekkefølge.

## Oppgave 2
Skriv om eksempelprogrammet fra forelesning som reverserer tekststrenger, slik at programmet i stedet bruker en stack til å sjekke om den innleste strengen er et palindrom (Lenker til en ekstern side.).

Kode fra oppgavesett:
```java
import java.io.*;
import java.util.Scanner;

// Bruker lÃ¦rebokas stack-modul. Last ned koden til egen maskin,
// legg den i en underkatalog "jsjf" og kompiler. Husk Ã¥ legge bÃ¥de
// stÃ¥ende katalog og forelderkatalog pÃ¥ CLASSPATH slik at Java-
// kompilatoren finner modulene som inkluderes

import jsjf.ArrayStack;

public class snuInput
{
    public static void main(String[] args)
    {
        ArrayStack<Character> stack = new ArrayStack<Character>();

        Character c;
        int l;
        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine();
        l = line.length();

        for (int i = 0; i < l; i++)
            stack.push(new Character(line.charAt(i)));

        while (!stack.isEmpty())
        {
            c = stack.pop();
            System.out.print(c);
        }
        System.out.println();

    }
}
```
jsjf.ArrayStack kode:

```java
import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T>
{
    private final static int DEFAULT_CAPACITY = 100;

    private int top;
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array
     */
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the array if necessary.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        if (size() == stack.length)
            expandCapacity();

        stack[top] = element;
        top++;
    }

    /**
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it.
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        top--;
        T result = stack[top];
        stack[top] = null;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top-1];
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        return (top == 0);
    }

    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return top;
    }

    /**
     * Returns a string representation of this stack.
     * @return a string representation of the stack
     */
    public String toString()
    {
        // To be completed as a Programming Project
        return " ";
    }
}
```

```java
/**
 * Defines the interface to a stack collection.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public interface StackADT<T>
{
    /**
     * Adds the specified element to the top of this stack. 
     * @param element element to be pushed onto the stack
     */
    public void push(T element);

    /**
     * Removes and returns the top element from this stack. 
     * @return the element removed from the stack
     */
    public T pop();

    /**
     * Returns without removing the top element of this stack. 
     * @return the element on top of the stack
     */
    public T peek();

    /**
     * Returns true if this stack contains no elements. 
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack. 
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    public String toString();
}
```

## Oppgave 3
Skriv om den enkle stack-modulen for heltall slik at den håndterer feil på en fornuftig måte.

```java
package jsjf;

/* Enkel implementasjon av stack med heltallsarray, uten feilsjekking... */

public class IntStack
{
    private int top, max;  
    private int stack[];

    public IntStack(int length)
    {
	top = 0;
	max = length;
	stack = new int[max];
    }
  
    public void push(int i)
    {
	stack[top] = i;
	top++;
    }

    public int pop()
    {
	top--;
	return(stack[top]); 
    }
   
    public int peek()
    {
	return(stack[top-1]);
    }

    public boolean isEmpty()
    {
        return (top == 0);
    }
 
    public int size()
    {
        return top;
    }
}
```

## Oppgave 4
Skriv om det enkle programmet for beregning av Postfix-uttykk, slik at det også håndterer negative heltallsverdier riktig.

```java
import java.util.Scanner;
import java.util.StringTokenizer;
import jsjf.IntStack;

/* Enkel beregning av postfix regneuttrykk med positive heltall */
/* Regneuttrykk mÃ¥ skrives med space mellom tall og binÃ¦re operatorer */

public class Postfix
{
    public static int beregn(String uttrykk)
    {
	IntStack S = new IntStack(1000);

	char operasjon;
	int operand_1, operand_2, resultat = 0;

 	String token;
	StringTokenizer tokenizer = new StringTokenizer(uttrykk);

	while (tokenizer.hasMoreTokens())
	{
	    token = tokenizer.nextToken();
	    operasjon = token.charAt(0);

	    if (operasjon == '+' || operasjon == '-' ||
		operasjon == '*' || operasjon == '/')
	    {
		operand_2 = S.pop();
		operand_1 = S.pop();

		switch (operasjon)
		{
		    case '+':
			resultat = operand_1 + operand_2;
			break;
		    case '-':
			resultat = operand_1 - operand_2;
			break;
		    case '*':
			resultat = operand_1 * operand_2;
			break;
		    case '/':
			resultat = operand_1 / operand_2;
		}
		S.push(resultat);
	    }
	    else
		S.push(Integer.parseInt(token));
	}
	return S.pop();
    }

    public static void main (String[] args)
    {
	Scanner in = new Scanner(System.in);
	System.out.print("Postfix ? ");
        System.out.println("Resultat: " + beregn(in.nextLine()));
    }
}
```

## Oppgave 5

Skriv et program som oversetter et infix regneuttrykk til postfix med bruk av følgende algoritme:

    1 Lag en ny tom stack S
    2 For alle tegn T i uttrykket:
        2.1 Hvis T er en operand: Skriv ut T
        2.2 Ellers:
            2.2.1 Så lenge T har rang lavere eller lik toppen av S:
            2.2.1.1 Pop S og skriv ut
        2.2.2 Push T på S
    3 Pop resten av S og skriv ut

Du kan anta at:

* Regneuttrykkene har ikke paranteser.
* Uttrykkene inneholder kun de binære operatorene + - * / .
* Alle operander er enkle bokstaver i intervallet a-z.

Programmet skal lese inn et regneuttrykk som dette:

    a+b*c+d/f-e

og deretter skrive ut det tilsvarende postfixutrykket:

    abc*+df/+e-    

