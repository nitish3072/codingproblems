package scaler.backtracking_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintpathsinStaircase {

    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        generatePaths(A, new ArrayList<>(), res);
        return res;
    }

    public void generatePaths(int A, List<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        if (A == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        generatePaths(A - 1, Stream.concat(ans.stream(), Stream.of(1)).collect(Collectors.toList()), res);
        if(A>=2) {
            generatePaths(A - 2, Stream.concat(ans.stream(), Stream.of(2)).collect(Collectors.toList()), res);
        }
    }

    public static void main(String[] args) {
        PrintpathsinStaircase sortedInsertPosition = new PrintpathsinStaircase();
        System.out.println(sortedInsertPosition.WaysToClimb(10));
    }

}
