public interface BinarySearchADT<T> {
    boolean isEmpty();
    boolean search(T element);
    void insert(T element);
    void remove(T element);
    Node replacement(Node node);
    void inorder(Node node);
}
