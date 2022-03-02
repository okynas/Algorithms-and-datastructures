package BTree;

public class Node {
    public int[] keys;
    public int degree;
    public Node[] children;
    public int numOfKeys;
    public boolean leaf;

    public Node(int degree, boolean leaf) {
        this.degree = degree;
        this.leaf = leaf;
        this.keys = new int[2 * degree - 1];
        this.children = new Node[2 * degree];
        this.numOfKeys = 0;
    }

    /**
     * Det er n noder og n-1 barn, går igjennom de n nodene, deretter de n-1 barna
     */
    public void Traverse() {
        int i;
        for (i = 0; i < this.numOfKeys; i++) {
            // hvis det ikke er et bladnode, gå til neste traversering før den printer
            if (!this.leaf) {
                children[i].Traverse();
            }
            System.out.print(keys[i] + " ");
        }

        // går så igjennom subtrærne
        if (!this.leaf) {
            children[i].Traverse();
        }

    }

    public Node Search(int value) {
        int i = 0;
        while (i < numOfKeys && value > keys[i] ) {
            i++;
        }
        if (keys[i] == value) {
            return this;
        }
        if (this.leaf) {
            return null;
        }

        return children[i].Search(value);
    }
}
