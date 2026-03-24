package leetcode.practice_march2026;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        int res = containerWithMostWater.maxArea(arr);
        System.out.println(res);
    }

}
