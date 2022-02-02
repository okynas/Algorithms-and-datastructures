public class Main {
    /**
     * Oppgave 2
     *
     * La S(n) betegne summen av de n første naturlige tallene 1, 2, 3, ..., n.
     * Skriv tre metoder (funksjoner) som beregner S(n) på følgende måter:
     *
     *     Skriv en enkel for-løkke som beregner S(n) = 1 + 2 + 3 + ... + n.
     *
     *     Bruk den rekursive definisjonen:
     *
     *       S(0) = 0   og
     *       S(n) = n + S(n-1).
     *
     *     Bruk formelen S(n) = n · (n+1)/2
     *
     * Hvilken av disse tre metodene er lettest å programmere? Hvilken er lettest å forstå
     * for en som ikke kan noe matematikk? Hvilken er raskest for store verdier av n?
     */

    public static int metode1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
     return sum;
    }

    public static int metode2(int n) {
        if (n == 0) {
            return 0;
        }
        return n + metode2(n-1);
    }

    public static int metode3(int n) {
        return n * (n+1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(metode1(6));
        System.out.println(metode2(6));
        System.out.println(metode3(6));
    }
}
