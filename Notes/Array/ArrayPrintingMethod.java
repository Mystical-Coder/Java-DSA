package Notes.Array;

import java.util.*;

public class ArrayPrintingMethod {

    public static void toString(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void deepString(Integer[] arr){
        System.out.println(Arrays.deepToString(arr)); //Used By Wrapper class not primitive type
    }

    public static void asList(Integer[] arr){ // Use Wrapper class not primitive type
        System.err.println(Arrays.asList(arr));
    }

    public static void iterator(Integer[] arr){
        List<Integer> list = Arrays.asList(arr);
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }

    public static void stream(Integer[] arr){
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5};
        Integer[] arr1 = {2, 1, 3, 4, 5};
        // toString(arr);
        // deepString(arr1);
        // asList(arr1);
        // iterator(arr1);
        // stream(arr1);
    }
}
