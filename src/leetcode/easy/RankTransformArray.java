package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class RankTransformArray {

    public int[] arrayRankTransform(int[] arr) {
        String[] strArr = new String[arr.length];
        for(int i=0; i<arr.length; i++) {
            strArr[i] = i + "," + arr[i];
        }
        strArr = Arrays.stream(strArr).sorted(Comparator.comparingInt(value -> Integer.valueOf(value.split(",")[1]))).toArray(String[]::new);
        int currentRank = 1;
        for(int i=0;i<strArr.length;i++) {
            if(i==0) {
                strArr[i] = strArr[i] + "," + currentRank;
            } else if(Integer.valueOf(strArr[i].split(",")[1]).equals(Integer.valueOf(strArr[i - 1].split(",")[1]))) {
                strArr[i] = strArr[i] + "," + currentRank;
            } else {
                strArr[i] = strArr[i] + "," + (currentRank + 1);
                currentRank = currentRank + 1;
            }
        }
        for(String str: strArr) {
            int index = Integer.valueOf(str.split(",")[0]);
            int value = Integer.valueOf(str.split(",")[2]);
            arr[index] = value;
        }
        return arr;
    }

    public static void main(String[] args) {
        RankTransformArray rankTransformArray = new RankTransformArray();
        int[] arr = {37,12,28,9,100,56,80,5,12,100};
        System.out.println(Arrays.toString(rankTransformArray.arrayRankTransform(arr)));
    }

}
