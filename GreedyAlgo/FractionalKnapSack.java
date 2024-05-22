package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

import BackTracking.Array;

public class FractionalKnapSack {

    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int w = 50;

        double[][] ratio = new double[weight.length][2];
        for(int i = 0; i < weight.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        int sum = 0;

        for(int i = weight.length -1; i >= 0; i--){
            int indx = (int)ratio[i][0];
            if(capacity >= weight[indx]){
                sum += value[indx];
                capacity -= weight[indx];
            }else{
                sum += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Sum : "+ sum);
    }
}
