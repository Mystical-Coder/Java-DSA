package Graph;

import java.util.ArrayList;

public class ArticulationPoint {

    public static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int[] dt, int[] low, boolean[] vis, int curr, int parent,
            int time, boolean[] ap) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.des;
            if (neigh == parent) {
                continue;
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, dt, low, vis, neigh, curr, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(parent != -1 && dt[curr] <= low[neigh]){
                   ap[curr] = true;
                }
                children++;
            }
        }
        if(parent == -1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge>[] graph, int v) {
        int[] dt = new int[v]; // discover time
        int[] low = new int[v]; // lower time
        boolean[] vis = new boolean[v]; // Visited
        boolean[] ap = new boolean[v];
        int time = 0;
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, dt, low, vis, i, -1, time, ap);
            }
        }

        for(int i = 0; i < v; i++){
            if(ap[i]){
                System.out.println("AP : "+ i);
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);
    }
}