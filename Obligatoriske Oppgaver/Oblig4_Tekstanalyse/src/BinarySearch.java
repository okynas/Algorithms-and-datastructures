public class BinarySearch implements BinarySearchADT<String>{

    public static Node root;

    public BinarySearch() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public boolean search(String a) {
        return false;
    }

    /**
     * En innsettings metode som setter inn ett ord inn i det binære søketreet.
     * Hvis ordet eksisterer så vil en teller økes.
     *
     * @param wordInput, ordet som skal sendes inn i treet og lagres.
     */
    @Override
    public void insert(String wordInput) {

        String word = wordInput.toUpperCase();

        // nytt ord som skal lagres.
        Node insertNode = new Node(word, null, null, 1);

        if (isEmpty()) {
            root = insertNode;
            return;
        }

        Node currentNode = root;
        boolean finished = false;

        while(!finished) {

            // sammenligner det nye ordet med gjeldende nodes ord / data.
            // vil være 0 om verdiene er like, -1 om det nye ordet er lavere alfabetisk rekkefølge enn gjeldende node
            // vil være 1 om det nye ordet er høyere/større alfabetisk rekkefølge enn gjeldende node.
            int nodeComparing = word.compareTo(currentNode.data);

            if (nodeComparing <= -1) {

                if (currentNode.left == null) {
                    currentNode.left = insertNode;
                    finished = true;
                } else {
                    currentNode = currentNode.left;
                }

            } else if (nodeComparing == 0) {
                currentNode.count++;
                finished = true;
            } else {

                if (currentNode.right == null) {
                    currentNode.right = insertNode;
                    finished = true;
                } else {
                    currentNode = currentNode.right;
                }

            }

        }
    }

    @Override
    public void remove(String a) {

    }

    @Override
    public Node replacement(Node s) {
        return null;
    }

    /**
     * InOrder traversering.
     * Går i gjennom alle nodene i det binære søæketreet, og skriver ut alle nodene fre gjeldende og nedover treet
     * i stigende rekkefølge, fra venstre node og til høyre.
     *
     * @param gjeldendeNode, gjeldende node som skal printes ut fra. Begynner på denne og jobber seg nedover.
     */
    @Override
    public void inorder(Node gjeldendeNode) {
        if (!isEmpty()) {
            inorder(gjeldendeNode.left);
            gjeldendeNode.printOutNode();
            inorder(gjeldendeNode.right);
        }

    }
}
