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

        // GjÃ¸r om til smÃ¥ bokstaver og fjerner all whitespace
        line = line.toLowerCase();
        line = line.replaceAll("\\s","");

        return erPalindrom(line, 0, line.length() - 1);
    }

    public static boolean erPalindrom(String line, int start, int slutt) {

        if (start >= slutt) {
            return true;
        }
        if (line.charAt(start) != line.charAt(slutt)) {
            return false;
        }

        return erPalindrom(line, start + 1, slutt - 1);
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