

public class HashBST {
    Node[] hashTabell;

    /**
     * Metode som hasher et søktetre,
     *
     * @param rot, roten i treet som skal hashes fra
     * @param n
     */
    public void hashSoketre(Node rot, int n) {
        int hashLengde = nestePrimtall(2*n);

        hashTabell = new Node[hashLengde];

        settInnAlle(rot, hashLengde);
    }

    /**
     * Metode for å sette inn alle nodene i treet i en hashtabell
     *
     * @param rot, roten i treet som skal hashes fra
     * @param hashLenge, lengden av hashtabellen
     */
    public void settInnAlle(Node rot, int hashLenge) {
        if (rot != null) {
            settInnNode(rot, hashLenge);

            settInnAlle(rot.venstre, hashLenge);
            settInnAlle(rot.hoyre, hashLenge);
        }
    }

    public void settInnNode(Node nyNode, int hashLengde) {
        int index = hash(nyNode.foedselsnummer, hashLengde);

        while (hashTabell[index] != null) {
            index++;
            if (index >= hashLengde) {
                index = 0;
            }
        }

        hashTabell[index] = nyNode;

    }

    public int hash(long key, int hashLengde) {
        return (int) (key % hashLengde);
    }

    /**
     * Metode som er skrevet fra før og har tilgang på. ettersom int, og jeg ikke vet hva innholdet er
     * returnererer jeg bare 0
     * @param i, tall i som sendes skal finne primtall
     * @return neste minste primtall ettter tall i
     */
    public int nestePrimtall(int i) {
        return 0;
    }
}
