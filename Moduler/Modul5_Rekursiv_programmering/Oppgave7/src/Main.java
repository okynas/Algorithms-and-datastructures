import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void snu(String s, int n) {
        if (n > 0) {
            System.out.print(s.charAt(n-1));
            snu(s.substring(0, n-1), n-1);
        }
    }

    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c: chars) {
            charSet.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : charSet) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    public static void metode2(String s) {
        System.out.println(removeDuplicates(s));

    }

    public static void main(String[] args) {
        String input = "grebiøH";
        // snu(input, input.length());

        metode2("ACEGAEDAGTEA");
    }

}
