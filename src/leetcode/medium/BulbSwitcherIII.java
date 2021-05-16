package leetcode.medium;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 */
public class BulbSwitcherIII {

    public int numTimesAllBlue(int[] light) {
        int maxBulbLighted = 0;
        int res = 0;
        for(int i=0; i<light.length; i++) {
            maxBulbLighted = Math.max(maxBulbLighted, light[i]);
            if(maxBulbLighted<=i+1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BulbSwitcherIII bulbSwitcherIII = new BulbSwitcherIII();
        int[] arr = {2,1,3,5,4};
        System.out.println(bulbSwitcherIII.numTimesAllBlue(arr));
    }

}
