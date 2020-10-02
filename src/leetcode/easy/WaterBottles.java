package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/water-bottles/
 */
public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        return calculateNumberBottles(0, numBottles, numExchange, 0);
    }

    public int calculateNumberBottles(int emptyBottles, int filledBottle, int numExchange, int totalDrinks) {
        if(filledBottle == 0 && emptyBottles < numExchange) {
            return totalDrinks;
        } else {
            if(filledBottle==0) {
                // Exchange
                return calculateNumberBottles(
                        (emptyBottles + filledBottle) % numExchange,
                        (emptyBottles + filledBottle) / numExchange,
                        numExchange,
                        totalDrinks
                );
            } else {
                // Drink
                return calculateNumberBottles(
                        emptyBottles + filledBottle,
                        0,
                        numExchange,
                        totalDrinks + filledBottle
                );
            }
        }
    }

    public static void main(String[] args) {
        WaterBottles waterBottles = new WaterBottles();
        System.out.println(waterBottles.numWaterBottles(9, 3));
    }
}
