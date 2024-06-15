package Hashing;

import java.util.HashSet;

public class SetAndUnion {
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        int intersection = 0, union = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++){
            set.add(arr2[i]);
        }
        union = set.size();

        set.clear();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i =0; i < arr2.length; i++){
            if(set.contains(arr2[i])){
                intersection++;
                set.remove(arr2[i]);
            }
        }
        System.out.print("Union: "+union+" Intersection: "+intersection);
    }
}
