import java.util.Scanner;

public class TestBinomial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("n:?  ");
        int n = in.nextInt();
        System.out.println("m:?  ");
        int m = in.nextInt();

        System.out.println(BinomialKoeffesient.calculate(n,m));
    }
}
