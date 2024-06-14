package Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapOp {
    public static void main(String[] args) { 
        LinkedHashMap<String , Integer> lm = new LinkedHashMap<>(); // Maintain sequence of input: Uses doubly linked list in bucket
        HashMap<String, Integer> map = new HashMap<>(); // Doesn't maintain: uses singly linked list in bucket array
        TreeMap<String, Integer> tm = new TreeMap<>(); // Sort based on keys: uses Red black trees in bucket array
        lm.put("India", 10);
        lm.put("China", 9);
        lm.put("Italy", 4);

        map.put("India", 10);
        map.put("China", 9);
        map.put("Italy", 4);

        tm.put("India", 10);
        tm.put("China", 9);
        tm.put("Italy", 4);



        System.out.println("Linked hash map: "+lm);
        System.out.println("Hash Map: "+map);
        System.out.println("Tree hash Map: "+tm);
        
    }
}
