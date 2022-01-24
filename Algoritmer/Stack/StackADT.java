package Stack;

public interface StackADT<T>{
    // Legge til et nytt element paa stacken.
    public void push(T element);

    // Fjerne og returnere overste element paa stakken
    public T pop() throws Exception;

    // Returnere overste element uten aa fjerne det
    public T peek() throws Exception;

    // Antall elementer i stacken
    public int size();

    // Sjekker om stacken er tom
    public boolean isEmpty();

    public void expandCapacity();

    public String toString();
}