package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KruskalsAlgo {

    public static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int cost;

        public Edge(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int v = 4;
    static int[] rank = new int[v];
    static int[] parent = new int[v];

    public static void init() {
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        } else if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

    public static void kruskal(ArrayList<Edge> edge, int v) {
        init();
        Collections.sort(edge);
        int count = 0, mstCost = 0;
        for (int i = 0; count < v - 1; i++) {
            Edge e = edge.get(i);
            int parA = find(e.source);
            int parB = find(e.destination);
            if (parA != parB) {
                union(e.source, e.destination);
                mstCost += e.cost;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edes = new ArrayList<>();
        createGraph(edes);
        kruskal(edes, v);
    }
}
