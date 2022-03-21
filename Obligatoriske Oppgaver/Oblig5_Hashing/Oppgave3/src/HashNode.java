// Indre klasse:
// Node med data, kjedes sammen i lenkede lister
//
public class HashNode {
    // Data, en tekststreng
    String data;
    // Neste node i listen
    HashNode neste;

    // KonstruktÃ¸r for listenoder
    public HashNode(String S, HashNode hN) {
        data = S;
        neste = hN;
    }
}