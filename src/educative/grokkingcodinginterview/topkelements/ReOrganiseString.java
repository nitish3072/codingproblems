package educative.grokkingcodinginterview.topkelements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReOrganiseString {
    public static String reorganizeString(String s) {
        int[] arr = new int[26];
        char maxFreq = s.charAt(0);
        for (char c : s.toCharArray()) {
            arr[c - 'a'] = arr[c - 'a'] + 1;
            if (arr[c - 'a'] > arr[maxFreq - 'a']) {
                maxFreq = c;
            }
        }
        if (s.length() % 2 == 0 ? arr[maxFreq - 'a'] > s.length() / 2 : arr[maxFreq - 'a'] > s.length() / 2 + 1) {
            return "";
        }
        char[] result = new char[s.length()];
        int resIndex = 0;
        for (int i = -1; i < 26; i++) {
            char c = i == -1 ? maxFreq : (char) (i + 'a');
            while (arr[c - 'a']-- > 0) {
                result[resIndex] = c;
                resIndex = resIndex + 2 >= s.length() ? 1 : resIndex + 2;
            }
        }
        return new String(result);
    }

    public static void main(String args[]) {
        String[] inputs = {
                "programming",
                "hello",
                "fofjjb",
                "abbacdde",
                "aba",
                "awesome",
                "aaab"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: " + inputs[i]);
            System.out.println("\n\tReorganize string: "+ reorganizeString(inputs[i]));
        }

    }

}
