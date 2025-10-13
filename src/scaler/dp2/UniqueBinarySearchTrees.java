package scaler.dp2;

public class UniqueBinarySearchTrees {

    public int numTrees(int A) {
        int[] C = new int[A + 1];
        C[0] = 1;
        C[1] = 1;
        for (int i = 2; i <= A; i++) {
            C[i] = 0;
            for (int j = 0; j < i; j++) {
                C[i] += C[j] * C[i - j - 1];
            }
        }
        return C[A];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees  u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(5));
    }

}
