package GreedyAlgo;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProb {
    public static void main(String[] args) {
        Integer[] costVer = {2, 1, 3, 1, 4}; // m - 1
        Integer[] costHor = {4, 1, 2}; //n - 1
        
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        
        while(h < costHor.length && v < costVer.length){
            if(costVer[v] <= costHor[h]){
                cost += (costHor[h] * vp);
                h++;
                hp++;
            }else{
                cost += (costVer[v] * hp);
                v++;
                vp++;
            }
        }

        while(h < costHor.length){
            cost += (costHor[h] * vp);
            h++;
            hp++;
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            v++;
            vp++;
        }

        System.out.println("Total cose: " + cost);

    }
}
