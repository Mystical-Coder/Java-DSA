package SegmentTree;

public class SegmentTreeImpl {

    int[] st;     
    int[] lazy;   

    public SegmentTreeImpl(int n) {
        st = new int[4 * n];
        lazy = new int[4 * n];
    }

    public void build(int node, int l, int r, int[] arr) {
        if (l == r) {
            st[node] = arr[l];
        } else {
            int mid = (l + r) / 2;
            build(2 * node, l, mid, arr);
            build(2 * node + 1, mid + 1, r, arr);
            st[node] = st[2 * node] + st[2 * node + 1];
        }
    }

    private void applyLazy(int node, int l, int r) {
        if (lazy[node] != 0) {

            st[node] += (r - l + 1) * lazy[node];


            if (l != r) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            lazy[node] = 0; 
        }
    }

    public void updateRange(int node, int l, int r, int ql, int qr, int val) {

        applyLazy(node, l, r);


        if (qr < l || r < ql) return;

        if (ql <= l && r <= qr) {
            st[node] += (r - l + 1) * val;
            if (l != r) {
                lazy[2 * node] += val;
                lazy[2 * node + 1] += val;
            }
            return;
        }

        int mid = (l + r) / 2;
        updateRange(2 * node, l, mid, ql, qr, val);
        updateRange(2 * node + 1, mid + 1, r, ql, qr, val);
        st[node] = st[2 * node] + st[2 * node + 1];
    }

    public int query(int node, int l, int r, int ql, int qr) {
        applyLazy(node, l, r);

        if (qr < l || r < ql) return 0;

        if (ql <= l && r <= qr) return st[node];

        int mid = (l + r) / 2;
        int left = query(2 * node, l, mid, ql, qr);
        int right = query(2 * node + 1, mid + 1, r, ql, qr);
        return left + right;
    }

    public void printTree(int n) {
        System.out.print("Segment Tree: ");
        for (int i = 1; i < 4 * n; i++)
            System.out.print(st[i] + " ");
        System.out.println();
        System.out.print("Lazy Tree:    ");
        for (int i = 1; i < 4 * n; i++)
            System.out.print(lazy[i] + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, -2, 3};
        int n = arr.length;

        SegmentTreeImpl seg = new SegmentTreeImpl(n);
        seg.build(1, 0, n - 1, arr);

        System.out.println("Initial sum [0,4]: " + seg.query(1, 0, n - 1, 0, 4));
        seg.printTree(n);

        System.out.println("Add 10 to range [1,3]");
        seg.updateRange(1, 0, n - 1, 1, 3, 10);
        seg.printTree(n);

        System.out.println("Sum [0,4]: " + seg.query(1, 0, n - 1, 0, 4));
        System.out.println("Sum [2,3]: " + seg.query(1, 0, n - 1, 2, 3));
    }
}
