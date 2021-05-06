package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * https://www.youtube.com/watch?v=uFso48YRRao&ab_channel=VivekanandKhyade-AlgorithmEveryDay
 * Keep a stack which saves index. nums[index] is always decreasing in the stack.
 * Once you find an element which is bigger than the top element in the stack, the element is the next greater number for the top element in the stack.
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] res2 = new int[nums2.length];
        Arrays.fill(res2, -1);
        for(int i=0; i<nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                res2[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        int[] res1 = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                if(nums1[i]==nums2[j]) {
                    res1[i] = res2[j];
                }
            }
        }
        return res1;
    }

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElementI.nextGreaterElement(arr1, arr2)));
    }

}
