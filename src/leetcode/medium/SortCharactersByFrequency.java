package leetcode.medium;

import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, AlphabetCount> countAlphabet = new HashMap<>();
        for(char c: s.toCharArray()) {
            countAlphabet.put(c, countAlphabet.containsKey(c) ? new AlphabetCount(c, countAlphabet.get(c).count + 1) : new AlphabetCount(c,1));
        }
        List<AlphabetCount> alphabetCountsList = new ArrayList<>(countAlphabet.values());
        countAlphabet = new HashMap<>();
        alphabetCountsList.sort((o1, o2) -> {
            Integer x1 = o1.count;
            Integer x2 = o2.count;
            int sComp = x1.compareTo(x2) * -1;

            if (sComp != 0) {
                return sComp;
            }

            Character y1 = o1.c;
            Character y2 = o2.c;
            return y1.compareTo(y2);

        });
        StringBuilder sBuilder = new StringBuilder();
        for(AlphabetCount alphabetCount: alphabetCountsList) {
            for(int i=0; i<alphabetCount.count;i++) {
                sBuilder.append(alphabetCount.c);
            }
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("uyagufyvuabegyowgbqibfuysvbeiabuwvfuyabeigoinrhjhsbdmvncjhvnuwkbeyyiuoiugwiueyiholjwnkhzgvforuhsebaisufnib"));
    }
}

class AlphabetCount {
    char c;
    int count;

    public AlphabetCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}
