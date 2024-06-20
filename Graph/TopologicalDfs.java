package Graph;

import java.util.ArrayList;
import java.util.Stack;


public class TopologicalDfs {
    public static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) { // True case
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0, 1 -> because wo kisi se connected nhi hai lekin wo graph main hai.
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topSort(ArrayList<Edge> graph[]){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                topSortUtil(graph, s, i, visited);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() +" ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], Stack<Integer> s, int curr, boolean[] visited){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                topSortUtil(graph, s, e.destination, visited);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) { // O(V + E)
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        topSort(graph);
    }
}
