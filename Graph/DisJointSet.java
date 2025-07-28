package Graph;

import java.util.ArrayList;
import java.util.List;

// Striver

public class DisJointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisJointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int uPar = findParent(u);
        int vPar = findParent(v);

        if (uPar == vPar)
            return;

        else if (size.get(uPar) < size.get(vPar)) {
            parent.set(uPar, vPar);
            size.set(vPar, size.get(vPar) + size.get(uPar));
        } else {
            parent.set(vPar, uPar);
            size.set(uPar, size.get(vPar) + size.get(uPar));
        }
    }

}

class UnionByRank {
    public static void main(String[] args) {
        DisJointSet disJointSet = new DisJointSet(7);
        disJointSet.unionByRank(1, 2);
        disJointSet.unionByRank(2, 3);
        disJointSet.unionByRank(4, 5);
        disJointSet.unionByRank(6, 7);
        disJointSet.unionByRank(5, 6);

        if (disJointSet.findParent(3) == disJointSet.findParent(7))
            System.out.println("same");
        else
            System.out.println("Not same");

        disJointSet.unionByRank(3, 7);

        if (disJointSet.findParent(3) == disJointSet.findParent(7))
            System.out.println("same");
        else
            System.out.println("Not same");
    }
}

class  UnionBySize{

    public static void main(String[] args) {
         DisJointSet disJointSet = new DisJointSet(7);
        disJointSet.unionBySize(1, 2);
        disJointSet.unionBySize(2, 3);
        disJointSet.unionBySize(4, 5);
        disJointSet.unionBySize(6, 7);
        disJointSet.unionBySize(5, 6);

        if (disJointSet.findParent(3) == disJointSet.findParent(7))
            System.out.println("same");
        else
            System.out.println("Not same");

        disJointSet.unionByRank(3, 7);

        if (disJointSet.findParent(3) == disJointSet.findParent(7))
            System.out.println("same");
        else
            System.out.println("Not same");
    }
}
