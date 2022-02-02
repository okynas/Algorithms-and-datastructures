import java.util.ArrayList;

public class Main {
    public static void snu(String s, int n) {
        if (n > 0) {
            System.out.print(s.charAt(n-1));
            snu(s.substring(0, n-1), n-1);
        }
    }

    public static void metode2() {

    }

    public static void main(String[] args) {
        String input = "grebiøH";
        snu(input, input.length());
    }

}
