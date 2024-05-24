package Notes.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {

    public static void test1(){
        // Comparator<Integer> com = new Comparator<Integer>() {
        // public int compare(Integer i, Integer j){
        // return i%10 - j%10;
        // }
        // };

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(29);
        list.add(24);
        list.add(18);
        Collections.sort(list, (a, b) -> {
            return a - b; // Ascending order and b - a : descending order
        });
        System.out.println(list);
    }


    public static void test2(){
        int[][] arr = { { 100, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 1, 90 } };
        // Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        // Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for(int[] a : arr){
            System.out.println(a[0] + " "+a[1]);
        }
    }

    public static void test3(){
        Integer[] arr = {32, 23, 19, 10, 94 , 48};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list, (a, b) -> {
            return a - b;
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        test3();
    }
}
