import java.util.Locale;
import java.util.Scanner;

public class SnuInput
{
    public static void main(String[] args)
    {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        Scanner input = new Scanner(System.in);
        String linje = input.nextLine();
        // reverseArrayStack(stack, linje);
        System.out.println(isPalindrom(stack, linje));
    }

    public static boolean isPalindrom(ArrayStack<Character> s, String linje) {

        // Remove whitespace and turn into lowcase:
        linje = linje.toLowerCase();
        linje = linje.replaceAll("\\s+","");

        // adding strings / characters to the stack.
        for (int i = 0; i < linje.length(); i++) {
            s.push(linje.charAt(i));
        }

        int i = 0;
        while (!s.isEmpty()) {
            char characterToTest = linje.charAt(i);
            if (characterToTest != s.pop()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void reverseArrayStack(ArrayStack<Character> s, String line) {

        for (int i = 0; i < line.length(); i++) {
            s.push(line.charAt(i));
        }

        while (!s.isEmpty()) {
            Character c = s.pop();
            System.out.print(c);
        }
        System.out.println();
    }

}