package leetcode.medium;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class MeetingRoomsProblemCarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        int maxDistance = 0;
        for(int i=0; i<trips.length; i++) {
            maxDistance = Math.max(trips[i][2], maxDistance);
        }

        int[] locations = new int[maxDistance + 1];
        for(int[] trip: trips) {
            locations[trip[1]] = locations[trip[1]] + trip[0];
            locations[trip[2]] = locations[trip[2]] - trip[0];
        }

        for(int i=0; i<locations.length; i++) {
            capacity -= locations[i];
            if(capacity < 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        MeetingRoomsProblemCarPooling carPooling = new MeetingRoomsProblemCarPooling();
        int[][] arr = {{2,1,5},{3,5,7}};
        System.out.println(carPooling.carPooling(arr, 3));
    }

}
