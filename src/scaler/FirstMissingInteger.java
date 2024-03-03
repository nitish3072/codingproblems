package scaler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingInteger {

    public int firstMissingPositive(List<Integer> A) {
        int n = A.size();
        int i = 0;
        while( i < n){
            if(A.get(i) > 0 && A.get(i) <= n && A.get(i) != A.get(A.get(i) - 1)){
                swap(i,A.get(i) - 1, A);
            }else{
                i++;
            }
        }
        for(i = 0;i<n;i++){
            if(A.get(i) != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }

    public void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 4, -1, 1};
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        System.out.println(firstMissingInteger.firstMissingPositive(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
