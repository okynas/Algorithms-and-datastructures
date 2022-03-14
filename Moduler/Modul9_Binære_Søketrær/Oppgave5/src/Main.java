public class Main {
    public static void TreeSort(int[] A) {
        // Arbeidsmengde O(n log(n)) hvis sortert
        int n = A.length;
        BinaryTreeSearch T = new BinaryTreeSearch();
        // overfør hele array til søketre
        for (int i = 0; i < n; i++) {
            T.insert(A[i]);
        }

        InOrderCopy(BinaryTreeSearch.root, A, 0);
    }

    public static int InOrderCopy(BinaryTreeSearch.TreNode rot, int[] Array, int index) {
        if (rot == null) {
            return index;
        }

        int i = InOrderCopy(rot.v, Array, index);
        Array[i] = rot.data;
        return InOrderCopy(rot.h, Array, i+1);
    }

    public static void main(String[] args) {
        System.out.println("STARTING");
        int A[] = {5,4,9,0,8,2,7,3,2,1,6,7,1};
        TreeSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
    }
}

