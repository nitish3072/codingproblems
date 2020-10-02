package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 */
public class StringMatchingInAnArray {

    // "mass", "as", "hero", "superhero"
    public List<String> stringMatching(String[] words) {
        List<String> finalArray = new ArrayList<>();
        for(int i=0; i<words.length;i++) {
            // Checking if String is already present in Final String so that we can ignore that String's loop as it is already present in final
            if(finalArray.contains(words[i])) {
                continue;
            }
            for(int j=i+1;j<words.length;j++) {
                // Checking if String is already present in Final String so that we can ignore that String's loop as it is already present in final
                if(finalArray.contains(words[j]) || finalArray.contains(words[i])) {
                    continue;
                }
                if(words[i].contains(words[j])) {
                    finalArray.add(words[j]);
                } else if(words[j].contains(words[i])) {
                    finalArray.add(words[i]);
                }
            }
        }
        return finalArray;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("jak","yjakdn","tj","yyjakdn"));
        StringMatchingInAnArray stringMatchingInAnArray = new StringMatchingInAnArray();
        System.out.println(stringMatchingInAnArray.stringMatching(list.toArray(new String[0])));
    }
}
