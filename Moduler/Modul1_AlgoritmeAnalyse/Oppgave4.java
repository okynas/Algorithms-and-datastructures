public class Oppgave4 {
    /*
    Skriv et program som tester hvor lang tid maskinen bruker for å utføre hhv.:
    n log(n), n2, n3, n5, 2n og n! addisjoner for n = 10, 20, 30,... 90, 100.
    */

    public static void main(String[] args) {
        int N_MIN = 10;
        int N_MAX = 100;
        int N_STEP = 10;

        int n = 0;
        double i;
        double n_log_n = 0.0, n_squared, n_cubic, n_pow_5;
        double two_pow_n = 1.0;
        double n_factorial = 1.0;

        for (n = N_MIN; n <= N_MAX; n+= N_STEP) {

            System.out.println("--------------------------------------------------------------------");
            System.out.println(String.format("n = %d", n));
            System.out.println("--------------------------------------------------------------------");

            n_log_n = n * Math.log(n);
            n_squared = Math.pow(n, 2);
            n_cubic = Math.pow(n,3);
            n_pow_5 = Math.pow(n,5);


            for (i = 0; i < N_STEP; i++) {
                two_pow_n = two_pow_n * 2;
                n_factorial = n_factorial * (n-i);
            }

            // Her vil kode for å teste ulike algoritmer skje.

            calculate_n_log_n_time(n_log_n, i);
            calculate_n_squared(n_squared, i);
            calculate_n_cubic(n_cubic, i);
            calculate_n_pow_5(n_pow_5, i);
            calculate_two_pow_n(n, two_pow_n, i);
            calculate_n_factorial(n, n_factorial, i);

        }
    }

    public static void calculate_n_log_n_time(double n_log_n, double i) {
        System.out.println(String.format("n log(n) = %f", n_log_n));
        double T = System.currentTimeMillis();
        for (i = 0; i < n_log_n; i++);
        T = System.currentTimeMillis() - T;
        System.out.println(String.format("T = %f (ms)", T));
        System.out.println("");
    }

    public static void calculate_n_squared(double n_squared, double i) {
        System.out.println(String.format("n^2 = %f", n_squared));
        double T = System.currentTimeMillis();
        for (i = 0; i < n_squared; i++);
        T = System.currentTimeMillis() - T;
        System.out.println(String.format("T = %f (ms)", T));
        System.out.println("");
    }

    public static void calculate_n_cubic(double n_cubic, double i) {
        System.out.println(String.format("n^3 = %f", n_cubic));
        double T = System.currentTimeMillis();
        for (i = 0; i < n_cubic; i++);
        T = System.currentTimeMillis() - T;
        System.out.println(String.format("T = %f (ms)", T));
        System.out.println("");
    }

    public static void calculate_n_pow_5(double n_pow_5, double i) {
        System.out.println(String.format("n^5 = %f", n_pow_5));
        double T = System.currentTimeMillis();
        for (i = 0; i < n_pow_5; i++);
        T = System.currentTimeMillis() - T;
        System.out.println(String.format("T = %f (ms)", T));
        System.out.println("");
    }
    public static void calculate_two_pow_n(double n, double two_pow_n, double i) {
        System.out.println(String.format("2^n = %f", two_pow_n));
        if (n <= 30) {
            double T = System.currentTimeMillis();
            for (i = 0; i < two_pow_n; i++) ;
            T = System.currentTimeMillis() - T;
            System.out.println(String.format("T = %f (ms)", T));
        }
        else {
            System.out.println("Det tar alt for lang tid!");
        }
        System.out.println("");
    }
    public static void calculate_n_factorial(double n, double n_fac, double i) {
        System.out.println(String.format("n! = %f", n_fac));
        if (n <= 10) {
            double T = System.currentTimeMillis();
            for (i = 0; i < n_fac; i++);
            T = System.currentTimeMillis() - T;
            System.out.println(String.format("T = %f (ms)", T));
        }
        else {
            System.out.println("Det tar alt for lang tid!");
        }
        System.out.println("");
    }
}
