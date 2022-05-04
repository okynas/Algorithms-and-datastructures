class soketre {
  // gitt fra oppgavetekst. indre klasse
  class node {
    long foedselsnummer;
    node venstre;
    node hoyre;
  }

  node hashtabell[];

  /**
  @param foedselsnummerot, the data that is sent, and calcualte the hash indeks
  @param hashlangde, length of the array
  @return a hashindex that can be used in hashtabell array, to find and insert the index.
  */
  int hash(long foedselsnummer, int hashlangde) {
    return (int) (foedselsnummer % hashlengde);
  }

  /**
  @param node, the node that is beein inserted in the hashtable
  @param hashlengde, the length of the hashtable
  */
  void settInn(node ny, int hashlengde) {
    int h = hash(node.foedselsnummer, hashlengde);

    while (hashtabell[h] != null) {
      h++;

      if (h >= hashlengde) {
        h = 0;
      }

      hashtabell[h] = ny;
    }
  }

  /**
  @param rot, the root of the searchtree
  @param n, length of the array
  */
  void hash_soketre(node rot, int n) {
    int hashlengde = neste_primtall(2 * n);
    hashtabell = new node[hashlengde];

    settInnAlle(rot, hashlengde)
  }

  /**
  @param rot, the root of the searchtree
  @param n, length of the array
  */
  void settInnAlle(node rot, int hashlengde) {
    if (rot != null) {
      settInnAlle(rot.venstre, hashlengde);
      settInnAlle(rot.hoyre, hashlengde);
      settInn(rot, hashlengde);
    }
  }

  // oppgitt i oppgaveteksten
  int neste_primtall(int i) {
    return i;
  }

}