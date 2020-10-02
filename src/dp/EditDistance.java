package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            String[] lenStr = reader.readLine().split(" ");
            int len1 = Integer.valueOf(lenStr[0]);
            int len2 = Integer.valueOf(lenStr[1]);
            String[] st = reader.readLine().split(" ");
            String[] string1 = st[0].split("");
            String[] string2 = st[1].split("");

            // Logic starts
            int[] arrayPresent = new int[len1];
            for(int i=0;i<string1.length;i++) {
                for(String str2: string2) {
                    if(string1[i].equals(str2)) {
                        arrayPresent[i]=1;
                    }
                }
            }


        }
    }
}
