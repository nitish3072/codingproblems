package leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * https://www.youtube.com/watch?v=uFso48YRRao&ab_channel=VivekanandKhyade-AlgorithmEveryDay
 * Keep a stack which saves index. nums[index] is always decreasing in the stack.
 * Once you find an element which is bigger than the top element in the stack, the element is the next greater number for the top element in the stack.
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> indexStack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int length = nums.length;
        for(int i=0; i<2*length; i++) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i%length]) {
                res[indexStack.pop()] = nums[i%length];
            }
            indexStack.add(i%length);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] arr = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElementII.nextGreaterElements(arr)));
    }

}
