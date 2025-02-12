package educative.grokkingcodinginterview.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KSumSubsets {

    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        subset(result, new ArrayList<>(), setOfIntegers, new int[setOfIntegers.size()], 0, targetSum);
        return result;
    }

    public static void subset(List<List<Integer>> result, List<Integer> numbers, List<Integer> setOfIntegers, int[] visited, int currentSum, int targetSum) {
        if (currentSum == targetSum) {
            List<Integer> list = numbers.stream().map(setOfIntegers::get).collect(Collectors.toList());
            result.add(new ArrayList<>(list));
        } else if(currentSum<targetSum) {
            for (int i = 0; i < setOfIntegers.size(); i++) {
                if (visited[i] == 1) continue;
                numbers.add(i);
                currentSum = currentSum + setOfIntegers.get(i);
                visited[i] = 1;
                subset(result, numbers, setOfIntegers, visited, currentSum, targetSum);
                visited[numbers.get(numbers.size() - 1)] = 0;
                currentSum = currentSum - setOfIntegers.get(numbers.remove(numbers.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] inputs = {{1, 2, 1}, {1, 2, 1, 1}, {4}};

        for (int i = 0; i < inputs.length; i++) {
            List<Integer> v = Arrays.asList(inputs[i]);
            List<List<Integer>> subsets = new ArrayList<>();
            System.out.println(i + 1 + ". Set:     " + v);
            subsets = getKSumSubsets(v, 2);
            System.out.println("   Subsets: " + subsets.toString());
        }

    }
}
