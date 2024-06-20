package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalBfs {
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

    public static void calculateIndegree(ArrayList<Edge> graph[], int[] indegree){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.destination]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int[] indegree = new int[graph.length];
        calculateIndegree(graph, indegree);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.remove();
            System.out.print(curr+" ");
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.destination]--;
                if(indegree[e.destination] == 0){
                    queue.add(e.destination);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
