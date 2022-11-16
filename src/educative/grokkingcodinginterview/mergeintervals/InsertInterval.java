package educative.grokkingcodinginterview.mergeintervals;

import java.util.*;

class InsertInterval {

    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        LinkedList<Interval> output = new LinkedList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < existingIntervals.size(); i++) {
            Interval interval = existingIntervals.get(i);
            if (interval.start <= newInterval.start && interval.end >= newInterval.start) {
                start = interval.start;
                continue;
            } else if (interval.start <= newInterval.end && interval.end >= newInterval.end) {
                end = interval.end;
                output.add(new Interval(start, end));
                continue;
            }
            if (start == -1 && end == -1) {
                output.add(interval);
            } else if (start != -1 && end != -1) {
                output.add(interval);
            }
        }
        if (start == -1 && end == -1 && newInterval.start < existingIntervals.get(0).start) {
            output.add(0, newInterval);
        } else if(start == -1 && end == -1 && newInterval.start > existingIntervals.get(existingIntervals.size()-1).end) {
            output.add(newInterval);
        }
        return output;
    }

    public static void main(String args[]) {
        Interval newInterval = new Interval(5, 7);
        List<Interval> existingIntervals = Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 8));
        insertInterval(existingIntervals, newInterval);
    }

}
