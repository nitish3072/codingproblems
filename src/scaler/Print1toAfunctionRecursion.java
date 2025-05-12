package scaler;

public class Print1toAfunctionRecursion {
    public void solvePrint(int A) {
        if(A==0) return;
        solvePrint(A-1);
        System.out.print(A + " ");
    }

    public static void main(String[] args) {
        Print1toAfunctionRecursion p = new Print1toAfunctionRecursion();
        p.solvePrint(77);
    }
}
