package leetcode.medium;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxTillNow = Integer.MIN_VALUE + nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            maxTillNow = Math.max(maxTillNow - 1, nums[i]);
            if (nums[i] == 0 && maxTillNow <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0} ;
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(arr));
    }
}
