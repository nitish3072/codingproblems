package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class Frequencyofelementquery {

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer elem : A) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }

        ArrayList<Integer> finalList = new ArrayList<>();
        for (Integer f : B) {
            finalList.add(map.getOrDefault(f, 0));
        }
        return finalList;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,1,1};
        int[] ints2 = new int[]{1,2};
        Frequencyofelementquery frequencyofelementquery = new Frequencyofelementquery();
        System.out.println(frequencyofelementquery.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), Arrays.stream(ints2).boxed().collect(Collectors.toList())));
    }

}
