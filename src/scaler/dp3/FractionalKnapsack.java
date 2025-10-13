package scaler.dp3;

import scaler.KeyValue;

import java.util.*;

public class FractionalKnapsack {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<KeyValue<Integer, Double>> dp = new PriorityQueue<>((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        for (int i = 0; i < A.size(); i++) {
            dp.add(new KeyValue<>(i, A.get(i) * 1.0 / B.get(i)));
        }
        double value = 0;
        for (int i = 0; i < A.size(); i++) {
            KeyValue<Integer, Double> entry = dp.poll();
            int index = entry.getKey();
            double fraction = entry.getValue();
            if(B.get(index) > C) {
                value += C * fraction;
                break;
            } else {
                value += B.get(index) * fraction;
                C -= B.get(index);
            }
        }
        return (int) (value*100);
    }

    public static void main(String[] args) {
        FractionalKnapsack frac = new FractionalKnapsack();
        ArrayList<Integer> A = new ArrayList<>(List.of(129, 63, 102));
        ArrayList<Integer> B = new ArrayList<>(List.of(31, 12, 23));
        System.out.println(frac.solve(A, B, 50));
    }

}
