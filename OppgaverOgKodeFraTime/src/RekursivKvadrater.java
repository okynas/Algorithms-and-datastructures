public class RekursivKvadrater {
    public static int kvadrat(int n) {
        if (n <= 1) {
            return 1;
        }

        return 2 * n + kvadrat(n-1) - 1;

    }

    public static void main(String[] args) {
        System.out.println(kvadrat(5));
    }
}
