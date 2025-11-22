package scaler.graph1;

import java.util.*;

public class CycleDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjList = makeAdjList(B);
        boolean[] visited = new boolean[A + 1];
        boolean[] path = new boolean[A + 1];
        for (Integer key : adjList.keySet()) {
            if (dfs(key, visited, path, adjList))
                return 1;
        }
        return 0;
    }

    public boolean dfs(Integer v, boolean[] visited, boolean[] path, Map<Integer, List<Integer>> adjList) {
        visited[v] = true;
        path[v] = true;
        for (Integer i : adjList.get(v)) {
            if (path[i]) {
                return true;
            }
            if(!visited[i]) {
                if(dfs(i, visited, path, adjList)) {
                    return true;
                }
            }
        }
        path[v] = false;
        return false;
    }

    public Map<Integer, List<Integer>> makeAdjList(ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            if (adjList.containsKey(B.get(i).get(0))) {
                adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(B.get(i).get(1));
                adjList.put(B.get(i).get(0), list);
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        CycleDirectedGraph g = new CycleDirectedGraph();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2)));
        A.add(new ArrayList<>(List.of(2, 3)));
        A.add(new ArrayList<>(List.of(3, 4)));
        System.out.println(g.solve(4, A));
    }

}