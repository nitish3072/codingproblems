import java.util.List;
import java.util.Scanner;

public class MissingNumberInArray {

    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner (System.in);
        int totalCases = sc.nextInt();
        while (totalCases>0) {
            int size = sc.nextInt();
            sc.nextLine();
            String[] array = sc.nextLine().split(" ");
            int sum = size*(size+1)/2;
            int sumOfArray = 0;
            for(String str: array) {
                sumOfArray += Integer.valueOf(str);
            }
            System.out.println(sum - sumOfArray);
            totalCases--;
        }
    }

}
