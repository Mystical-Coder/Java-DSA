package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MaxLenChainPair
 */
public class MaxLenChainPair {

    public static void main(String[] args) {
        int[][] arr = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int maxChain = 1;
        int endChain = arr[0][1];
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] > endChain){
                maxChain++;
                endChain = arr[i][1];
            }
        }
        System.out.println(maxChain);
    }
}