package leetcode.practice_march2026;

public class RainWaterTrapped {

    public int trap(int[] height) {
        int water = 0;
        int leftPointer = 0, rightPointer = height.length - 1;
        int maxLeft = height[leftPointer], maxRight = height[rightPointer];
        while (leftPointer < rightPointer) {
            if(height[leftPointer] < height[rightPointer]) {
                water += Math.max(maxLeft - height[leftPointer] , 0);
                maxLeft = Math.max(height[leftPointer], maxLeft);
                leftPointer++;
            } else{
                water += Math.max(maxRight - height[rightPointer], 0);
                maxRight = Math.max(height[rightPointer], maxRight);
                rightPointer--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        int[] waterLevels = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rainWaterTrapped.trap(waterLevels));
    }

}
