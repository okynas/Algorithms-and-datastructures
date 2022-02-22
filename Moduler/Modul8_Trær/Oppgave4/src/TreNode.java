public class TreNode {
    private int data;
    private TreNode venstre, hoyre;

    public TreNode(int n) {
        data = n;
        venstre = hoyre = null;
    }

    public static int antallBlader(TreNode rot) {
        // Returnerer antall blader i et tre med en gitt rot

        if (rot == null) {
            return 0;
        }

        if (rot.venstre == null && rot.hoyre == null) {
            return 1;
        }

        return (antallBlader(rot.venstre) + antallBlader(rot.hoyre));
    }

    public static int antallMedEttBarn(TreNode rot) {
        // Returnerer antall noder med bare ett barn
        int leggTil = 0;

        if (rot == null) {
            return 0;
        }

        if ( (rot.venstre == null && rot.hoyre != null) || (rot.venstre != null && rot.hoyre == null) ) {
            leggTil = 1;
        }
        // i et tre med en gitt rot
        return  leggTil + antallMedEttBarn(rot.venstre) + antallMedEttBarn(rot.hoyre);
    }

    public static int antallMedToBarn(TreNode rot) {
        // Returnerer antall noder med to barn (fulle noder)
        // i et tre med en gitt rot
        int leggTil = 0;

        if (rot == null) {
            return 0;
        }

        if ( (rot.venstre != null && rot.hoyre != null)  ) {
            leggTil = 1;
        }
        // i et tre med en gitt rot
        return  leggTil + antallMedToBarn(rot.venstre) + antallMedToBarn(rot.hoyre);
    }

    public static void main(String[] args) {

        TreNode root = new TreNode(1);
        root.venstre = new TreNode(4);
        root.venstre.venstre = new TreNode(8);
        root.venstre.hoyre = new TreNode(7);
        root.hoyre = new TreNode(5);
        root.hoyre.hoyre = new TreNode(7);

        System.out.println(antallMedToBarn(root.hoyre));
    }


}
