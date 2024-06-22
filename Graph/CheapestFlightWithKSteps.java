package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKSteps {

    static class Edge{
        int source;
        int destination;
        int cost;
        public Edge(int source, int destination, int cost){
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void createGraph(int[][] flights, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < flights.length; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];
            Edge e = new Edge(s, d, c);
            graph[s].add(e);
        }
    }

    public static class Info{
        int v;
        int cost;
        int steps;
        public Info(int v, int cost, int steps) {
            this.v = v;
            this.cost = cost;
            this.steps = steps;
        }
    }

    public static int cheapestFlight(int n, int[][] flights, int src, int dst, int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int[] dis = new int[n];
        for(int i = 0; i < n; i++){
            if(i != src){
                dis[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(src, 0, 0));
        while(!queue.isEmpty()){
            Info curr = queue.remove();
            if(curr.steps > k){
                break;
            }
            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.source;
                int v = e.destination;
                int c = e.cost;
                if(curr.cost + c < dis[v] && curr.steps <= k){
                    dis[v] = curr.cost + c;
                    queue.add(new Info(v, dis[v], curr.steps + 1));
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dis[dst];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int scr = 0, dst = 3, k = 1;
        System.out.print("Cost: "+ cheapestFlight(n, flights, scr, dst, k));
    }
}
