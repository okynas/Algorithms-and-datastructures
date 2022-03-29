import java.io.*;
import java.util.*;

/**
  *
  * Lager BFS og DFS
  */
public class traverseGraf extends enkelGraf {
  boolean oppsokt[];

  public traverseGraf(String filnavn) {
    super(filnavn);
    oppsokt = new boolean[n];
  }

  public void DFS(int start) {
    for (int i = 0; i < n; i++) {
      oppsokt[i] = false;
    }

    rDFS(start);
    System.out.println();
  }

  private void rDFS(int x) {
    // skriver ut innholder
    System.out.print(data[x] + " ");

    // markerer noden som opsøkt
    oppsokt[x] = true;

    // oppsøker rekursivt alle nodens naboer, som ikke er oppsøkt tidligere
    for (int y = 0; y < n; y++) {
      if (nabo[x][y] && !oppsokt[y]) {
        rDFS(y);
      }
    }
  }

  public void BFS(int start) {
    // markerer alle nodene som ikke oppsøkt.

    for (int i = 0; i < n; i++) {
      oppsokt[i] = false;
    }

    Queue<Integer> Q = new LinkedList<>();

    Q.add(new Integer(start));

    oppsokt[start] = true;

    while(!Q.isEmpty()) {
      int x = Q.remove().intValue();
      System.out-print(data[x] + " ");

      for (int y = 0; y < n; y++) {
        if (nabo[x][y] && !oppsokt[y]) {
          Q.add(new Integer(y));
          oppsokt[y] = true;
        }
      }
    }
  }

  public static void main(String args[]) {
    String filnavn = "";
    try {
      if (args.length != 1) {
        throw new IOException("Mangler filnavn");
      }
      filnavn = args[0];
    }
    catch(Exception e) {
      System.err.println(e);
      System.exit(1);
    }

    // oppretter en ny graf
    traverseGraf G = new traverseGraf(filnavn);

    System.out.println("DFS:")
    for (int i = 0; i < G.antallNoder(); i++) {
      G.DFS(i);
    }

    System.out.println("\n BFS:");
    for (int i = 0; i < G.antallNoder(); i++) {
      G.BFS(i);
    }
  }
}