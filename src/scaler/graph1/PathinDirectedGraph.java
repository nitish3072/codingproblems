package scaler.graph1;

import java.util.*;

public class PathinDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjList = makeAdjList(B);
        boolean[] visited = new boolean[A + 1];
        if (dfs(1, A, visited, adjList)) return 1;
        return 0;
    }

    public boolean dfs(Integer v, Integer A, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        visited[v] = true;
        for (Integer i : adjList.get(v)) {
            if(Objects.equals(i, A)) return true;
            if (!visited[i]) {
                if (dfs(i, A, visited, adjList)) {
                    return true;
                }
            }
        }
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
            if (!adjList.containsKey(B.get(i).get(1))) {
                adjList.put(B.get(i).get(1), new ArrayList<>());
            }
        }
        return adjList;
    }

    public static void main(String[] args) {
        PathinDirectedGraph pathinDirectedGraph = new PathinDirectedGraph();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(1, 2)));
        A.add(new ArrayList<>(List.of(4,1)));
        A.add(new ArrayList<>(List.of(2, 4)));
        A.add(new ArrayList<>(List.of(3,4)));
        A.add(new ArrayList<>(List.of(5,2)));
        A.add(new ArrayList<>(List.of(1,3)));
        System.out.println(pathinDirectedGraph.solve(5, A));
    }

}
