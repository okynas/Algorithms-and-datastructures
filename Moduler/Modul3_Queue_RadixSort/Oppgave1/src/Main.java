import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Skriv inn et palindrom for å sjekke:    ");

        ArrayStack<Character> stack = new ArrayStack<>();
        ArrayQueue<Character> queue = new ArrayQueue<>();

        Scanner input = new Scanner(System.in);
        String linje = input.nextLine();

        System.out.println(isPalindrom(stack, queue, linje));
    }

    public static boolean isPalindrom(ArrayStack<Character> s, ArrayQueue<Character> q, String linje) {
        // Remove whitespace and turn into lowcase:
        linje = linje.toLowerCase().replaceAll("\\s+","");

        // adding strings / characters to the stack and the queue.
        for (int i = 0; i < linje.length(); i++) {
            s.push(linje.charAt(i));
            q.enqueue(linje.charAt(i));
        }

        while (!s.isEmpty()) {
            if (q.dequeue() != s.pop()) {
                return false;
            }
        }
        return true;
    }
}
