package leetcode.practice_march2026;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longestsubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int maxLength = 0;
        int left = 0, right = 1;
        Set<Character> map = new HashSet<>();
        map.add(s.charAt(left));
        while (right < s.length()) {
            if (map.contains(s.charAt(right))) {
                while (map.contains(s.charAt(right))) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            map.add(s.charAt(right));
            right++;
            maxLength = Math.max(maxLength, map.size());
        }
        return maxLength;
    }

}
