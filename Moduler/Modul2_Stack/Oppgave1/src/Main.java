public class Main {
    //  https://it.hiof.no/algdat/2018/oppgaver/uke_3_1.java
    public static Integer thirdElement(StackInt s) throws Exception {
        /*
        Returner innholdet av tredje element på STACK, telt fra toppen av stacken. Hvis STACK inneholder mindre enn 3 elementer,
        returneres null. Innholdet av S skal ikke være forandret når funksjonen terminerer.
         */
        Integer element1, element2, element3 = null;

        if (!s.isEmpty()) {
            element1 = s.pop();
            if (!s.isEmpty()) {
                element2 = s.pop();

                if (!s.isEmpty()) {
                    element3 = s.peek();
                    s.push(element2);
                }
                s.push(element1);
            }
        }
        return element3;
    }
    public static Integer bottomElement(StackInt s) throws Exception {
        /*
        Returner innholdet av elementet på bunnen av STACK. Hvis STACK er tom, returneres null.
        STACK skal ikke være forandret ved terminering. Her må(?) det brukes en ekstra stack.
        */

        if (s.isEmpty()) {
            return 0;
        }
        // lager midlertidig stack
        StackInt temporaryStackReversed = new StackInt(s.size());
        // fyller opp midlertidig stack med verdi fra stack, og fjerner dem fra stack
        for (int i = s.size(); i>0; i--) {
            temporaryStackReversed.push(s.pop());
        }
        // siste elementet i stacken, denne skal returneres.
        Integer lastElement = temporaryStackReversed.peek();

        // reverserer reversert-temp-stack, slik at vanlig stack blir normal / opprinnelig som før funksjonen kjørte.
        for (int i = temporaryStackReversed.size(); i>0; i--) {
            s.push(temporaryStackReversed.pop());
        }
        return lastElement;

    }

    public static void deleteElementWithValueX(StackInt s, int valueToDelete) throws Exception {
        /*
        Fjern alle elementer på STACK som har verdi lik x. De resterende elementene på STACK skal ligge i uforandret rekkefølge.
        */

        StackInt upadtedStack = new StackInt(s.size());

        // går igjennom hver verdi, og sjekker om denne er lik x
        while (!s.isEmpty()) {
            int valueToCheck = s.pop();
            if ( valueToCheck != valueToDelete) {
                upadtedStack.push(valueToCheck);
            }
        }

        while(!upadtedStack.isEmpty()) {
            s.push(upadtedStack.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        // Initialiserer stacken!
        StackInt stack = new StackInt(10);

        // fyller stacken med verdier, og printer dem.
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
            //System.out.println(stack);
            //System.out.println("");
        }
        System.out.println(stack);

        // Henter ut 3. elementet i stacken.
        System.out.println("3. element fra stack er: " + thirdElement(stack));

        // Henter ut siste elementet i stacken
        System.out.println("Siste element fra stack er: " + bottomElement(stack));

        int valueToDelete = 4;
        System.out.println("Fjerner verdien " + valueToDelete + " fra stack.");
        deleteElementWithValueX(stack, valueToDelete);

        System.out.println("Ny stack blir da:");
        System.out.println(stack);

    }
}
