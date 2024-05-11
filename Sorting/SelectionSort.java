package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
