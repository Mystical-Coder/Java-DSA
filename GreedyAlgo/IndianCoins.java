package GreedyAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * IndianCoins
 */
public class IndianCoins {

    public static void main(String[] args) {
        int[] coins = {1, 5, 2, 10, 50, 20, 500, 2000, 100};
        Arrays.sort(coins);
        Scanner sc = new Scanner(System.in); 
        int val = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = coins.length - 1; i>= 0; i--){
            while(coins[i] <= val){
                list.add(coins[i]);
                val = val - coins[i];
                count++;
            }
        }
        System.out.println(list);
        System.out.println(count);
    }

}