package Search;

public class Search {

    public static boolean binarySearch(int[] array, int x) {

    }

    public static boolean sequentialSearch(int[] array, int x) {
        int n = array.length;

        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                return true;
            }
        }
        return false;

    }

    public static boolean interpolationSearch(int[] array, int x) {

    }

    public static void main(String[] args) {

    }
}
