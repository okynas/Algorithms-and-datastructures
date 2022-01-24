class Oppgave1 {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        System.out.println(delOppgave7(5));
        // 0.5n^4 - 0.5n^2
        // System.out.println(0.5*Math.pow(5,5)-0.5*Math.pow(5,3));
        /*
        delOppgave1(5); // O(n)
        delOppgave2(5); // O(n^2)
        delOppgave3(5); // O(2n)
        delOppgave4(5); // O(n^3)
        delOppgave5(5); // O(n^2)
        delOppgave6(5); // O(n^5)
        delOppgave7(5); // O(n)
        */

    }

    public static int delOppgave1(int n) {
        // Denne har O(n) effektivitet.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }

    public static int delOppgave2(int n) {
        // Denne har O(n^2) effektivitet
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public static int delOppgave3(int n) {
        int sum = 0;
        // Denne har O(2*n) effektivitet
        for (int i=0; i < n; i++)
            sum++;
        for (int j = 0; j < n; j++)
            sum++;

        return sum;
    }

    public static int delOppgave4(int n) {
        // Denne har O(n^3) effektivitet
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        return sum;
    }

    public static int delOppgave5(int n) {
        /*
        1 + 2 + 3 + ... + (n - 1) = n (n - 1) / 2 = 0.5n^2 - 0.5n
        => O(n^2)

        */
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("------");
            for (int j = 0; j < i; j++) {
                System.out.println(String.format("I: %d, J: %d, sum: %d", i, j, sum));
                sum++;
            }
        }
        return sum;
    }

    public static int delOppgave6(int n) {
        /*
        n*n=N, ser på det som forrige oppgave:
        1 + 2 + 3 + ... + (N - 1) = N (N - 1) / 2 = 0.5N^2 - 0.5N
        => N^2

        n*N^2 = n*(n^2)^2 = n*n^4
        => O(n^5)

        */

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * n; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        return sum;
    }


    public static int delOppgave7(int n) {
        /*
        Uten if-setning:
        N=i*i
        ser på deloppgave 5:
        1+2+3+4+5+...+(N-1)=0.5N^2-0.5N
        n*(0.5N^2-0.5N)
        => O(n^5)

        Med if-setning:
        j=0 til j=i^2-1
        i=4 => j går fra 0 til 15
        of if vil slå ut på 0,4,8,12

        => O(n^4)
        */
        int sum = 0;
        for (int i = 0; i < n; i++) { // n
            System.out.println("-----");
            for (int j = 0; j < i * i; j++) {
                if (j % i == 0) {
                    for (int k = 0; k < j; k++) {
                        sum++;
                        System.out.println(String.format("I: %d, J: %d, k: %d", i, j, k));
                    }
                }
            }
        }
        return sum;
    }
}