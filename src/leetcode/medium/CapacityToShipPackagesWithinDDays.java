package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int a: weights){
            sum += a;
            max = Math.max(a, max);
        }
        int divided = sum % days !=0 ? sum/days + 1 : sum/days;
        if(max > divided) {
            return max;
        }
        int sumArray = 0;
        int maxArray = 0;
        for(int a: weights) {
            sumArray += a;
            if(sumArray>=divided) {
                maxArray = Math.max(sumArray, maxArray);
                sumArray = 0;
            }
        }
        return maxArray;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,4,1,4};
        CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
        System.out.println(capacityToShipPackagesWithinDDays.shipWithinDays(arr, 3));
    }

}
