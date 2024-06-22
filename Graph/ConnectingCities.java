package Graph;

import java.util.PriorityQueue;

public class ConnectingCities {

    public static class Edge implements Comparable<Edge>{
        int v;
        int cost;
        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public static int connecting(int[][] cities){
        boolean[] vis = new boolean[cities.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        int cost = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                cost += curr.cost;
                for(int i = 0; i < cities[curr.v].length; i++){
                    if(cities[curr.v][i] != 0){
                        pq.add(new Edge(i, cities[curr.v][i]));
                    }
                }
            }
        }
        return cost;
    }


    public static void main(String[] args) {
        int cities[][] ={{0, 1, 2, 3, 4},
                        {1, 0, 5, 0, 7},
                        {2, 5, 0, 6, 0},
                        {3, 0, 6, 0, 0},
                        {4, 7, 0, 0, 0}};
        System.out.println("Cost: "+connecting(cities));
    }
}
