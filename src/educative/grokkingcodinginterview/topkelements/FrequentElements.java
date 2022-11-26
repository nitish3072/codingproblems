package educative.grokkingcodinginterview.topkelements;

import java.util.*;
import java.util.stream.Collectors;

public class FrequentElements {

    public static List<Integer> topKFrequent(int[] arr, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : arr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Integer key : frequencyMap.keySet()) {
            pq.add(new int[]{frequencyMap.get(key), key});
            while (pq.size() > k) pq.poll();
        }

        return pq.stream().map(a -> a[1]).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Driver code
        int[][] inputs = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 4, 2};
        for(int i=0; i<inputK.length; i++){
            List<Integer> result = topKFrequent(inputs[i], inputK[i]);
            System.out.print(i+1);
            System.out.println(".\tInput: (" + Arrays.toString(inputs[i])+ ", "+ inputK[i]+ ")");
            System.out.println("\n\tTop "+ inputK[i]+ " frequent elements: " + result);
        }

    }

}
