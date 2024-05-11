package Sorting;

public class BubbleSort {

    public static void sort(int[] arr){
        for(int turn = 0; turn < arr.length - 1; turn++){
            int swap = 0;
            for(int j = 0; j < arr.length - 1 - turn; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        // int[] arr = {5, 4, 1, 3, 2};
        int[] arr = {1, 2, 3, 4, 5};
        sort(arr);
        for(int val : arr){
            System.out.print(val+" ");
        }
    }
}
