package educative.grokkingcodinginterview.subsets;

import java.util.*;

public class FindSubsets {

    public static List<List<Integer>> findAllSubsets(List<Integer> v) {
        List<List<Integer>> setsList = new ArrayList<>();
        setsList.add(new ArrayList<>());
        for (Integer integer : v) {
            int n = setsList.size();
            for (int i=0; i<n; i++) {
                List<Integer> element = new ArrayList<>(setsList.get(i));
                element.add(integer);
                setsList.add(element);
            }
        }
        return setsList;
    }

    public static void main(String[] args) {
        Integer[][] inputs = {{}, {2, 5, 7}, {1, 2}, {1, 2, 3, 4}, {7, 3, 1, 5}};

        for (int i = 0; i < inputs.length; i++) {
            List<Integer> v = Arrays.asList(inputs[i]);
            List<List<Integer>> subsets = new ArrayList<>();
            System.out.println(i + 1 + ". Set:     " + v);
            subsets = findAllSubsets(v);

            System.out.println("   Subsets: " + subsets.toString());
        }

    }


}
