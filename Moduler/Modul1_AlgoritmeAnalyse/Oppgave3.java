public class Oppgave3 {
    public static void main(String[] args) {
        /*
        1. Lineær, dvs. t = O(n)

        t(n)=c*n
        => t(n) = 0.5, n = 100
        c = t(n)/n
        = 0.5/100
        = 0.05
        n = t(n)/c = 60000 / 0.05 = 1,2 Millioner

        Problemet er på n = 1,2 Millioner


        2. Superlineær, dvs. t = O(n log(n)):
        t(n) = c * n log(n)
        = 0.5 * 100*log(100)
        c = t(n) / (n*log(n)) = 0.5 / (100*log(100))

        n log(n) = t(n) / c
        = 60000 / 0.5 / (100*log(100))
        = 60000 * 100*log(100) / 0.5
        n*log_10(n) = 60000 * 100 * 2 / 0.5
        = 60000*100*2*2
        = 24 Millioner

        n*log_10(n) = 24 000 000

        Kan være vanskelig å finne n, etter testing finner vi ut at n = 3,6 Millioner

        Kvadratisk, dvs. t = O(n^2)
        t(n) = c*n^2
        c = t(n) / n^2
        = 0.5 / 100^2
        = 0.00005

        n^2 = t(n) / 0.00005
        = 60000 / 0.00005
        = 1,2 Milliarder

        n = sqrt(1,2 Milliarder)
        = 34641

        Problemet er på størrelsen 34641


        Kubisk, dvs. t = O(n^3)
        t(n) = c*n^3
        c = t(n) / n^3
        = 0.5 / 100^3
        = 0.0000005

        n^3 = t(n) / c
        = 60000 / 0.000005
        = 1.2*10^11

        n = 3.kvadratrot (n^3)
        = 4932
        */
    }
}
