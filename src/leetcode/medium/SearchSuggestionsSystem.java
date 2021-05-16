package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int[] commonSuffixArr = new int[products.length];
        for(int i=0;i< products.length; i++) {
            int commonLength = 0;
            for(int j=0; j<searchWord.length()&&j<products[i].length(); j++) {
                if(products[i].charAt(j) == searchWord.charAt(j)) {
                    commonLength++;
                } else {
                    break;
                }
            }
            commonSuffixArr[i] = commonLength;
        }
        List<List<String>> finalist = new ArrayList<>();
        for(int i=1; i<=searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            for(int j=0; j<commonSuffixArr.length; j++) {
                if(commonSuffixArr[j]>=i && list.size()<3) {
                    list.add(products[j]);
                }
            }
            finalist.add(list);
        }
        return finalist;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        searchSuggestionsSystem.suggestedProducts(products, searchWord);
    }

}
