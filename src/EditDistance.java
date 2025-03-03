import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ar1 = scanner.nextLine().split(",");
        String[] ar2 = scanner.nextLine().split(",");
        for(int i=0,j=0;;){
            if(ar1[i].equalsIgnoreCase(ar2[j])) {
                i++;j++;
            } else {
                break;
            }
        }
        for(int i=ar1.length,j=ar2.length;;){
            if(ar1[i].equalsIgnoreCase(ar2[j])) {
                i--;j--;
            } else {
                break;
            }
        }
    }
}

