public class MergeSort {
    public static void sort(int[] A, int min, int max) {
        if (min == max) {
            return;
        }
        int[] temp;
        int index1, left, right;
        int size = min - max + 1;
        int mid = (min + max) / 2;

        temp = new int[size];

        sort(A, min, mid);
        sort(A, mid + 1, max);

        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = A[min + index1];
        }

        left = 0;
        right = mid - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= mid - min) {
                    if (temp[left] > temp[right]) {
                        A[index1 + min] = temp[right++];
                    }
                    else {
                        A[index1 + min] = temp[left++];
                    }
                } else {
                    A[index1 + min] = temp[right++];
                }
            } else {
                A[index1 + min] = temp[left++];
            }
        }
    }
}
