package scaler.graph2;

import java.util.*;

public class CommutableIslands {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Pair>> adjList = makeAdjList(B);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
        Map<Integer, Boolean> visited = new HashMap<>();
        int sum = 0;
        visited.put(B.get(0).get(0), Boolean.TRUE);
        pq.addAll(adjList.get(B.get(0).get(0)));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (visited.getOrDefault(p.v, Boolean.FALSE)) {
                continue;
            }
            visited.put(p.v, Boolean.TRUE);
            sum += p.wt;
            for (Pair i : adjList.get(p.v)) {
                if (!visited.getOrDefault(i.v, Boolean.FALSE)) {
                    pq.add(i);
                }
            }
        }
        return sum;
    }

    public Map<Integer, List<Pair>> makeAdjList(ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            if (adjList.containsKey(B.get(i).get(0))) {
                adjList.get(B.get(i).get(0)).add(new Pair(B.get(i).get(2), B.get(i).get(1)));
            } else {
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(B.get(i).get(2), B.get(i).get(1)));
                adjList.put(B.get(i).get(0), list);
            }
            if(adjList.containsKey(B.get(i).get(1))) {
                adjList.get(B.get(i).get(1)).add(new Pair(B.get(i).get(2), B.get(i).get(0)));
            } else {
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(B.get(i).get(2), B.get(i).get(0)));
                adjList.put(B.get(i).get(1), list);
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        CommutableIslands g = new CommutableIslands();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2, 1)));
        A.add(new ArrayList<>(List.of(2, 3, 4)));
        A.add(new ArrayList<>(List.of(1, 4, 3)));
        A.add(new ArrayList<>(List.of(4, 3, 2)));
        A.add(new ArrayList<>(List.of(1, 3, 10)));
        System.out.println(g.solve(4, A));
    }

    private class Pair {
        public Pair(int wt, int v) {
            this.wt = wt;
            this.v = v;
        }
        public int wt, v;
    }

}
