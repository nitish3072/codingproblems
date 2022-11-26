package educative.grokkingcodinginterview.topkelements;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ClosestPoints {

    public static List<Point> kClosest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
        for (Point point : points) {
            maxHeap.add(point);
            while (maxHeap.size()>k) maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}

