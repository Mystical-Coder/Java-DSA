package Graph;

import java.util.ArrayList;

public class CycleDetectionDirected {
    public static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){ // True case
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

    }

    // public static void createGraph(ArrayList<Edge> graph[]){ // false case
    //     for(int i = 0; i < graph.length; i++){
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));
    //     graph[1].add(new Edge(1, 3));
    //     graph[2].add(new Edge(2, 3));

    // }

    public static boolean cycleDetection(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(cycleDetectionUtils(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionUtils(ArrayList<Edge> graph[], int curr, boolean[] visited, boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.destination]){
                return true;
            }
            if(!visited[e.destination] && cycleDetectionUtils(graph, e.destination, visited, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(cycleDetection(graph));
    }
}
