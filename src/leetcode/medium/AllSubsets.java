package leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/subsets/
 */
public class AllSubsets {

//    public ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(), A, 0);
//        return list;
//    }
//
//    private void backtrack(ArrayList<ArrayList<Integer>> list , List<Integer> tempList, List<Integer> A, int start){
//        list.add(new ArrayList<>(tempList));
//        for(int i = start; i < A.size(); i++){
//            tempList.add(A.get(i));
//            backtrack(list, tempList, A, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        AllSubsets allSubsets = new AllSubsets();
        int[] arr = {9,20,-11,-8};
        allSubsets.subsets(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public ArrayList<ArrayList<Integer>> subsets(List<Integer> v) {
        ArrayList<ArrayList<Integer>> setsList = new ArrayList<>();
        setsList.add(new ArrayList<>());
        for (Integer integer : v) {
            int n = setsList.size();
            for (int i=0; i<n; i++) {
                ArrayList<Integer> element = new ArrayList<>(setsList.get(i));
                element.add(integer);
                setsList.add(element);
            }
        }
        Collections.sort(setsList, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        return setsList;
    }
}
