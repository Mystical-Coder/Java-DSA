package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteGraph {
    public static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int[] color = new int[graph.length];
        for(int i = 0; i < color.length; i++){
            color[i] = -1; // No color
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                queue.add(i);
                color[i] = 0; //Yellow
                while(!queue.isEmpty()){ //Traverse using BFS
                    int curr = queue.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(color[e.destination] == -1){
                            int nextColor = color[curr] == 0 ? 1 : 0; // change the color
                            color[e.destination] = nextColor;
                            queue.add(e.destination);
                        }else if(color[e.destination] == color[curr]){
                            return false; // No bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) { //O(V + E) because of BFS traversal
        // If doesn't have cycle -> Bipartite graph
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
