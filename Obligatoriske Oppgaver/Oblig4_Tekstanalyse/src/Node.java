public class Node {
    public String data;
    public Node left;
    public Node right;
    //public int size;
    public int count;

    public Node(String value, Node left, Node right, int size) {
        this.data = value;          // verdien som skal lagres i noden.
        this.left = left;           // venstre subtre i treet
        this.right = right;         // høyre subtre i treet
        //this.size = size;           // summen av alle nodene i (sub) treet,
        this.count = 1;             // antall forekomster av ordet.
    }

    public void printOutNode() {
        System.out.print("(" + data + ": " + count + "), ");
    }

    /*public int comparing(Node node) {
        return 1;
    }*/
}
