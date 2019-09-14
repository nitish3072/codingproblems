import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-platforms/0
 */


// Calculate the platform overlaps using a 2d array and populating the how many platforms were occupied at a certain time. Keep updating the list while on it.
public class MinimumPlatformsOverlaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases > 0) {
            int size = sc.nextInt();
            sc.nextLine();
            testCases--;
            int[][] intervals = new int[24][60];
            String[] startTime = Arrays.stream(sc.nextLine().split(" ")).limit(size).toArray(String[]::new);
            String[] endTime = Arrays.stream(sc.nextLine().split(" ")).limit(size).toArray(String[]::new);
            int maxStationsOccupied = 0;
            for (int i = 0; i < startTime.length; i++) {
                Integer startHour = Integer.valueOf(startTime[i].length()==3 ? startTime[i].substring(0, 1) : startTime[i].substring(0, 2));
                Integer startMinute = Integer.valueOf(startTime[i].length()==3 ? startTime[i].substring(1, 3) : startTime[i].substring(2, 4));
                Integer endHour = Integer.valueOf(endTime[i].length()==3 ? endTime[i].substring(0, 1) : endTime[i].substring(0, 2));
                Integer endMinute = Integer.valueOf(endTime[i].length()==3 ? endTime[i].substring(1, 3) : endTime[i].substring(2, 4));
                for (int j = startHour; j <= endHour; j++) {
                    for (int k = 0; k <= 59; k++) {
                        if(j==startHour && k<startMinute) {
                        } else if(j==endHour && k>endMinute) {
                        } else {
                            intervals[j][k] += 1;
                            if(intervals[j][k]>maxStationsOccupied) {
                                maxStationsOccupied = intervals[j][k];
                            }
                        }
                    }
                }
            }
            System.out.println(maxStationsOccupied);
        }
    }
}
