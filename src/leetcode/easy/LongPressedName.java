package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        List<Group> nameList = new ArrayList<>();
        List<Group> typedList = new ArrayList<>();
        String[] split = name.split("");
        int count = 0;
        int i = 0;
        int j = 0;
        while (j<name.length()) {
            if(j == name.length()-1) {
                nameList.add(new Group(split[j], count==0 ? 1 : count));
                j++;
            } else if(split[i].equals(split[j])) {
                j++;
                count++;
            } else if(!split[i].equals(split[j])){
                nameList.add(new Group(split[i], count));
                count = 1;
                i=j;
            }
        }

        split = typed.split("");
        count = 0;
        i = 0;
        j = 0;
        while (j<typed.length()) {
            if(j == typed.length()-1) {
                typedList.add(new Group(split[j], count==0 ? 1 : count));
                j++;
            } else if(split[i].equals(split[j])) {
                j++;
                count++;
            } else if(!split[i].equals(split[j])){
                typedList.add(new Group(split[i], count));
                count = 1;
                i=j;
            }
        }

        if (nameList.size()!=typedList.size()) {
            return false;
        }

        for (i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).count > typedList.get(i).count || !nameList.get(i).key.equals(typedList.get(i).key) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex",
                "aaleex"));
    }


}

class Group {

    String key;
    Integer count;

    Group(String k, Integer c) {
        key = k;
        count = c;
    }

}
