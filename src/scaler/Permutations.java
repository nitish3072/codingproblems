package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Boolean[] booleans = new Boolean[A.size()];
        Arrays.fill(booleans, Boolean.FALSE);
        List<Boolean> booleanList = Arrays.asList(booleans);

        Integer[] integers = new Integer[A.size()];
        Arrays.fill(integers, 0);
        List<Integer> integerList = Arrays.asList(integers);
        permutations(list, new ArrayList<>(integerList), A, 0, new ArrayList<>(booleanList));
        return list;
    }

    public void permutations(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> currList, ArrayList<Integer> A, int index, ArrayList<Boolean> visited) {
        if(index == A.size()) {
            list.add(new ArrayList<>(currList));
            return;
        }
        for (int i = 0; i < A.size(); i++) {
            if (!visited.get(i)) {
                visited.set(i, true);
                currList.set(index, A.get(i));
                permutations(list, currList, A, index + 1, visited);
                visited.set(i, false);
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> list1 = permutations.permute(list);
        for (ArrayList<Integer> integers : list1) {
            System.out.println(integers);
        }
    }
}
