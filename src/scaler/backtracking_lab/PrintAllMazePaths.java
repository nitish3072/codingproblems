package scaler.backtracking_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintAllMazePaths {
    public ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> list = new ArrayList<>();
        printAllPathsInternal(A, B, 0, 0, list, "");
        return list;
    }

    public void printAllPathsInternal(int A, int B, int i, int j, ArrayList<String> list, String pattern) {
        if (i == A - 1 && j == B - 1) {
            list.add(pattern);
            return;
        }
        if (i + 1 <= A - 1) printAllPathsInternal(A, B, i + 1, j, list, pattern + "D");
        if (j + 1 <= B - 1) printAllPathsInternal(A, B, i, j + 1, list, pattern + "R");
    }

    public static void main(String[] args) {
        PrintAllMazePaths printAllMazePaths = new PrintAllMazePaths();
        printAllMazePaths.PrintAllPaths(3, 2);
    }

}
