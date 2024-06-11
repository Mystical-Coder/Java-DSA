package Heaps;

import java.util.PriorityQueue;

/**
 * SlidingWindowMax
 */
public class SlidingWindowMax {

    public static class Info implements Comparable<Info> {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info i2) {
            return i2.val - this.val;
        }

    }

    public static void main(String[] args) { // O(nlogk)
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int k = 3;
        int len = arr.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new Info(arr[i], i));
        }
        res[0] = pq.peek().val;
        for (int i = k; i < len; i++) {
            if (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Info(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] +" ");
        }
    }

}