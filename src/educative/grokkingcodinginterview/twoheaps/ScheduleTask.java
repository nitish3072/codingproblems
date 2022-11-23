package educative.grokkingcodinginterview.twoheaps;

import java.util.*;

public class ScheduleTask {

    public static int tasks(ArrayList<ArrayList<Integer>> tasksList) {
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pickedUpTaskQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (ArrayList<Integer> integers : tasksList) {
            taskQueue.add(new int[] {integers.get(0), integers.get(1)});
        }

        int machines = 1;
        pickedUpTaskQueue.add(taskQueue.poll());
        while (!taskQueue.isEmpty()) {
            if(pickedUpTaskQueue.isEmpty() || pickedUpTaskQueue.peek()[1] <= taskQueue.peek()[0]) {
                pickedUpTaskQueue.poll();
            } else {
                machines++;
            }
            pickedUpTaskQueue.add(taskQueue.poll());
        }
        return machines;
    }

    public static void main(String[] args) {
        //  Input: A set "tasks_list" of "n" tasks, such that
        // each taskList has a start time and a finish time
        List < List <List< Integer >>> inputs = Arrays.asList(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(5, 5), Arrays.asList(8, 8), Arrays.asList(4, 4), Arrays.asList(6, 6), Arrays.asList(10, 10), Arrays.asList(7, 7)), Arrays.asList(Arrays.asList(1, 7), Arrays.asList(1, 7), Arrays.asList(1, 7), Arrays.asList(1, 7), Arrays.asList(1, 7), Arrays.asList(1, 7)), Arrays.asList(Arrays.asList(1, 7), Arrays.asList(8, 13), Arrays.asList(5, 6), Arrays.asList(10, 14), Arrays.asList(6, 7)), Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 5), Arrays.asList(5, 9), Arrays.asList(9, 12), Arrays.asList(12, 13), Arrays.asList(13, 16), Arrays.asList(16, 17)), Arrays.asList(Arrays.asList(12, 13), Arrays.asList(13, 15), Arrays.asList(17, 20), Arrays.asList(13, 14), Arrays.asList(19, 21), Arrays.asList(18, 20)));
        // loop to execute till the length of tasks
        ArrayList<ArrayList<ArrayList<Integer>>> inputTaskList = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int j = 0; j < inputs.size(); j++)
        {
            inputTaskList.add(new ArrayList<ArrayList<Integer>>());
            for(int k = 0; k < inputs.get(j).size(); k++)
            {
                inputTaskList.get(j).add(new ArrayList<Integer>());
                for(int g = 0; g < inputs.get(j).get(k).size(); g++)
                {
                    inputTaskList.get(j).get(k).add(inputs.get(j).get(k).get(g));
                }
            }
        }
        for (int i = 0; i < inputTaskList.size(); i++) {
            System.out.println(i + 1 + ".\tTask = " + inputTaskList.get(i).toString());
            // Output: A non-conflicting schedule of tasks in
            // "tasks_list" using the minimum number of machines
            System.out.println("\tOptimal number of machines = " + tasks(inputTaskList.get(i)));
        }
    }
}
