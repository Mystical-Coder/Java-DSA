package StackOp;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] getSpan(int[] arr){
        int[] span  = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1; 
        stack.push(0);
        for(int i = 1; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i] = i + 1;
            }else{
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 85, 100};
        int[] span = getSpan(arr);
        System.out.println(Arrays.toString(span));
    }
}
