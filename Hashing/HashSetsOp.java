package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetsOp {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(); // can add null value, order: any sequence, no duplicates;
        LinkedHashSet<String> lset = new LinkedHashSet<>(); // can add null value, order: same as input sequence, no duplicates;
        TreeSet<String> tset = new TreeSet<>(); // can't add null value, order: ascending, no dupilcates;
        
        set.add("India");
        set.add("Austrlia");
        set.add("USA");
        set.add("Englang");
        
        lset.add("India");
        lset.add("Austrlia");
        lset.add("USA");
        lset.add("Englang");
       
        tset.add("India");
        tset.add("Austrlia");
        tset.add("USA");
        tset.add("Englang");

        System.out.println(set);
        System.out.println(lset);
        System.out.println(tset);


    }
}
