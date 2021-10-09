package leetcode.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int intMax = Integer.MAX_VALUE - nums.length;
        int[] dp = new int[nums.length];
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]==0) {
                dp[i] = intMax;
            } else {
                int j= Math.min(nums[i], nums.length - 1 - i);
                int min = intMax;
                while (j>0) {
                    min = Math.min(min, dp[i+j]);
                    j--;
                }
                dp[i]=min+1;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
      int[] arr = {5,9,3,2,1,0,2,3,3,1,0,0} ;
      JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.jump(arr));
    }

}
