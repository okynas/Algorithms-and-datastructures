import java.util.Stack;
public class Main {

    private final static char ADD = '+';
    private final static char SUB = '-';
    private final static char MUL = '*';
    private final static char DIV = '/';

    private static String InfixPostfix(String infixUttrykk) throws Exception {
        /* *
         *   1 Lag en ny tom stack S
         *   2 For alle tegn T i uttrykket:
         *      2.1 Hvis T er en operand: Skriv ut T
         *      2.2 Ellers:
         *           2.2.1 Så lenge T har rang lavere eller lik toppen av S:
         *                  2.2.1.1 Pop S og skriv ut
         *           2.2.2 Push T på S
         *   3 Pop resten av S og skriv ut
         */

        char[] postfix = new char[infixUttrykk.length()];
        int postfixPosition = 0;

        // lager en ny tok stack
        Stack<Character> s = new Stack<>();

        // lager en hjelpe array med alle operatorene
        for (int i = 0; i < infixUttrykk.length(); i++) {
            char T = infixUttrykk.charAt(i);

            // Hvis T er en operand: Skriv ut T
            if (isOperand(T)) {
                postfix[postfixPosition] = T;
                postfixPosition++;
            } else if (isOperator(T)) {
                // Så lenge T har rang lavere eller lik toppen av S, Pop S og skriv ut
                while(!s.isEmpty() && !checkRank(T, s.peek())) {
                    postfix[postfixPosition] = s.pop();
                    postfixPosition++;
                }
                // Push T på S
                s.push(T);
            } else {
                throw new Exception("Input not valid!");
            }
        }

        // Pop resten av S og skriv ut
        while(!s.isEmpty()) {
            postfix[postfixPosition] = s.pop();
            postfixPosition++;
        }

        return new String(postfix);
    }

    private static boolean isOperator(char c) {
        return c == ADD || c == SUB || c == MUL || c == DIV;
    }

    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean checkRank(char char1, char char2) {
        if (char1 == MUL || char1 == DIV) {
            return (char2 == ADD || char2 == SUB);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(InfixPostfix("a+b*c+d/f-e")); // skal returnere: abc*+df/+e-
        System.out.println(InfixPostfix("a*b+c-d/e")); // skal returnere: ab*c+de/-
    }
}
