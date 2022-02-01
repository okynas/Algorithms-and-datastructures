import java.io.*;
import java.util.Scanner;

// Bruker lÃ¦rebokas stack-modul. Last ned koden til egen maskin,
// legg den i en underkatalog "jsjf" og kompiler

public class Palindrom {
    /**
     * Sjekker om en tegnstreng er et et palindrom. Litt fancy
     * versjon som ignorerer bÃ¥de space og smÃ¥/store bokstaver
     */
    public static boolean erPalindrom(String line) {
        LinkedUnorderedList<Character> list = new LinkedUnorderedList<>();
        // ArrayStack<Character> stack = new ArrayStack<Character>();

        // GjÃ¸r om til smÃ¥ bokstaver og fjerner all whitespace
        line = line.toLowerCase();
        line = line.replaceAll("\\s", "");

        // Legger tegnene pÃ¥ en stack

        for (int i = 0; i < line.length(); i++)
            list.addToRear(line.charAt(i));
        //stack.push(new Character(line.charAt(i)));

        // Sjekker om lest linje er er palindrom

        for (int i = 0; i < list.size(); i++) {
            if ((char) list.removeFirst() != (char) list.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Leser en linje fra standard input, sjekker om tegnene utgjÃ¸r
     * et palindrom.
     */
    public static void main(String[] args) {
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
