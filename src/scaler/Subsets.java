package scaler;

import java.util.ArrayList;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        printSubsets(0, new ArrayList<>(), A, list);
        return list;
    }

    public void printSubsets(int index, ArrayList<Integer> currList, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {
        if(index==A.size()) {
            list.add(new ArrayList<>(currList));
            return;
        }
        printSubsets(index+1, currList, A, list);
        currList.add(A.get(index));
        printSubsets(index+1, currList, A, list);
        currList.remove(currList.size()-1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> list1 = subsets.subsets(list);
        for (ArrayList<Integer> integers : list1) {
            System.out.println(integers);
        }
    }
}
