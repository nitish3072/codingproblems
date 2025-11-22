package scaler.graph2;

import java.util.*;

public class ConstructionCost {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if(B.isEmpty()) return 0;
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
            sum = (sum + p.wt) % 1000000007;
            for (Pair i : adjList.get(p.v)) {
                if (!visited.getOrDefault(i.v, Boolean.FALSE)) {
                    pq.add(i);
                }
            }
        }
        return sum % 1000000007;
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
        ConstructionCost g = new ConstructionCost();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2, 14)));
        A.add(new ArrayList<>(List.of(2, 3, 7)));
        A.add(new ArrayList<>(List.of(3, 1, 2)));
        System.out.println(g.solve(3, A));
    }

    private class Pair {
        public Pair(int wt, int v) {
            this.wt = wt;
            this.v = v;
        }
        public int wt, v;
    }

}
