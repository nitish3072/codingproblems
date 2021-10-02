package leetcode.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxSum = 0;
        while (i<j) {
            int min = Math.min(height[i], height[j]);
            maxSum = Math.max(min * (j-i), maxSum);
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] height = {1,3,2,5,25,24,5};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }

}
