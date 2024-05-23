package Notes.ComparableAndComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import BackTracking.Array;

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
        double[][] arr = {{1,2},{3,4},{1,1},{8,2}};
        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
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
