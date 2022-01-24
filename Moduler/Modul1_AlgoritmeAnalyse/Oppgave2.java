public class Oppgave2 {
    public static void main(String[] args) {
        /*
        Et program bruker 0.5 ms (millisekunder eller "tusendeler") for en input av størrelse n=100.
        Hvor lang tid brukes for en input av størrelse 500 (problemstørrelsen øker altså med en faktor 5) når kjøretiden t er:

        Lineær, dvs. t = O(n)
        =>
        t(n) = c*n => c=t(n)/n
        c = 0.5/100 = 0.005

        => t(500) = 0.005 * 500 = 2.5 ms


        Superlineær, dvs. t = O(n log(n)):
        =>
        t(n) = c * (n * log(n))
        c = t(n) / (n * log(n)) = 0.5 / (100*log(100))

        => t(500) = 500 * log(500) * ( 0.5 / (100*log(100)) ) = 3.375 ms

        Kvadratisk, dvs. t = O(n^2)
        =>
        t(n) = c * n^2
        c = t(n) / n^2 = 0.5 / 100^2

        => t(500) = 500^2 * (0.5 / 100^2) = 12.5 ms

        Kubisk, dvs. t = O(n^3)
        =>
        t(n) = c*n^3
        c = t(n) / n^3 = 0.5 / 100^3

        >= t(500) = 500^3 * (0.5 / 100^3) = 62.5 ms
         */
    }
}
