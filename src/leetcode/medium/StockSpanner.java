package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class StockSpanner {

    public StockSpanner() {

    }

    Stack<int[]> stack = new Stack<>();
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
        System.out.println(S.next(31));
        System.out.println(S.next(41));
        System.out.println(S.next(51));
        System.out.println(S.next(61));
        System.out.println(S.next(71));
    }
}
