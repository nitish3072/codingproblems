package leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> list = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            List<String> listAdded = list.getOrDefault(new String(arr), new ArrayList<>());
            listAdded.add(str);
            list.put(new String(arr), listAdded);
        }
        return new ArrayList<>(list.values());
    }

    public boolean ifAnagrams(char[] str1, char[] str2) {
        int[] count = new int[26];
        if(str1.length!=str2.length) {
            return false;
        }
        for(int i = 0; i < str1.length; i++) {
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(arr);
    }

}
