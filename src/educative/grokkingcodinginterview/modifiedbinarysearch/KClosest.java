package educative.grokkingcodinginterview.modifiedbinarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class KClosest {

    public static List<Integer> findClosestElements(int[] nums, int k, int num) {
        int index = binarySearch(nums, num);
        int left = Math.max(index - 1, 0), right = left + 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            if (left == -1) {
                result.add(nums[right]);
                right++;
            } else if (right == nums.length) {
                result.add(nums[left]);
                left--;
            } else if (Math.abs(nums[left] - num) > Math.abs(nums[right] - num)) {
                result.add(nums[right]);
                right++;
            } else {
                result.add(nums[left]);
                left--;
            }
        }
        Collections.sort(result);
        return result;
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = (left + right)/ 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {

        int[][]inputs={
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5},
                {1, 2, 4, 5, 6},
                {1, 2, 3, 4, 5, 10},
                {0,0,1,2,3,3,4,7,7,8},
                {1,2,3,4,5}
        };
        int[] k = {4, 4, 2, 3, 3, 4};
        int[] x = {4, 3, 10, -5, 5, -1};
        for(int i=0; i<k.length; i++){
            List<Integer> kList = findClosestElements(inputs[i], k[i], x[i]);
            System.out.print(i+1);
            System.out.println(".\tThe "+k[i]+" closest elements for the number "+x[i]+ " in the array "+ Arrays.toString(inputs[i])+ " are: ");
            System.out.print("\t[");
            for(int j = 0; j < k[i]-1; j++) {
                System.out.print(kList.get(j) + ", ");
            }
            System.out.println(kList.get(k[i]-1) + "]");
        }

    }
}
