package leetcode.medium;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumberCount> mapOfNumbers = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mapOfNumbers.put(nums[i], mapOfNumbers.containsKey(nums[i]) ? new NumberCount(nums[i], mapOfNumbers.get(nums[i]).count + 1) : new NumberCount(nums[i], 1));
        }
        List<NumberCount> alphabetCountsList = new ArrayList<>(mapOfNumbers.values());
        mapOfNumbers = new HashMap<>();
        alphabetCountsList.sort(Comparator.comparingInt(value -> -1 * value.count));
        return alphabetCountsList.subList(0, k).stream().map(numberCount -> numberCount.number).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,2,3,2,1,3,4,5,3,2,3,4,4,5,5,6,6};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 3)));
    }
}


class NumberCount {
    Integer number;
    Integer count;

    public NumberCount(int number, int count) {
        this.number = number;
        this.count = count;
    }

}
