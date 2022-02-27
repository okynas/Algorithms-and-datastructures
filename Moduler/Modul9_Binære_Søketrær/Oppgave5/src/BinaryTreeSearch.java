public class BinaryTreeSearch {
    class TreNode {
        int data;
        TreNode v, h;

        public TreNode(int i) {
            this.data = i;
            v = h = null;
        }
    }

    public static TreNode root;

    public BinaryTreeSearch() {
        root = null;
    }

    public static boolean isEmpty() {
        return (root == null);
    }

    public void insert(int value) {
        TreNode temp = new TreNode(value);

        if (isEmpty()) {
            root = temp;
            return;
        }

        TreNode current = root;
        boolean finished = false;

        while (!finished) {
            if (value < current.data) {
                if (current.v == null) {
                    current.v = temp;
                    finished = true;
                }
                else {
                    current = current.v;
                }
            }
            else {
                if (current.h == null) {
                    current.h = temp;
                    finished = true;
                }
                else {
                    current = current.h;
                }

            }
        }

    }



}
