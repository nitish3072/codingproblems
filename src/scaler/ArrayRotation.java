package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static scaler.Helper.printList;

public class ArrayRotation {

    public ArrayList<Integer> solve(List<Integer> A, int B) {
        if (B / (A.size()) > 0) B = B % A.size();
        if (B == 0) return new ArrayList<>(A);

        // reverse complete string
        for (int i = 0; i < A.size() / 2; i++) {
            swap(i, A.size() - 1 - i, A);
        }

        printList(A);

        //Reverse left side
        for (int i = 0; i < B/2; i++) {
            swap(i,  B - i -1, A);
        }

        printList(A);

        //Reverse right side
        for (int i = B; i < (A.size() + B)/2; i++) {
            swap(i, A.size() - 1 + B - i , A);
        }

        printList(A);

        return new ArrayList<>(A);
    }

    public void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        int[] ints = new int[] {1,1,4,9,4,7,1};
        ArrayRotation arrayRotation = new ArrayRotation();
        System.out.println(arrayRotation.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 9));
    }

}
