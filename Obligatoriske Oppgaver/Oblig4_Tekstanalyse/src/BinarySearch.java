public class BinarySearch implements BinarySearchADT<String>{

    public Node root;

    public BinarySearch() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    @Override
    public boolean isEmpty(Node rot) {
        return (rot == null);
    }

    @Override
    public boolean search(String a) {
        return false;
    }

    /**
     * Hvis det vi skal sette inn i treet er av større lengde enn 1, f.eks et ord av flere deler,
     * da kjører vi insert metoden for hver av ordene.
     * HVIS ordets lengde er større eller lik 1.
     * @param wordInput, inputen med flere ord.
     */
    @Override
    public void insertAll(String[] wordInput) {
        for (int i = 0; i < wordInput.length; i++) {
            if (wordInput[i].length() >= 1) {
                insert(wordInput[i]);
            }
        }
    }

    /**
     * En innsettings metode som setter inn ett ord inn i det binære søketreet.
     * Hvis ordet eksisterer så vil en teller økes.
     *
     * @param wordInput, ordet som skal sendes inn i treet og lagres.
     */
    @Override
    public void insert(String wordInput) {

        // gjør om ordet til store bokstaver.
        String word = wordInput.toUpperCase();

        // nytt ord som skal lagres. den har ingen venstre eller høyre barn.
        Node insertNode = new Node(word, null, null, 1);

        // hvis det ikke er noen rot i treet, dvs. dette er det første elementet,
        // setter vi dette til å være roten.
        if (isEmpty()) {
            root = insertNode;
            return;
        }

        // setter geldende node til å være rot og at status ikke er ferdig.
        Node currentNode = root;
        boolean finished = false;

        // øker antall noder / ord i treet med 1.
        insertNode.size = currentNode.size++;

        while(!finished) {

            // sammenligner det nye ordet med gjeldende nodes ord / data.
            // vil være 0 om verdiene er like, -1 om det nye ordet er lavere alfabetisk rekkefølge enn gjeldende node
            // vil være 1 om det nye ordet er høyere/større alfabetisk rekkefølge enn gjeldende node.
            int nodeComparing = word.compareTo(currentNode.data);

            // noden / ordet er lavere alfabetisk rekkefølge.
            if (nodeComparing <= -1) {

                // hvis elementet ikke har noen venstre barn, setter vi venstre til å vøre ordet.
                if (currentNode.left == null) {
                    currentNode.left = insertNode;
                    finished = true;
                } else {
                    // går videre og går til neste nodes venstre barn.
                    currentNode = currentNode.left;
                }

            }
            // ordene er like, og øker derfor teller med 1.
            else if (nodeComparing == 0) {
                currentNode.count++;
                finished = true;
            }
            // noden / ordet har høyere alfabetisk rekkefølge.
            else {

                // hvis noden ikke har høyre barn, setter vi ordet inn i høyre barn.
                if (currentNode.right == null) {
                    currentNode.right = insertNode;
                    finished = true;
                }
                // går til nodens høyre barn, og går videre ned i treet.
                else {
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
        if (!isEmpty(gjeldendeNode)) {
            inorder(gjeldendeNode.left);
            gjeldendeNode.printOutNode();
            inorder(gjeldendeNode.right);
        }

    }
}
