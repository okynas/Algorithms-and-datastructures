import java.io.*;
import java.nio.Buffer;

public class Main {
    /**
     * Function will read input from user
     */
    public static BufferedReader readFromUserInput() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * A method for reading data from file.
     * @return a buffer reader, to be used in creating binary search tree nodes.
     */
    public static BufferedReader readFromFile()  {
        try {
            String basePath = new File("").getAbsolutePath();
            FileReader in = new FileReader(basePath + "/src/input.txt");

            return new BufferedReader(in);

        } catch (IOException e) {
            System.out.println("errors: " + e);
            System.exit(1);
        }

        return null;
    }

    public static void addingToBinarySearchTree(BinarySearch BST) {
        try {

            BufferedReader br = readFromFile();

            StreamTokenizer input = new StreamTokenizer(br);

            int x = input.nextToken();
            while (x != StreamTokenizer.TT_EOF) {
                if (input.ttype == StreamTokenizer.TT_WORD) {


                    String addingToBinarySearchTree = input.sval.toUpperCase()
                            .replaceAll("\\.", "")
                            .replaceAll("-", " ");

                    String[] binarySearchMultiple = addingToBinarySearchTree.split(" ");

                    if (binarySearchMultiple.length >= 2) {
                        BST.insertAll(binarySearchMultiple);
                    } else {
                        BST.insert(addingToBinarySearchTree);
                    }

                }
                x = input.nextToken();
            }


        } catch (IOException ignored) {
            System.out.println("errors: " + ignored);
        }
    }

    public static void main(String[] args)  {
        BinarySearch sokeTre = new BinarySearch();

        // readFromUserInput();
        // sokeTre.insert("Stian");
        // sokeTre.insert("Martinsen");
        // sokeTre.insert("Stian");

        // sokeTre.inorder(sokeTre.root);

        addingToBinarySearchTree(sokeTre);

        sokeTre.inorder(sokeTre.root);

        System.out.println("\n Antall ord som er i søketreet: " + sokeTre.root.size);

    }

}
