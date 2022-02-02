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

    public static void kombinasjon(String s) {

        int n = s.length();
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                System.out.println(s.substring(0, 1) + s.substring(i, i+1));
            }
            kombinasjon(s.substring(1,n));
        }
    }

    public static void main(String[] args) {
        String input = "grebiøH";
        // snu(input, input.length());

        kombinasjon("ACEGAEDAGTEA");
    }

}
