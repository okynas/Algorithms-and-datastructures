import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    /**
     * Function will read input from user, and add new line for each "space".
     * Got this function from task-description.
     */
    public static void readFromUserInput() {
        BufferedReader r =
                new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer input = new StreamTokenizer(r);

        try
        {
            int x = input.nextToken();
            while (x != StreamTokenizer.TT_EOF)
            {
                if (input.ttype == StreamTokenizer.TT_WORD)
                    System.out.println(input.sval);
                x = input.nextToken ();
            }
        }
        catch (IOException ignored) {};
    }

    public static void main(String[] args) {
        readFromUserInput();
    }

}
