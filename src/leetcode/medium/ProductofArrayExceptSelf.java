package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeros = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                zeros++;
                continue;
            }
            product = product * nums[i];
        }
        int[] products = new int[nums.length];
        for(int i=0; i<nums.length;i++) {
            if(zeros>1) {
                products[i] = 0;
                continue;
            }
            if(zeros>0 && nums[i]==0) {
                products[i] = product;
            } else if(zeros>0 && nums[i]!=0) {
                products[i] = 0;
            } else {
                products[i] = product/nums[i];
            }
        }
        return products;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf productofArrayExceptSelf = new ProductofArrayExceptSelf();
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productofArrayExceptSelf.productExceptSelf(arr)));
    }

}
