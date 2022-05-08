public class test {
    public static int finn(int A[], int verdi) {
        int index = 0;
        int n = A.length;

        while (index < n && A[index] < verdi) {
            index++;
        }
        if (index < n && A[index] == verdi) {
            return index;
        } else {
            return -(index + 1);
        }
    }

    public static int finn2(int A[], int verdi) {
        int nedre = 0, ovre = A.length, midt = 0, midtverdi = 0;
        boolean ferdig = false;

        while (nedre <= ovre && !ferdig) {
            midt = (nedre+ovre)/2;
            midtverdi = A[midt];

            if (verdi > midtverdi) {
                nedre = midt+1;
            } else if(verdi < midtverdi) {
                ovre = midt - 1;
            }
            else {
                ferdig = true;
            }
        }

        if (nedre > ovre) {
            return -(nedre+1);
        }

        while(midt > 0 && A[midt - 1] == verdi) {
            midt--;
        }
        return midt;

    }

    public static void main(String[] args) {
        int A[]  = {2, 3, 5, 7, 10, 11, 12, 12, 18, 20};
        int f = finn2(A, 9);
        System.out.println(f);
    }
}
