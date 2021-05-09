package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> alreadyVisitedRoom = new HashSet<>();
        alreadyVisitedRoom.add(0);
        visitingARoom(0, alreadyVisitedRoom, rooms);
        return alreadyVisitedRoom.size() == rooms.size();
    }

    public void visitingARoom(int i, Set<Integer> alreadyVisitedRoom, List<List<Integer>> rooms) {
        for(Integer key: rooms.get(i)) {
            if(!alreadyVisitedRoom.contains(key)) {
                alreadyVisitedRoom.add(key);
                visitingARoom(key, alreadyVisitedRoom, rooms);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        list.add(arr);
        arr = new ArrayList<>();
        arr.add(3);
        arr.add(0);
        arr.add(1);
        list.add(arr);
        arr = new ArrayList<>();
        arr.add(2);
        list.add(arr);
        arr = new ArrayList<>();
        arr.add(0);
        list.add(arr);
        KeysAndRooms keysandRooms = new KeysAndRooms();
        System.out.println(keysandRooms.canVisitAllRooms(list));
    }
}
