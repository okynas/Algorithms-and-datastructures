class Node {
    int data;
    int hoyde;
    Node v, h;
    public Node(int i) {
        this.data = i;
        v = h = null;
    }
}

public class Main {
    public boolean erAVL(Node rot) {
        // Treet tomt?
        if (rot == null) {
            return true;
        }

        int hoydeVenstre = -1;
        int hoydeHoyre = -1;

        // sjekker venstre subtre
        if (rot.v != null) {
            // er venstre subtre et avl-tre?
            if (!erAVL(rot.v)) {
                return false;
            }
            // er venstre sin data større enn roten sin verdi?
            if (rot.v.data > rot.data) {
                return false;
            }
            hoydeVenstre = rot.v.hoyde;
        }

        if (rot.h != null) {
            // er høyre subtre et avl-tre?
            if (!erAVL(rot.h)) {
                return false;
            }
            // er dataen til høyre subtre mindre enn rotens data.
            if (rot.h.data < rot.data) {
                return false;
            }
            hoydeHoyre = rot.h.hoyde;
        }

        // sjekker om det er forskjell på høyre og venstre subtre
        if (Math.abs(hoydeVenstre - hoydeHoyre) > 1) {
            return false;
        }
        // beregner høyden til denne noden.
        rot.hoyde = Math.max(hoydeVenstre, hoydeHoyre) + 1;
        return true;
    }
}
