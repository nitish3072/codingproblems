package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0; i<T.length; i++) {
           while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
               int index = stack.pop();
               res[index] = i - index;
           }
           stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(arr)));
    }
}
