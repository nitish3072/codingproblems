package leetcode.practice_march2026;

public class Twosum2 {

    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0, rightIndex = numbers.length - 1;
        if (leftIndex == rightIndex) return new int[]{};
        while (leftIndex < rightIndex) {
            int indexSum = numbers[leftIndex] + numbers[rightIndex];
            if(indexSum == target) return new int[] {leftIndex + 1, rightIndex + 1};
            else if(indexSum > target) rightIndex--;
            else leftIndex++;
        }
        return new int[]{};
    }

}
