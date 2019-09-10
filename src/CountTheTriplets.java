import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 */

public class CountTheTriplets {

    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner (System.in);
        Integer testCases = sc.nextInt();
        for(int i=0;i<testCases;i++) {
            Integer size = sc.nextInt();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");
            triplets(str);

        }
    }

    private static void triplets(String[] str) {
        List<Integer> result = new ArrayList<>();
        for (String s : str) {
            Integer integer = Integer.valueOf(s);
            result.add(integer);
        }
        result.sort(null);
        Integer[] list = result.toArray(new Integer[0]);
        Map<Integer, Integer> m = new HashMap<>();
        for(Integer elem: list) {
            m.put(elem,elem);
        }
        Integer count = 0;
        for(int i=0;i<list.length;i++) {
            for(int j=i+1;j<list.length;j++) {
                if(m.containsKey(list[i]+list[j])) {
                    count++;
                }
            }
        }
        System.out.println(count==0?-1:count);
    }

}
