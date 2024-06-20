package Graph;

import java.util.ArrayList;

/**
 * AllPath
 */
public class AllPath {

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
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void getPath(ArrayList<Edge>[] graph, int source, int destination, String path){
        if(source == destination){
            System.out.print(path+destination+" ");
            return;
        }
        for(int i = 0; i < graph[source].size(); i++){
            Edge e = graph[source].get(i);
            getPath(graph, e.destination, destination, path+source);
        }
    }

    public static void main(String[] args) { // O(V^V)
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 5, des = 1;
        getPath(graph, src, des, "");
    }
}