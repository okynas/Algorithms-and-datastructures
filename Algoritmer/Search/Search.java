package Search;

public class Search {

    public static boolean binarySearch(int[] array, int x) {
        int n = array.length;
        int min = 0, max = n-1, mid = 0;

        while(max >= min) {
            mid = (min + max) / 2;
            if (array[mid] == x) {
                return true;
            }

            if (x < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
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
        int n = array.length;
        int min = 0, max = n-1, mid = 0;

        float percent, step;

        while (array[min] < x && x <= array[max] && max > min) {
            percent = ( (float) (x-array[min]) ) / ( (float) (array[max] - array[min]));
            step = (max - min) * percent;
            mid = min + (int) step;

            if (array[mid] == x) {
                return true;
            }
            if (x < array[mid]) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        if (array[min] == x) {
            return true;
        }

        return false;
    }
}
