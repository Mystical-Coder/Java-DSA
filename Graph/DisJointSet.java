package Graph;

import java.util.ArrayList;
import java.util.List;

// Striver

public class DisJointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisJointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int x) {
        if (parent.get(x) == x) {
            return x;
        }
        int par = findParent(parent.get(x));
        parent.set(x, par);
        return parent.get(x);
    }

    public void unionByRank(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);

        if (uPar == vPar)
            return;

        else if (rank.get(uPar) < rank.get(vPar)) {
            parent.set(uPar, vPar);
        } else if (rank.get(vPar) < rank.get(uPar)) {
            parent.set(vPar, uPar);
        } else {
            parent.set(vPar, uPar);
            rank.set(uPar, rank.get(uPar) + 1);
        }
    }
}

class Main {
    public static void main(String[] args) {
        DisJointSet disJointSet = new DisJointSet(7);
        disJointSet.unionByRank(1, 2);
        disJointSet.unionByRank(2, 3);
        disJointSet.unionByRank(4, 5);
        disJointSet.unionByRank(6, 7);
        disJointSet.unionByRank(5, 6);

        if(disJointSet.findParent(3) == disJointSet.findParent(7)) System.out.println("same");
        else System.out.println("Not same");
        
        disJointSet.unionByRank(3, 7);
        
        if(disJointSet.findParent(3) == disJointSet.findParent(7)) System.out.println("same");
        else System.out.println("Not same");
    }    
}
