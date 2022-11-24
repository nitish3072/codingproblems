package educative.grokkingcodinginterview.kwaymerge;

import java.util.*;

public class FindKPairs {
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i=0; i<list1.length; i++) pq.add(new int[] { list1[i] + list2[0], i, 0 });
        for(int i=0; i<k ; i++) {
            if(pq.isEmpty()) break;
            int[] smallest = pq.poll();
            List<Integer> inter = new ArrayList<>();
            inter.add(list1[smallest[1]]);
            inter.add(list2[smallest[2]]);
            result.add(inter);
            if(smallest[2] + 1 < list2.length) pq.add(new int[] {list1[smallest[1]] + list2[smallest[2] + 1], smallest[1], smallest[2] + 1});
        }
        return result;
    }

    public static void main(String[] args) {

        int[][]list1 = {{2, 8, 9},
                {1, 2, 300},
                {1, 1, 2},
                {4, 6},
                {4, 7, 9},
                {1, 1, 2}
        };

        int[][]list2 = {
                {1, 3, 6},
                {1, 11, 20, 35, 300},
                {1, 2, 3},
                {2, 3},
                {4, 7, 9},
                {1}
        };
        int[] k = {9, 30, 1, 2, 5, 4};
        for(int i=0; i<k.length; i++){
            List<List<Integer>> result = kSmallestPairs(list1[i], list2[i], k[i]);
            System.out.print(i+1);
            System.out.println(".\tInput lists: "+ Arrays.toString(list1[i])+ ", "+ Arrays.toString(list2[i]));
            System.out.println("\tK = "+k[i]);
            System.out.print("\tPairs with smallest sum are: "+ result);
            System.out.println("\n");
        }

    }

}
