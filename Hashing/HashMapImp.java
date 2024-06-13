package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImp {

    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N;
        private int n;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        public int searchLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int indx = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return indx;
                }
                indx++;
            }
            return -1;
        }

        public void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2 * N;

            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); i++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {  //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di != -1) {
                return true;
            }
            return false;
        }

        public V get(K key) { //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){  //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
        

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 20);
        map.put("China", 30);
        map.put("Russia", 10);
        map.put("Italy", 5);

        // ArrayList<String> keys = map.keySet();
        // for(String key : keys){
        //     System.out.println(key);
        // }
        System.out.println(map.remove("China"));
        System.out.println(map.containsKey("China"));
        // System.out.println(map.get("India"));

    }
}
