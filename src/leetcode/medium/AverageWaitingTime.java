package leetcode.medium;

/**
 * https://leetcode.com/problems/average-waiting-time/
 */
public class AverageWaitingTime {

        public double averageWaitingTime(int[][] customers) {
            double chefDoneTime = customers[0][0];
            double waitingTime = 0;
            for(int i=0; i< customers.length; i++) {
                waitingTime = waitingTime + customers[i][1] + (chefDoneTime - customers[i][0] < 0 ? 0 : chefDoneTime - customers[i][0]);
                chefDoneTime = (chefDoneTime < customers[i][0] ? customers[i][0] : chefDoneTime) + customers[i][1];
            }
            return 1.0 * waitingTime / customers.length;
        }

        public static void main(String[] args) {
            AverageWaitingTime averageWaitingTime = new AverageWaitingTime();
    //        int[][] arr =  {{1,2},{2,5},{4,3}};
    //        int[][] arr =  {{5,2},{5,4},{10,3},{20,1}};
            int[][] arr =  {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
            System.out.println(averageWaitingTime.averageWaitingTime(arr));
        }
}
