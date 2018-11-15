import java.util.Scanner;

public class MinCostPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[length][length];
        for(int i=0;i<length;i++) {
            String[] str = scanner.nextLine().split(",");
            for(int j=0;j<length;j++) {
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }

        int i=0, j=0, sum=0;
        while (i!=length&&j!=length){
            sum = sum + arr[i][j];
            if(i==length-1) {
                j=j+1;
                continue;
            }
            if(j==length-1) {
                i=i+1;
                continue;
            }
            if(arr[i+1][j] > arr[i][j+1] && arr[i+1][j+1] > arr[i][j+1]) {
                j = j+1;
            } else if(arr[i+1][j] > arr[i][j+1] && arr[i+1][j+1] < arr[i][j+1]) {
                i=i+1;
                j=j+1;
            } else if(arr[i+1][j] < arr[i][j+1] && arr[i+1][j+1] > arr[i+1][j]) {
                i=i+1;
            } else if(arr[i+1][j] < arr[i][j+1] && arr[i+1][j+1] < arr[i+1][j]) {
                i=i+1;
                j=j+1;
            }
        }
        System.out.println(sum);
    }
}
