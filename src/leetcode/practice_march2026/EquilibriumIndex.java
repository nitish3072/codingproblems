package leetcode.practice_march2026;

public class EquilibriumIndex {

    public int equilibriumPoint(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1 || arr.length == 2) return 0;
        int suffixSum = 0, prefixSum = 0;
        suffixSum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
        }

        prefixSum = arr[0];
        suffixSum = suffixSum - arr[0];
        for (int i = 1; i <= arr.length - 2; i++) {
            suffixSum = suffixSum - arr[i];
            if (prefixSum == suffixSum) return i;
            prefixSum = prefixSum + arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumIndex equilibriumIndex = new EquilibriumIndex();
        int[] arr = new int[] {1,2,0,3};
        int res = equilibriumIndex.equilibriumPoint(arr);
        System.out.println(res);
    }

}
