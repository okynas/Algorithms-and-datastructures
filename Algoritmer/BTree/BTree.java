package BTree;

public class BTree {

    /**
     * En node i et B-tre av orden m kan representeres med et klasseobjekt med to arrayer:
     * –En array av lengde m med pekere til barna
     * –En sortert array av lengde m – 1 med verdier
     * I tillegg må hver node holde rede på antall verdier som er lagret i noden
     * Tilgang til hele treet gjennom en peker til roten
     */

    public Node root;
    public int degree;

    public BTree(int degree) {
        this.degree = degree;
        this.root = new Node(degree, true);
        this.root.numOfKeys = 0;
    }

    public void Traverse(){
        if (this.root != null) {
            this.root.Traverse();
        }
        System.out.println();

    }

    public Node Search(int value) {
        if (this.root == null) {
            return null;
        }
        return this.root.Search(value);
    }

    private void Split(Node x, int pos, Node y) {
        Node temp = new Node(degree, true);
        temp.leaf = y.leaf;
        temp.numOfKeys = degree - 1;

        for (int j = 0; j < degree - 1; j++) {
            temp.keys[j] = y.keys[j + degree];
        }

        if (!y.leaf) {
            for (int j = 0; j < degree; j++) {
                temp.children[j] = y.children[j + degree];
            }
        }

        y.numOfKeys = degree - 1;

        for (int j = x.numOfKeys; j >= pos + 1; j--) {
            x.children[j + 1] = x.children[j];
        }

        x.children[pos + 1] = temp;

        for (int j = x.numOfKeys - 1; j >= pos; j--) {
            x.keys[j + 1] = x.keys[j];
        }

        x.keys[pos] = y.keys[degree - 1];
        x.numOfKeys++;
    }

    public void insert(final int key) {

        /**
         * Finn bladnoden der ny verdi skal settes inn
         * Hvis bladnoden ikke er full:
         *  –Sett inn ny verdi sortert i bladnoden
         * Ellers, hvis bladnoden er full av verdier:
         *  –Del bladnoden i to noder, med halvparten av verdiene i hver node
         *  –Send midterste verdi et nivå oppover for innsetting i foreldernoden
         *  –Hvis foreldernoden også blir full, fortsettes sending av verdier oppover i treet på samme måte
         */

        Node current = root;
        if (current.numOfKeys == 2 * degree -1) {
            Node temp = new Node(degree, false);
            root = temp;
            temp.numOfKeys = 0;
            temp.children[0] = current;
            Split(temp, 0, current);
            insertValue(current, key);
        } else {
            insertValue(current, key);
        }

    }

    private void insertValue(Node x, int value) {
        if (x.leaf) {
            int i = 0;
            for (i = x.numOfKeys - 1; i >= 0 && value < x.keys[i]; i--) {
                x.keys[i + 1] = x.keys[i];
            }
            x.keys[i + 1] = value;
            x.numOfKeys++;

        } else {
            int i = 0;
            for (i = x.numOfKeys - 1; i >= 0 && value < x.keys[i]; i--) {
            }
            ;
            i++;
            Node temp = x.children[i];
            if (temp.numOfKeys == 2 * degree - 1) {
                Split(x, i, temp);
                if (value > x.keys[i]) {
                    i++;
                }
            }
            insertValue(x.children[i], value);
        }
    }

    public boolean Contains(int value) {
        return this.Search(value) != null;
    }
}
