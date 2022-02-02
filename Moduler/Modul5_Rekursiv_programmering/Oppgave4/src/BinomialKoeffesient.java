public class BinomialKoeffesient {
    /**
     * C(n, 0) = 1 og C(n, n) = 1,	for n >= 0
     * C(n, m) = C(n-1, m) + C(n-1, m-1),	for 0 < m < n
     *
     * @param m
     * @param n
     * @return binomial
     */
    public static float calculate(int n, int m){
        if (m == 0 || m == n) {
            return 1;
        }

        return (calculate(n-1, m) + calculate(n-1, m-1));
    }

    public static void main(String[] args) {
        for (int n = 0; n < 10; n++) {
            for (int m = 0; m <= n; m++) {
                System.out.println(calculate(n,m) + " ");
            }
            System.out.println();
        }
    }
}
