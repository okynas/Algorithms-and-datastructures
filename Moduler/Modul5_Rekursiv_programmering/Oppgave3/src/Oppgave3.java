public class Oppgave3 {

    /**
     * Anta at Java ikke har noen innebygget multiplikasjonsoperator (*),
     * men kun addisjon (+). Skriv en rekursiv metode som har som argumenter
     * to ikke-negative heltall m og n, og som
     * returnerer produktet m · n beregnet ved rekursiv addisjon.
     *
     * @param m
     * @param n
     * @return m*n, uten å bruke multiplikasjon
     */
    public static int multiplikasjon(int m, int n) {

        if (n == 1) {
            return m;
        }

        return (m + multiplikasjon(m, n-1));
    }

    /**
     *Anta at Java ikke har noen innebygget addisjonsoperator (+),
     * men kun inkrement (++). Skriv en rekursiv metode som har som argumenter
     * to ikke-negative heltall m og n, og som returnerer summen m + n
     * beregnet ved rekursivt inkrement.
     *
     * @param n
     * @param m
     * @return summen av m og n, uten å bruke + operator.
     */

    public static int addisjon(int m, int n) {

        if (n == 0) {
            return m;
        }

        int temp;
        temp = addisjon(m, n-1);
        return ++temp;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 10;
        System.out.println("Multiplikasjon: " + m + " * " + n + " = " + multiplikasjon(m, n));
        System.out.println("Addisjon: " + m + " + " + n + " = " + addisjon(m,n));
    }
}
