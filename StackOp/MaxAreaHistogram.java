package StackOp;

import java.util.Stack;

public class MaxAreaHistogram {

    public static int maxArea(int[] arr){
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Next smaller right
        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<>();

         // Next smaller left
         for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = arr.length;
            }else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int weight = nsr[i] - nsl[i] - 1;
            int curr = height * weight;
            max = Math.max(curr, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        int val = maxArea(arr);
        System.out.println("Maximum area: "+val);
    }
}
