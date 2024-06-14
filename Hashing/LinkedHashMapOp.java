package Hashing;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapOp {
    public static void main(String[] args) { 
        LinkedHashMap<String , Integer> lm = new LinkedHashMap<>(); // Maintain sequence of input
        HashMap<String, Integer> map = new HashMap<>(); // Doesn't maintain
        
        lm.put("India", 10);
        lm.put("China", 9);
        lm.put("Italy", 4);

        map.put("India", 10);
        map.put("China", 9);
        map.put("Italy", 4);

        System.out.println(lm);
        System.out.println(map);
        
    }
}
