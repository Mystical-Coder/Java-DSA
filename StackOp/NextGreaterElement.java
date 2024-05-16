package StackOp;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void getAnswer(int[] arr, int[] ans){
        Stack<Integer> stack = new Stack<>();
        for(int i = ans.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] ans = new int[arr.length];
        getAnswer(arr, ans);
        System.out.println(Arrays.toString(ans));    
    }
}
