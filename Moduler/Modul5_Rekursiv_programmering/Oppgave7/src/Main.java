import java.util.ArrayList;

public class Main {
    public static String snu(String s, int n) {
        ArrayList<Character> streng = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            streng.add(s.charAt(i));
        }

        //System.out.println(streng.remove(0));

        if (streng.remove(0) != streng.remove(n-1)) {
            return "Error";
        }

        String input = streng.toString();

        return snu(input, input.length());
    }

    public static void metode2() {

    }

    public static void main(String[] args) {
        String input = "grebiøH";

        snu(input, input.length());
    }

}
