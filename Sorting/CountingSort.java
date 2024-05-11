package Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void sort(int[] arr){
        
        int larget = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            larget = Math.max(larget, arr[i]);
        }

        int[] count = new int[larget + 1];

        for(int val : arr){
            count[val]++;
        }

        int j = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 3, 1, 7, 4, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));        
    }
}
