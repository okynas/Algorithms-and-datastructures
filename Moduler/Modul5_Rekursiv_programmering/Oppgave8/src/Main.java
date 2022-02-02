import java.util.Random;

public class Main {
    public static void reverserer(int[] x, int n) {
        if (n > 1) {
            // setter temp til å være første i lista.
            int temp = x[0];

            // flytter x[i] en plass ned mot venstre.
            for (int i = 1; i < n; i++) {
                // x[0] = x[1], x[1] = x[2] ...
                x[i-1] = x[i];
            }

            // setter siste element til å være første
            x[n-1] = temp;
            // kjører programmet igjen, (rekursiv) hvor n er 1 mindre.
            reverserer(x, n-1);
        }
    }

    public static void main(String[] args) {
        int arraySize = 20;
        int maxSize = 100;

        int[] arr = new int[arraySize];
        int i;

        Random r = new Random();
        for (i = 0; i < arraySize; i++) {
            arr[i] = r.nextInt(maxSize);
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        reverserer(arr, arraySize);

        for (i = 0; i < arraySize; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

    }
}
