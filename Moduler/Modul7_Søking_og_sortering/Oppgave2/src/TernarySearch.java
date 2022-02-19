public class TernarySearch {
    public static int Iterative(int[] A, int x) {
        int n = A.length;
        int i2 = n/3;
        int i3 = 2*n/3;

        if (x < i2) {
            // elementet x ligger mellom index 0 og 1/3
            return 1
        } else if ( x > i2 && x < i3) {
            // element x ligger mellom index 1/3 og 2/3
            return 2;
        } else {
            // element x ligger mellom index 2/3 og n-1
            return 3;
        }
        return 0;

    }

    public static void main(String[] args) {

        int[] A = {1,2,3,4,5,6,7,8,9,10};
        Iterative(A, 7);
    }
}
